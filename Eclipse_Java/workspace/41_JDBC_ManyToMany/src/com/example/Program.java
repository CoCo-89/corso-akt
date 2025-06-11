package com.example;

import com.example.dto.*;
import com.example.models.*;
import com.example.service.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Program {

	private static final String HOST = "jdbc:mysql://localhost:3306/Biblioteca?serverTimezone=Europe/Rome";
	private static final String USER = "root"; 
    private static final String PASS = "1234"; 

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Ottiene una connessione al database
            connection = DriverManager.getConnection(HOST, USER, PASS);

            // Crea istanze dei servizi
            LibroService libroService = new LibroService(connection);
            AutoreService autoreService = new AutoreService(connection);
            EditoreService editoreService = new EditoreService(connection);

            System.out.println("--- Operazioni di esempio sulla tabella Libri ---");

            // Creazione di un nuovo libro
            Libro nuovoLibro = new Libro(0, "Il Viaggio Inaspettato", 2023, 1);
            List<Integer> autoriNuovoLibro = Arrays.asList(1); // Associa all'autore con ID 1
            if (libroService.createLibro(nuovoLibro, autoriNuovoLibro)) {
                System.out.println("Libro creato con successo.");
            } else {
                System.out.println("Errore durante la creazione del libro.");
            }

            // Recupero di un libro completo per ID
            Optional<LibroCompletoDTO> libroCompleto = libroService.getLibroCompletoById(1);
            libroCompleto.ifPresentOrElse(
                    dto -> System.out.println("Libro completo (ID 1): " + dto),
                    () -> System.out.println("Libro con ID 1 non trovato.")
            );

            // Recupero di tutti i libri completi
            List<LibroCompletoDTO> tuttiLibri = libroService.getAllLibriCompleti();
            System.out.println("Tutti i libri completi:");
            tuttiLibri.forEach(System.out::println);

         // Aggiornamento di un libro
            Optional<LibroCompletoDTO> libroDaAggiornareOptional = libroService.getLibroCompletoById(2);
            libroDaAggiornareOptional.ifPresent(libroCompletoDaAggiornare -> {
                Libro libroDaAggiornare = new Libro(
                        libroCompletoDaAggiornare.getIdLibro(),
                        libroCompletoDaAggiornare.getTitolo(),
                        1815, // Nuovo anno
                        libroCompletoDaAggiornare.getEditore().getIdEditore() // Manteniamo l'editore
                );
                List<Integer> nuoviAutori = Arrays.asList(2, 3); // Riassegna autori con ID 2 e 3
                try {
                    if (libroService.updateLibro(libroDaAggiornare, nuoviAutori)) {
                        System.out.println("Libro con ID 2 aggiornato con successo.");
                    } else {
                        System.out.println("Errore durante l'aggiornamento del libro con ID 2.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            // Eliminazione di un libro
            if (libroService.deleteLibro(7)) {
                System.out.println("Libro con ID 7 eliminato con successo.");
            } else {
                System.out.println("Errore durante l'eliminazione del libro con ID 7.");
            }

            System.out.println("\n--- Operazioni di esempio sulla tabella Autori ---");

            // Creazione di un nuovo autore
            Autore nuovoAutore = new Autore(0, "Neil", "Gaiman");
            if (autoreService.createAutore(nuovoAutore)) {
                System.out.println("Autore creato con successo.");
            } else {
                System.out.println("Errore durante la creazione dell'autore.");
            }

            // Recupero di un autore per ID
            Optional<Autore> autoreRecuperato = autoreService.getAutoreById(3);
            autoreRecuperato.ifPresentOrElse(
                    autore -> System.out.println("Autore (ID 3): " + autore),
                    () -> System.out.println("Autore con ID 3 non trovato.")
            );

            // Recupero di un autore con i suoi libri
            Optional<AutoreConLibriDTO> autoreConLibri = autoreService.getAutoreConLibri(1);
            autoreConLibri.ifPresentOrElse(
                    dto -> {
                        System.out.println("Autore con i suoi libri (ID 1): " + dto.getAutore());
                        dto.getLibri().forEach(libro -> System.out.println("- " + libro.getTitolo()));
                    },
                    () -> System.out.println("Autore con ID 1 non trovato.")
            );

            // Eliminazione di un autore
            if (autoreService.deleteAutore(8)) {
                System.out.println("Autore con ID 8 eliminato con successo.");
            } else {
                System.out.println("Errore durante l'eliminazione dell'autore con ID 8.");
            }

            System.out.println("\n--- Operazioni di esempio sulla tabella Editori ---");

            // Creazione di un nuovo editore
            Editore nuovoEditore = new Editore(0, "Newton Compton", "Roma");
            if (editoreService.createEditore(nuovoEditore)) {
                System.out.println("Editore creato con successo.");
            } else {
                System.out.println("Errore durante la creazione dell'editore.");
            }

            // Recupero di un editore per ID
            Optional<Editore> editoreRecuperato = editoreService.getEditoreById(1);
            editoreRecuperato.ifPresentOrElse(
                    editore -> System.out.println("Editore (ID 1): " + editore),
                    () -> System.out.println("Editore con ID 1 non trovato.")
            );

            // Eliminazione di un editore
            if (editoreService.deleteEditore(5)) {  
                System.out.println("Editore con ID 5 eliminato con successo.");
            } else {
                System.out.println("Errore durante l'eliminazione dell'editore con ID 5.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Chiudi la connessione nel blocco finally per assicurarti che venga sempre chiusa
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}