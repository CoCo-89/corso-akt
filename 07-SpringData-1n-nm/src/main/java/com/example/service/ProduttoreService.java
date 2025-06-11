package com.example.service;

import com.example.entity.Produttore;
import com.example.repository.ProduttoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Indica a Spring che questa è una classe Service
public class ProduttoreService {

    private final ProduttoreRepository produttoreRepository;

    public ProduttoreService(ProduttoreRepository produttoreRepository) {
        this.produttoreRepository = produttoreRepository;
    }



    // Salva un nuovo produttore o aggiorna uno esistente
    @Transactional
    public Produttore saveProduttore(Produttore produttore) {
        return produttoreRepository.save(produttore);
    }

    // Trova un produttore per ID
    @Transactional(readOnly = true) 
    public Optional<Produttore> getProduttoreById(Long id) {
        return produttoreRepository.findById(id);
    }

    // Trova tutti i produttori
    @Transactional(readOnly = true)
    public List<Produttore> getAllProduttori() {
        return produttoreRepository.findAll();
    }

    // Elimina un produttore per ID
    @Transactional
    public void deleteProduttore(Long id) {
        produttoreRepository.deleteById(id);
    }

    // Verifica l'esistenza di un produttore prima di aggiungere/modificare
    @Transactional(readOnly = true)
    public boolean existsProduttore(Long id) {
        return produttoreRepository.existsById(id);
    }
}