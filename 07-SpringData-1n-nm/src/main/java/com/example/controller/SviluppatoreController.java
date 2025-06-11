package com.example.controller;

import com.example.entity.Sviluppatore;
import com.example.service.SviluppatoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sviluppatori")
public class SviluppatoreController {

    private final SviluppatoreService sviluppatoreService;

    public SviluppatoreController(SviluppatoreService sviluppatoreService) {
        this.sviluppatoreService = sviluppatoreService;
    }

    @GetMapping
    public String listSviluppatori(Model model) {
        List<Sviluppatore> sviluppatori = sviluppatoreService.getAllSviluppatori(); // Usa getAllSviluppatori()
        model.addAttribute("sviluppatori", sviluppatori);
        return "sviluppatori/list";
    }

    @GetMapping("/nuovo")
    public String showNewSviluppatoreForm(Model model) {
        model.addAttribute("sviluppatore", new Sviluppatore()); 
        return "sviluppatori/form";
    }

    @GetMapping("/dettagli/{id}")
    public String showSviluppatoreDetailsForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        Optional<Sviluppatore> optionalSviluppatore = sviluppatoreService.getSviluppatoreById(id); 
        if (optionalSviluppatore.isEmpty()) {
            ra.addFlashAttribute("errorMessage", "Sviluppatore non trovato!");
            return "redirect:/sviluppatori";
        }
        model.addAttribute("sviluppatore", optionalSviluppatore.get());
        return "sviluppatori/form";
    }

    @PostMapping("/salva")
    public String saveSviluppatore(@ModelAttribute("sviluppatore") Sviluppatore sviluppatore, RedirectAttributes ra) {
        sviluppatoreService.saveSviluppatore(sviluppatore); 
        ra.addFlashAttribute("message", "Sviluppatore salvato con successo!");
        return "redirect:/sviluppatori";
    }

    @GetMapping("/elimina/{id}")
    public String deleteSviluppatore(@PathVariable("id") Long id, RedirectAttributes ra) {
        if (sviluppatoreService.getSviluppatoreById(id).isPresent()) { // Verifica esistenza
            sviluppatoreService.deleteSviluppatore(id); 
            ra.addFlashAttribute("message", "Sviluppatore eliminato con successo!");
        } else {
            ra.addFlashAttribute("errorMessage", "Sviluppatore non trovato per l'eliminazione!");
        }
        return "redirect:/sviluppatori";
    }
}