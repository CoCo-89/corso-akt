package com.example.service;

import com.example.dao.AutoreDAO;
import com.example.dao.LibroAutoreDAO;
import com.example.dao.LibroDAO;
import com.example.dto.AutoreConLibriDTO;
import com.example.models.Autore;
import com.example.models.Libro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutoreService {

    private final AutoreDAO autoreDAO;
    private final LibroAutoreDAO libroAutoreDAO;
    private final LibroDAO libroDAO;
    private final Connection connection;

    public AutoreService(Connection connection) {
        this.connection = connection;
        this.autoreDAO = new AutoreDAO(connection);
        this.libroAutoreDAO = new LibroAutoreDAO(connection);
        this.libroDAO = new LibroDAO(connection);
    }

    public Optional<Autore> getAutoreById(int id) throws SQLException {
        return autoreDAO.getById(id);
    }

    public List<Autore> getAllAutori() throws SQLException {
        return autoreDAO.getAll();
    }

    public boolean createAutore(Autore autore) throws SQLException {
        return autoreDAO.create(autore);
    }

    public boolean updateAutore(Autore autore) throws SQLException {
        return autoreDAO.update(autore);
    }

    public boolean deleteAutore(int id) throws SQLException {
        // Prima di eliminare l'autore, rimuovi le sue associazioni con i libri
        libroAutoreDAO.deleteByAutoreId(id);
        return autoreDAO.delete(id);
    }

    /**
     * Recupera un autore completo con la lista dei suoi libri.
     *
     * @param autoreId L'ID dell'autore.
     * @return Un Optional contenente un oggetto AutoreConLibriDTO se l'autore viene trovato,
     * altrimenti un Optional vuoto.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    public Optional<AutoreConLibriDTO> getAutoreConLibri(int autoreId) throws SQLException {
        Optional<Autore> autoreOptional = autoreDAO.getById(autoreId);
        if (autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            List<Integer> libroIds = new ArrayList<>();
            // Recupera gli ID dei libri scritti dall'autore
            String sql = "SELECT id_libro FROM Libro_Autore WHERE id_autore = ?";
            try (var pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, autoreId);
                var rs = pstmt.executeQuery();
                while (rs.next()) {
                    libroIds.add(rs.getInt("id_libro"));
                }
            }
            // Recupera gli oggetti Libro completi utilizzando gli ID
            List<Libro> libri = new ArrayList<>();
            for (int libroId : libroIds) {
                libroDAO.getById(libroId).ifPresent(libri::add);
            }
            return Optional.of(new AutoreConLibriDTO(autore, libri));
        }
        return Optional.empty();
    }
}