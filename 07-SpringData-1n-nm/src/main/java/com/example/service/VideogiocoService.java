package com.example.service;

import com.example.entity.Videogioco;
import com.example.entity.Produttore;
import com.example.entity.Sviluppatore;
import com.example.repository.VideogiocoRepository;
import com.example.repository.ProduttoreRepository; 
import com.example.repository.SviluppatoreRepository; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VideogiocoService {

	//Campi
    private final VideogiocoRepository videogiocoRepository;
    private final ProduttoreRepository produttoreRepository; 
    private final SviluppatoreRepository sviluppatoreRepository; 

    //Costruttore con @Autowired implicito
    public VideogiocoService(VideogiocoRepository videogiocoRepository,
                             ProduttoreRepository produttoreRepository,
                             SviluppatoreRepository sviluppatoreRepository) {
        this.videogiocoRepository = videogiocoRepository;
        this.produttoreRepository = produttoreRepository;
        this.sviluppatoreRepository = sviluppatoreRepository;
    }

    
    
// METODI DI SERVIZIO:
    
    // Salva un nuovo videogioco o aggiorna uno esistente
    @Transactional
    public Videogioco saveVideogioco(Videogioco videogioco) {
        // Logica di business aggiuntiva qui se necessaria
        return videogiocoRepository.save(videogioco);
    }

    // Trova un videogioco per ID
    @Transactional(readOnly = true)
    public Optional<Videogioco> getVideogiocoById(Long id) {
        return videogiocoRepository.findById(id);
    }

    // Trova tutti i videogiochi
    @Transactional(readOnly = true)
    public List<Videogioco> getAllVideogiochi() {
        return videogiocoRepository.findAll();
    }

    // Elimina un videogioco per ID
    @Transactional
    public void deleteVideogioco(Long id) {
        videogiocoRepository.deleteById(id);
    }

    // Metodo per associare un produttore a un videogioco esistente
    @Transactional
    public Optional<Videogioco> assignProduttoreToVideogioco(Long videogiocoId, Long produttoreId) {
        Optional<Videogioco> optionalVideogioco = videogiocoRepository.findById(videogiocoId);
        Optional<Produttore> optionalProduttore = produttoreRepository.findById(produttoreId);

        if (optionalVideogioco.isPresent() && optionalProduttore.isPresent()) {
            Videogioco videogioco = optionalVideogioco.get();
            Produttore produttore = optionalProduttore.get();

            videogioco.setProduttore(produttore);
            produttore.addVideogioco(videogioco); 
/*            
Il codice produttore.addVideogioco(videogioco); serve per:

	• Mantenere gli oggetti Java coerenti in memoria: se carichiamo un Produttore, gli assegnamo 
				un Videogioco e poi lo salvi, ci aspettiamo che il Produttore "sappia" di avere 
				quel Videogioco associato.
	• È una buona pratica per le relazioni bidirezionali, anche se JPA si occupa del salvataggio 
				sul database tramite l'entità "owner" della relazione (Videogioco in questo caso).
				L'entità "Owner" è l'entità che detiene la Foreign Key nella tabella del database
*/            return Optional.of(videogiocoRepository.save(videogioco));
        }
        return Optional.empty();
    }

    // Metodo per associare uno o più sviluppatori a un videogioco esistente
    @Transactional
    public Optional<Videogioco> assignSviluppatoriToVideogioco(Long videogiocoId, List<Long> sviluppatoreIds) {
        Optional<Videogioco> optionalVideogioco = videogiocoRepository.findById(videogiocoId);

        if (optionalVideogioco.isPresent()) {
            Videogioco videogioco = optionalVideogioco.get();
            
            // Recupera gli sviluppatori esistenti e li associa
            Set<Sviluppatore> nuoviSviluppatori = sviluppatoreIds.stream()
                .map(sviluppatoreRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

            // Aggiungi gli sviluppatori al videogioco (gestendo la bidirezionalità)
            nuoviSviluppatori.forEach(videogioco::addSviluppatore);
            
            return Optional.of(videogiocoRepository.save(videogioco));
        }
        return Optional.empty();
    }
    
    // Metodo per rimuovere un'associazione sviluppatore-videogioco
    @Transactional
    public Optional<Videogioco> removeSviluppatoreFromVideogioco(Long videogiocoId, Long sviluppatoreId) {
        Optional<Videogioco> optionalVideogioco = videogiocoRepository.findById(videogiocoId);
        Optional<Sviluppatore> optionalSviluppatore = sviluppatoreRepository.findById(sviluppatoreId);

        if (optionalVideogioco.isPresent() && optionalSviluppatore.isPresent()) {
            Videogioco videogioco = optionalVideogioco.get();
            Sviluppatore sviluppatore = optionalSviluppatore.get();

            videogioco.removeSviluppatore(sviluppatore); // Gestisce la bidirezionalità

            return Optional.of(videogiocoRepository.save(videogioco));
        }
        return Optional.empty();
    }
}