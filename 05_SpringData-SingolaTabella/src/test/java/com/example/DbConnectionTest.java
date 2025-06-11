package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.ContattoRepository;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest // Questa annotazione carica il contesto completo di Spring Boot per il test
@Transactional // Opzionale per questo test specifico (non modifica dati), ma buona pratica per test DB
class DbConnectionTest {

    @Autowired
    private ContattoRepository contattoRepository;

    @Test
    void testDatabaseConnectionAndTableAccess() {
        System.out.println("--- Esecuzione test JUnit: testDatabaseConnectionAndTableAccess ---");

        // Questo test verifica che il repository sia stato iniettato correttamente (quindi il contesto Spring è ok)
        assertNotNull(contattoRepository, "Il ContattoRepository non dovrebbe essere null.");

        // Tenta di eseguire un'operazione semplice sul database.
        // Se la connessione è stabilita, il database 'Rubrica' esiste e la tabella 'Contatti' è accessibile,
        // questa operazione dovrebbe avere successo senza lanciare eccezioni.
        // Usiamo AssertJ's assertThatNoException() per verificarlo in modo pulito.
        assertThatNoException().isThrownBy(() -> {
            long count = contattoRepository.count();
            System.out.println("Connessione al database MySQL riuscita tramite JUnit!");
            System.out.println("Trovati " + count + " contatti nella tabella 'Contatti'.");
            System.out.println("Il database 'Rubrica' è accessibile e la tabella 'Contatti' è stata trovata.");
        });

        System.out.println("--- Test JUnit completato con successo ---");
    }
}