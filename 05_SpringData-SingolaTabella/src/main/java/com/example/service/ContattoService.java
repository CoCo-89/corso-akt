package com.example.service;

import com.example.model.Contatto;
import com.example.repository.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service 
public class ContattoService {

    private final ContattoRepository contattoRepository; // Dichiarazione del repository

    // Iniezione delle dipendenze tramite costruttore (preferibile a @Autowired sul campo)
    //@Autowired   con un unico costruttore, l'annotazione può essere omessa
    public ContattoService(ContattoRepository contattoRepository) {
        this.contattoRepository = contattoRepository;
    }

    
    
    // --- Operazioni CRUD di base ---

    @Transactional(readOnly = true) // Indica che questa operazione è di sola lettura e non modifica il DB.
                                    // Migliora le performance e previene modifiche accidentali.
    public List<Contatto> getAllContatti() {
        return contattoRepository.findAll();  	//chiamo l'istanza locale del repository, che mi permette di 
        										//invocare i metodi definiti nel repository
    }

    
    @Transactional(readOnly = true)
    public Optional<Contatto> getContattoById(Integer id) {
        return contattoRepository.findById(id);
    }

   
    @Transactional // Le modifiche (save, update, delete) richiedono una transazione per commit o rollback.
    public Contatto saveContatto(Contatto contatto) {
 // Qui potremmo aggiungere logica di business, come la validazione ed altri controlli
         if (contatto.getTel() == null || contatto.getTel().isEmpty()) {
             throw new IllegalArgumentException("Il numero di telefono è obbligatorio.");
         }
         if (contatto.getNome() == null && contatto.getCognome() == null) {
              throw new IllegalArgumentException("Deve essere fornito almeno un nome o un cognome.");
         }
        return contattoRepository.save(contatto);
    }
    

    @Transactional
    public Contatto updateContatto(Integer id, Contatto updatedContatto) {
        Optional<Contatto> existingContattoOpt = contattoRepository.findById(id);

        if (existingContattoOpt.isPresent()) {
            Contatto existingContatto = existingContattoOpt.get();
            // Aggiorna solo i campi che sono stati forniti in updatedContatto
            if (updatedContatto.getNome() != null) {
                existingContatto.setNome(updatedContatto.getNome());
            }
            if (updatedContatto.getCognome() != null) {
                existingContatto.setCognome(updatedContatto.getCognome());
            }
            if (updatedContatto.getTel() != null) {
                existingContatto.setTel(updatedContatto.getTel());
            }
            if (updatedContatto.getMail() != null) {
                existingContatto.setMail(updatedContatto.getMail());
            }
            if (updatedContatto.getDataNascita() != null) {
                existingContatto.setDataNascita(updatedContatto.getDataNascita());
            }
            
		/*
			Potremmo voler gestire il caso in cui un campo viene passato come NULL per essere "cancellato"
			o decidere che NULL non aggiorna il campo se non specificato.
			Esempio per la mail: Se mail è NULL in updatedContatto, la mettiamo a NULL anche nell'esistente.
			Se vogliamo che NULL ignori l'aggiornamento, dobbiamo rimuovere questa riga.
			existingContatto.setMail(updatedContatto.getMail());
		*/
            // Qui aggiungiamo la logica per il vincolo chk_nome_cognome
            if (existingContatto.getNome() == null && existingContatto.getCognome() == null) {
                 throw new IllegalArgumentException
                 	("Impossibile aggiornare: un contatto deve avere almeno un nome o un cognome.");
            }

            return contattoRepository.save(existingContatto);
        } else {
            // Potremmo lanciare un'eccezione personalizzata come ContattoNotFoundException
            throw new RuntimeException("Contatto con ID " + id + " non trovato per l'aggiornamento.");
        }
    }

  
    @Transactional
    public void deleteContatto(Integer id) {
        // Optional: Controlla se il contatto esiste prima di tentare di eliminarlo
        if (contattoRepository.existsById(id)) {
            contattoRepository.deleteById(id);
        } else {
            throw new RuntimeException
            	("Contatto con ID " + id + " non trovato per l'eliminazione.");
        }
    }

  
    
    // --- Metodi di query personalizzati (che utilizzano i metodi definiti nel repository) ---

    @Transactional(readOnly = true)
    public List<Contatto> getContattiByNome(String nome) {
        return contattoRepository.findByNome(nome);
    }

    @Transactional(readOnly = true)
    public List<Contatto> getContattiByCognome(String cognome) {
        return contattoRepository.findByCognome(cognome);
    }

    @Transactional(readOnly = true)
    public Optional<Contatto> getContattoByTel(String tel) {
        return contattoRepository.findByTel(tel);
    }


}