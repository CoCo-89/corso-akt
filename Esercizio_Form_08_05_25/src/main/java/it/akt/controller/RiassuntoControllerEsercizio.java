package it.akt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.akt.model.UtenteEsercizio;

@Controller
public class RiassuntoControllerEsercizio {

	@GetMapping("/riassunto_esercizio")
	public String receiveData(@RequestParam String username, @RequestParam String password, Model model) {
		System.out.println(username + password);
		return "riassunto_esercizio";
	} 
	
	@PostMapping(path= {"riassunto_esercizio"})
	public String receiveData(@ModelAttribute UtenteEsercizio utenteEsercizio, Model model) {
		System.out.println(utenteEsercizio);
		return "riassunto_esercizio";
	}
}
