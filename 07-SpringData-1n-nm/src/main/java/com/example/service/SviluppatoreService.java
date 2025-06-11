package com.example.service;

import com.example.entity.Sviluppatore;
import com.example.repository.SviluppatoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SviluppatoreService {

    private final SviluppatoreRepository sviluppatoreRepository;

    public SviluppatoreService(SviluppatoreRepository sviluppatoreRepository) {
        this.sviluppatoreRepository = sviluppatoreRepository;
    }

    // Salva un nuovo sviluppatore o aggiorna uno esistente
    @Transactional
    public Sviluppatore saveSviluppatore(Sviluppatore sviluppatore) {
        return sviluppatoreRepository.save(sviluppatore);
    }

    // Trova uno sviluppatore per ID
    @Transactional(readOnly = true)
    public Optional<Sviluppatore> getSviluppatoreById(Long id) {
        return sviluppatoreRepository.findById(id);
    }

    // Trova tutti gli sviluppatori
    @Transactional(readOnly = true)
    public List<Sviluppatore> getAllSviluppatori() {
        return sviluppatoreRepository.findAll();
    }

    // Elimina uno sviluppatore per ID
    @Transactional
    public void deleteSviluppatore(Long id) {
        sviluppatoreRepository.deleteById(id);
    }

    // Metodo per verificare l'esistenza di uno sviluppatore
    @Transactional(readOnly = true)
    public boolean existsSviluppatore(Long id) {
        return sviluppatoreRepository.existsById(id);
    }
}