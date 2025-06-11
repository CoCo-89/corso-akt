package com.example.repository;

import com.example.entity.Videogioco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideogiocoRepository extends JpaRepository<Videogioco, Long> {

 
/*	
	Esempi di metodi di utilità per l'applicazione - in questo caso li lasciamo commentati
	per concentrarci sulle funzionalità di base già fornite di default dall'interfaccia JPA
	
	
	// Metodo aggiuntivo: Trova videogiochi per titolo (case-insensitive, contenente)
    List<Videogioco> findByTitoloContainingIgnoreCase(String titolo);

    // Metodo aggiuntivo: Trova videogiochi rilasciati in un certo anno
    List<Videogioco> findByAnnoRilascio(Integer anno);

    // Metodo aggiuntivo: Trova videogiochi per l'ID del produttore associato
    List<Videogioco> findByProduttoreIdProduttore(Long idProduttore);

    // Metodo aggiuntivo: Trova videogiochi che sono stati sviluppati da un certo sviluppatore (tramite ID)
    // Questa query attraversa la relazione ManyToMany
    List<Videogioco> findBySviluppatoriIdSviluppatore(Long idSviluppatore);

    // Metodo aggiuntivo: Trova videogiochi che sono stati sviluppati da un certo sviluppatore (tramite nome)
    List<Videogioco> findBySviluppatoriNomeSviluppatoreContainingIgnoreCase(String nomeSviluppatore);
*/ 
}