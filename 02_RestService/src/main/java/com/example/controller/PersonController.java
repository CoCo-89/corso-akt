package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.UnprocessableEntity;

import com.example.model.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping("/person")
//tutti i metodi faranno riferimento a questo URL principale
public class PersonController {

	@Autowired
	private PersonService personService;
	//questo campo non è inizializzato e varrebbe 'null' senza @Autowired
	
    @GetMapping("/list")
    public List<Person> getPersonsList() {
    	//Non creo più qui la lista, ma accedo alla classe Service
    	//che tramite l'istanza automatica, me la restituisce
        return personService.getPersonsList();
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> createPerson(@ModelAttribute Person person) {
    	if (!personService.createPerson(person))
    		return ResponseEntity.unprocessableEntity().body("Id already exists!");
    	return ResponseEntity.ok("Success!");
    }
    
    /**
     * Chiama il metodo deletePersonById() di PersonaService. Siccome .remove può lanciare
     * diversi tipi di eccezioni è opportuno usare un blocco try catch nel caso 
     * l'oggetto non venga trovato 
     * 
     * @param id
     * @return ResponseEntity<String> Con messaggio e HttpStatus code
     */
    @DeleteMapping("/{id}")	//chiamata DELETE: localhost:8080/2 se vogliio eliminare la persona con id 2
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
    	try {
    		personService.deletePersonById(id);
    		return new ResponseEntity<>("Object has been deleted succesfully!", HttpStatus.OK);
    	} catch (RuntimeException e) {
    		return new ResponseEntity<>("Object not found!", HttpStatus.NOT_FOUND);
    	}
    }
  
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, 
    		@ModelAttribute Person updatedPerson) {	//anche questo @RequestBody è stato modificato per passare i dati con form
    	if (personService.updatePerson(id, updatedPerson)) {
    		return new ResponseEntity<>("Person updated!", HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Person updated!", HttpStatus.NOT_MODIFIED);
    	}
    }

    
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
    	//Se non gestisco gli errori e cerco un id inesistente la mia applicazione 
    	//si schianta e ottengo una NoSuchElementException
    	return personService.getPersonById(id);
    	//TODO: implementare blocco try o un controllo con if
    }

}


