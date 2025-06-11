package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Person;

@Service
public class PersonService {
	
	//Campo preinizializzato
	private List<Person> personsList = new ArrayList<>(Arrays.asList(
    		new Person(1L, "Mario", "Rossi"),
			new Person(2L, "Luca", "Bianchi"),
			new Person(3L, "Sabrina", "Verdi")));

//Metodi	
	/**
	 * Ritorna una lista di Persone
	 * @return List<Person> 
	 */
	public List<Person> getPersonsList() {
		return personsList;
	}

	/**
	 * Riceve un oggetto Person come parametro. Controlla se l'Id dell'oggetto
	 * ricevuto in ingresso è già presente nella List<Person>. 
	 * Se già presente ritorna false (non è stato aggiunto), se non è presente
	 * esegue l'inserimento e ritorna true
	 * @param Person person
	 * @return true per inserimento avvenuto, false per id già presente
	 */
	public boolean createPerson(Person person) {
		if( !personsList.stream().anyMatch(p->p.getId() == person.getId()) ) {
			personsList.add(person);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Riceve l'Id della persona da eliminare dalla lista. 
	 * Chiama il metodo .remove(obj) sulla lista. 
	 * Per estrarre l'obj persona chiama uno stream sulla lista e 
	 * filtra la lista cercando una corrispondenza con l'id passato
	 * come parametro.
	 *  
	 * @param Long id
	 * @throws ClassCastException - if the type of the specified elementis incompatible with this list(optional)
	 * @throws NullPointerException - if the specified element is null and thislist does not permit null elements(optional)
	 * @throws UnsupportedOperationException - if the remove operationis not supported by this list
	 */
	public void deletePersonById(Long id) {
		personsList.remove(
				personsList.stream()
						   .filter(p->p.getId() == id)
						   .findFirst()
						   .get()
				);
	}	

	/**
	 * Riceve un id di tipo Long in ingresso e cerca l'oggetto con quell'id
	 * @param Long id
	 * @return Person person 
	 * @throws NoSuchElementException se non trova nessuna corrispondenza
	 */
	public Person getPersonById(Long id) {
		return personsList.stream()
						  .filter(p -> p.getId() == id)
						  .findFirst()
						  .orElseThrow();				   
	}
	
	
	public boolean updatePerson(Long id, Person updatedPerson) {
		try {
			Person existingPerson = getPersonById(id);
			int position = personsList.indexOf(existingPerson);
			existingPerson.setFirstName(updatedPerson.getFirstName());
			existingPerson.setLastName(updatedPerson.getLastName());
			personsList.set(position, existingPerson);
			return true;
		} catch (Exception e ) {
			return false;
		}
	}
	
	
	
}



