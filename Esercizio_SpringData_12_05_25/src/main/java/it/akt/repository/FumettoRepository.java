package it.akt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.akt.model.Fumetto;

@Repository
public interface FumettoRepository extends JpaRepository<Fumetto, Integer>{
	
//	List<Fumetto> findByTitolo (String titolo);
//	
//	List<Fumetto> findByAutore (String autore);
//	
//	List<Fumetto> findByAnno (int anno);

}
