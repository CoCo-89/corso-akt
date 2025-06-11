package com.example.repository;

import com.example.entity.Produttore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduttoreRepository extends JpaRepository<Produttore, Long> {

/* 	Anche questi metodi sono superflui e per ora possiamo non includerli
 	per non complicare troppo il codice
 
	
    // Metodo aggiuntivo: Trova un produttore per nome esatto
    Produttore findByNomeProduttore(String nomeProduttore);

    // Metodo aggiuntivo: Verifica se un produttore esiste già per nome
    boolean existsByNomeProduttore(String nomeProduttore);
*/
}