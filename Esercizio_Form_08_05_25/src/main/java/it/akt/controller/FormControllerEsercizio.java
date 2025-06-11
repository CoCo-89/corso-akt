package it.akt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.akt.model.UtenteEsercizio;


@Controller
public class FormControllerEsercizio {

	
	@GetMapping(path= {"/form_esercizio"})
	public String getForm(Model model) {
		model.addAttribute("utenteEsercizio", new UtenteEsercizio());
		return "form_esercizio";
	}
}
