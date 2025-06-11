package it.akt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.akt.model.Categoria;
import it.akt.model.Spesa;
import it.akt.service.SpesaService;

@Controller
public class SpesaController {
	
	//@Autowired
	private SpesaService spesaService;
	
	//costruttore che inizializza il campo SpesaService
	//@Autowired superfluo perchè ho un unico costruttore
	public SpesaController(SpesaService spesaService) {
		this.spesaService = spesaService;
	}


	@GetMapping(path = {"/", "/index", "/form"})
	public String getInserForm(Model model) {	//model per aggiungere eventuali attributi
		model.addAttribute("nuovaSpesa", new Spesa());	//oggetto spesa aggiunto
		model.addAttribute("listaCategorie", Categoria.values());	//array di liste aggiunto
		return "inserisci_spesa";
	}
	
	
	@PostMapping("/insert")
	public String addExpense(@ModelAttribute Spesa spesa ) {	//recupera oggetto spesa popolato
		spesaService.aggiungiSpesa(spesa);
		//System.out.println(spesaService.ritornaListaSpese());
		return "redirect:/index";	//reindetizza ad una nuova pagina che viene ricaricata e riagganciata dal GetMapping
	}
	
	@GetMapping("/lista_spese")
	public String getLista(Model model) {
		model.addAttribute("listaSpese", spesaService.ritornaListaSpese());
		return "lista_spese";
	}
	
}
