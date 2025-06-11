package com.example.repository;

import com.example.model.Contatto; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository // Questa annotazione è opzionale ma consigliata per indicare che serve a JPA
public interface ContattoRepository extends JpaRepository<Contatto, Integer> {
/*   
   	JpaRepository<T, ID> usa 2 Generic:
    	• T 	è il tipo dell'entità con cui il repository lavorerà (Contatto)
    	• ID 	è il tipo della chiave primaria dell'entità (Integer per idContatto)

    Spring Data JPA fornisce automaticamente i seguenti metodi di base:
    - save(Contatto entity): 	Salva (o aggiorna) un'entità.
    - findById(Integer id): 	Recupera un'entità per il suo ID. Restituisce Optional<Contatto>.
    - findAll(): 				Recupera tutte le entità.
    - deleteById(Integer id): 	Elimina un'entità per il suo ID.
    - count(): 					Conta il numero totale di entità.
    E molti altri...

    E' possibile definire metodi di query personalizzati semplicemente 
    dichiarandoli nell'interfaccia.
    Spring Data JPA genera l'implementazione delle query in base al nome del metodo.
*/
	
// Esempio di query basate sul nome del metodo:
	
    // Trova tutti i contatti con un nome specifico
    List<Contatto> findByNome(String nome);

    // Trova tutti i contatti con un cognome specifico
    List<Contatto> findByCognome(String cognome);

    // Trova un contatto per il numero di telefono (assumendo che sia unico, usa Optional)
    Optional<Contatto> findByTel(String tel);

    // Trova un contatto per l'indirizzo email (assumendo che sia unico, usa Optional)
    Optional<Contatto> findByMail(String mail);

    // Trova contatti il cui nome inizia con una stringa specifica (case-insensitive)
    List<Contatto> findByNomeStartingWithIgnoreCase(String prefix);

    // Trova contatti la cui mail contiene una certa stringa (case-insensitive)
    List<Contatto> findByMailContainingIgnoreCase(String keyword);

    // Trova contatti nati prima di una certa data
    List<Contatto> findByDataNascitaBefore(LocalDate date);

    // Trova contatti con nome o cognome che inizia con una stringa specifica
    List<Contatto> findByNomeStartingWithOrCognomeStartingWith(String nomePrefix, String cognomePrefix);


}