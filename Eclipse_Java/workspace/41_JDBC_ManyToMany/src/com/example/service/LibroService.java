package com.example.service;

import com.example.dao.AutoreDAO;
import com.example.dao.EditoreDAO;
import com.example.dao.LibroAutoreDAO;
import com.example.dao.LibroDAO;
import com.example.dto.LibroCompletoDTO;
import com.example.models.Autore;
import com.example.models.Libro;
import com.example.models.Editore;
import com.example.models.LibroAutore;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibroService {

    private final LibroDAO libroDAO; // DAO per l'accesso alla tabella Libri
    private final AutoreDAO autoreDAO; // DAO per l'accesso alla tabella Autori
    private final EditoreDAO editoreDAO; // DAO per l'accesso alla tabella Editori
    private final LibroAutoreDAO libroAutoreDAO; // DAO per l'accesso alla tabella di collegamento Libro_Autore
    private final Connection connection; // Oggetto Connection per interagire con il database (gestito esternamente)

    // Costruttore che riceve l'oggetto Connection. Questo permette di gestire la connessione al di fuori del Service,
    // ad esempio tramite un Connection Pool o un framework di gestione delle transazioni.
    public LibroService(Connection connection) {
        this.connection = connection;
        this.libroDAO = new LibroDAO(connection);
        this.autoreDAO = new AutoreDAO(connection);
        this.editoreDAO = new EditoreDAO(connection);
        this.libroAutoreDAO = new LibroAutoreDAO(connection);
    }

    /**
     * Recupera un libro completo dal database tramite il suo ID.
     * Il libro completo include il titolo, l'anno, l'editore e la lista degli autori.
     *
     * @param id L'ID del libro da recuperare.
     * @return Un Optional contenente un oggetto LibroCompletoDTO se il libro viene trovato,
     * altrimenti un Optional vuoto.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    public Optional<LibroCompletoDTO> getLibroCompletoById(int id) throws SQLException {
        // Recupera l'oggetto Libro base tramite il LibroDAO
        Optional<Libro> libroOptional = libroDAO.getById(id);

        // Se il libro esiste
        if (libroOptional.isPresent()) {
            Libro libro = libroOptional.get();

            // Recupera l'Editore del libro tramite l'EditoreDAO utilizzando l'id_editore del libro
            Optional<Editore> editoreOptional = editoreDAO.getById(libro.getIdEditore());

            // Recupera la lista degli ID degli Autori collegati al libro tramite la tabella Libro_Autore
            List<Integer> autoriIds = libroAutoreDAO.getAutoriIdsByLibroId(libro.getIdLibro());

            // Crea una lista per contenere gli oggetti Autore
            List<Autore> autori = new ArrayList<>();

            // Per ogni ID autore, recupera l'oggetto Autore completo tramite l'AutoreDAO
            for (int autoreId : autoriIds) {
                Optional<Autore> autoreOptional = autoreDAO.getById(autoreId);
                // Se l'autore viene trovato, lo aggiunge alla lista degli autori
                autoreOptional.ifPresent(autori::add);
            }

            // Se l'editore è stato trovato, crea e restituisce un LibroCompletoDTO
            if (editoreOptional.isPresent()) {
                return Optional.of(new LibroCompletoDTO(
                        libro.getIdLibro(),
                        libro.getTitolo(),
                        libro.getAnno(),
                        editoreOptional.get(),
                        autori
                ));
            }
            // Se l'editore non viene trovato (potrebbe essere un errore nel database),
            // restituiamo un Optional vuoto per indicare che non si possono avere i dati completi.
            // Potrebbe essere gestito diversamente a seconda dei requisiti (es. lanciare un'eccezione).
        }
        // Se il libro base non viene trovato, restituisce un Optional vuoto
        return Optional.empty();
    }

    /**
     * Recupera tutti i libri completi dal database.
     *
     * @return Una lista di oggetti LibroCompletoDTO. Se non ci sono libri, la lista sarà vuota.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    public List<LibroCompletoDTO> getAllLibriCompleti() throws SQLException {
        List<Libro> tuttiLibri = libroDAO.getAll();
        List<LibroCompletoDTO> libriCompleti = new ArrayList<>();

        for (Libro libro : tuttiLibri) {
            Optional<LibroCompletoDTO> libroCompletoOptional = getLibroCompletoById(libro.getIdLibro());
            libroCompletoOptional.ifPresent(libriCompleti::add);
        }

        return libriCompleti;
    }

    /**
     * Crea un nuovo libro nel database.
     *
     * @param libro Il libro da creare (l'ID verrà generato dal database).
     * @param autoriIds La lista degli ID degli autori da associare al libro.
     * @return true se la creazione ha avuto successo, false altrimenti.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    public boolean createLibro(Libro libro, List<Integer> autoriIds) throws SQLException {
        // Crea prima il libro nella tabella Libri
        if (libroDAO.create(libro)) {
            // Dopo la creazione, recupera l'ID generato per il libro (dipende dall'implementazione del DAO e del DB)
            Optional<Libro> libroCreatoOptional = libroDAO.getAll().stream()
                    .filter(l -> l.getTitolo().equals(libro.getTitolo()) && l.getAnno() == libro.getAnno() 
                    	&& l.getIdEditore() == libro.getIdEditore())                    
                    .findFirst();

            if (libroCreatoOptional.isPresent()) {
                int libroId = libroCreatoOptional.get().getIdLibro();
                // Associa gli autori al libro nella tabella Libro_Autore
                for (int autoreId : autoriIds) {
                    LibroAutore libroAutore = new LibroAutore(libroId, autoreId);
                    libroAutoreDAO.create(libroAutore);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Aggiorna i dati di un libro esistente nel database e le sue associazioni con gli autori.
     *
     * @param libro       Il libro da aggiornare (deve contenere l'ID del libro).
     * @param nuoviAutoriIds La nuova lista degli ID degli autori da associare al libro.
     * @return true se l'aggiornamento ha avuto successo, false altrimenti.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    public boolean updateLibro(Libro libro, List<Integer> nuoviAutoriIds) throws SQLException {
        // Aggiorna i dati base del libro nella tabella Libri
        if (libroDAO.update(libro)) {
            // Rimuovi tutte le associazioni esistenti per questo libro nella tabella Libro_Autore
            libroAutoreDAO.deleteByLibroId(libro.getIdLibro());
            // Inserisci le nuove associazioni autore-libro
            for (int autoreId : nuoviAutoriIds) {
                LibroAutore libroAutore = new LibroAutore(libro.getIdLibro(), autoreId);
                libroAutoreDAO.create(libroAutore);
            }
            return true;
        }
        return false;
    }

    /**
     * Elimina un libro dal database e tutte le sue associazioni con gli autori.
     *
     * @param id L'ID del libro da eliminare.
     * @return true se l'eliminazione ha avuto successo, false altrimenti.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    public boolean deleteLibro(int id) throws SQLException {
        // Elimina prima le associazioni nella tabella Libro_Autore
        libroAutoreDAO.deleteByLibroId(id);
        // Poi elimina il libro dalla tabella Libri
        return libroDAO.delete(id);
    }

    // Altri metodi di servizio per la gestione dei libri potrebbero essere aggiunti qui,
    // come la ricerca di libri per titolo, autore, editore, ecc.
}