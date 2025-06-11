package it.akt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.akt.model.Interessi;
import it.akt.model.Utente;

@Controller
public class FormController {

	/**
	 * Metodo che permette l'accesso alla pagina Web form.html. Il metodo intercetta sia la chiamata al percorso
	 * vuoto localhost:8080 (o 127.0.0.1:8080) che la chiamata a localhost:8080/form
	 * Il metodo, tramtie l'oggetto 'model' dell'interfaccia Model, permette di inviare un oggetto Utente nuovo e vuoto
	 * da poter popolare con i dati raccolti nel form, e poi rimandarlo alla destinazione
	 * @param model
	 * @return form web page
	 */
	@GetMapping(path= {"/", "/form"})
	public String getForm(Model model) {
		model.addAttribute("utente", new Utente());
		model.addAttribute("arrayInteressi", Interessi.values()); //passa anche un array di interessi
		return "form";
	}
	
	
	
}
