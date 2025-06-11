package it.akt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akt.model.Fumetto;
import it.akt.repository.FumettoRepository;


@Service
public class FumettoService {
	
	private final FumettoRepository fumettoRepository;
	
	public FumettoService(FumettoRepository fumettoRepository) {
		this.fumettoRepository = fumettoRepository;
	}
	
	@Transactional
	public Fumetto saveFumetto (Fumetto fumetto) {
		return fumettoRepository.save(fumetto);
	}
	
//	@Transactional(readOnly = true)
//	public List<Fumetto> findByTitolo() {
//		return fumettoRepository.findByTitolo("titolo");
//	}
	
	@Transactional(readOnly = true)
	public List<Fumetto> getAllFumetti() {
		return fumettoRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<Fumetto> getFumettoById(Integer id) {
		return fumettoRepository.findById(id);
	}
	
	@Transactional
	public void deleteFumetto(Integer id) {
		fumettoRepository.deleteById(id);
	}

}
