package it.akt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import it.akt.model.Fumetto;
import it.akt.repository.FumettoRepository;
import it.akt.service.FumettoService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/collezione")
public class FumettoController {
	
	private final FumettoRepository fumettoRepository;
	
	private final FumettoService fumettoService;
	
	@Autowired
	public FumettoController(FumettoService fumettoService, FumettoRepository fumettoRepository) {
		this.fumettoService = fumettoService;
		this.fumettoRepository = fumettoRepository;
	}
	@GetMapping(path= {"", "/"})
	public String listFumetti(Model model) {
		List<Fumetto> listFumetti = fumettoService.getAllFumetti();
		model.addAttribute("fumetti", listFumetti);
		return "fumetti/list";
	}
	
	@GetMapping("/nuovo")
    public String showNewFumettoForm(Model model) {
        model.addAttribute("fumetto", new Fumetto()); // Aggiunge un nuovo oggetto Contatto vuoto
        model.addAttribute("isEdit", false); // Flag indica alla vista se è una creazione o update
        return "fumetti/form"; 
    	}
	
	@GetMapping("/dettagli/{id}")
	public String showFumettoDeatilsForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
		Optional<Fumetto> optionalFumetto = fumettoService.getFumettoById(id);
		if(optionalFumetto.isEmpty()) {
			ra.addFlashAttribute("Messaggio di errore", "Fumetto non trovato!");
			return "redirect:/fumetti";
		}
		model.addAttribute("fumetto", optionalFumetto.get());
		return "fumetti/form";
	}
	
	@GetMapping("/salva")
	public String saveFumetto(@ModelAttribute("fumetto") Fumetto fumetto, RedirectAttributes ra) {
		fumettoService.saveFumetto(fumetto);
		ra.addFlashAttribute("Messaggio", "Fumetto salvato con successo!");
		return "redirect:/fumetti";
	}
	
	@GetMapping("/elimina")
	public String deleteFumetto(@ModelAttribute("id") Integer id, RedirectAttributes ra) {
		if(fumettoService.getFumettoById(id).isPresent()) {
			fumettoService.deleteFumetto(id);
			ra.addFlashAttribute("Messaggio", "Fumetto eliminato con successo");
		} else {
			ra.addFlashAttribute("Messaggio di errore", "Fumetto non trovato per essere eliminato!");
		}
		return "redirect:/fumetti";
	}
}


