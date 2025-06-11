package com.example.controller;

import com.example.entity.Produttore;
import com.example.service.ProduttoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional; // Import per Optional

@Controller
@RequestMapping("/produttori")
public class ProduttoreController {

    private final ProduttoreService produttoreService;

    public ProduttoreController(ProduttoreService produttoreService) {
        this.produttoreService = produttoreService;
    }

    // Gestisce la visualizzazione della lista dei produttori
    @GetMapping
    public String listProduttori(Model model) {
        List<Produttore> produttori = produttoreService.getAllProduttori(); // Usa getAllProduttori()
        model.addAttribute("produttori", produttori);
        return "produttori/list";
    }

    // Mostra il form per un nuovo produttore
    @GetMapping("/nuovo")
    public String showNewProduttoreForm(Model model) {
        model.addAttribute("produttore", new Produttore()); 
        return "produttori/form";
    }

    // Mostra il form per modificare un produttore esistente o i dettagli
    @GetMapping("/dettagli/{id}")
    public String showProduttoreDetailsForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        Optional<Produttore> optionalProduttore = produttoreService.getProduttoreById(id);
        if (optionalProduttore.isEmpty()) {
            ra.addFlashAttribute("errorMessage", "Produttore non trovato!");
            return "redirect:/produttori";
        }
        model.addAttribute("produttore", optionalProduttore.get());
        return "produttori/form";
    }

    // Salva un nuovo produttore o aggiorna uno esistente
    @PostMapping("/salva")
    public String saveProduttore(@ModelAttribute("produttore") Produttore produttore, RedirectAttributes ra) {
        produttoreService.saveProduttore(produttore); // Usa saveProduttore()
        ra.addFlashAttribute("message", "Produttore salvato con successo!");
        return "redirect:/produttori";
    }

    // Elimina un produttore
    @GetMapping("/elimina/{id}")
    public String deleteProduttore(@PathVariable("id") Long id, RedirectAttributes ra) {
        // È buona pratica verificare se l'elemento esiste prima di provare a eliminarlo,
        // anche se il service potrebbe già gestire l'assenza.
        if (produttoreService.getProduttoreById(id).isPresent()) { // Verifica esistenza
            produttoreService.deleteProduttore(id); // Usa deleteProduttore()
            ra.addFlashAttribute("message", "Produttore eliminato con successo!");
        } else {
            ra.addFlashAttribute("errorMessage", "Produttore non trovato per l'eliminazione!");
        }
        return "redirect:/produttori";
    }
}