package it.akt.controller;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.GetMapping;@Controller
public class Page1Controller {
		@GetMapping("/page1")	//questo indica il percorso digitato sulla barra del browser o contenuto in un link
	public String getPage1(Model model) {		//l'oggeto model fa da vettore per le informazioni da includere nella pagina web		String utente = "Mario";		model.addAttribute("nome", utente); //questo rende disponibile un oggetto 'nome' che ha come contenuto la stringa utente all'interno della View		return "page1";	//devo indicare il nome della pagina ma senza il .html	}
				
}
