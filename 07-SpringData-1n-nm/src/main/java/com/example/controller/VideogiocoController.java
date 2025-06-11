package com.example.controller;


import com.example.entity.Videogioco;
import com.example.service.ProduttoreService;
import com.example.service.SviluppatoreService;
import com.example.service.VideogiocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/videogiochi")
public class VideogiocoController {

    private final VideogiocoService videogiocoService;
    private final ProduttoreService produttoreService;
    private final SviluppatoreService sviluppatoreService;

    public VideogiocoController(VideogiocoService videogiocoService,
                                ProduttoreService produttoreService,
                                SviluppatoreService sviluppatoreService) {
        this.videogiocoService = videogiocoService;
        this.produttoreService = produttoreService;
        this.sviluppatoreService = sviluppatoreService;
    }

    @GetMapping
    public String listVideogiochi(Model model) {
        List<Videogioco> videogiochi = videogiocoService.getAllVideogiochi(); // Usa getAllVideogiochi()
        model.addAttribute("videogiochi", videogiochi);
        return "videogiochi/list";
    }

    @GetMapping("/nuovo")
    public String showNewVideogiocoForm(Model model) {
        model.addAttribute("videogioco", new Videogioco());
        model.addAttribute("produttori", produttoreService.getAllProduttori()); // Usa getAllProduttori()
        model.addAttribute("sviluppatori", sviluppatoreService.getAllSviluppatori()); // Usa getAllSviluppatori()
        return "videogiochi/form";
    }

    @GetMapping("/dettagli/{id}")
    public String showVideogiocoDetailsForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        Optional<Videogioco> optionalVideogioco = videogiocoService.getVideogiocoById(id); // Usa getVideogiocoById()
        if (optionalVideogioco.isEmpty()) {
            ra.addFlashAttribute("errorMessage", "Videogioco non trovato!");
            return "redirect:/videogiochi";
        }
        model.addAttribute("videogioco", optionalVideogioco.get());
        model.addAttribute("produttori", produttoreService.getAllProduttori());
        model.addAttribute("sviluppatori", sviluppatoreService.getAllSviluppatori());
        return "videogiochi/form";
    }

    @PostMapping("/salva")
    public String saveVideogioco(@ModelAttribute("videogioco") Videogioco videogioco, RedirectAttributes ra) {
        videogiocoService.saveVideogioco(videogioco); // Usa saveVideogioco()
        ra.addFlashAttribute("message", "Videogioco salvato con successo!");
        return "redirect:/videogiochi";
    }

    @GetMapping("/elimina/{id}")
    public String deleteVideogioco(@PathVariable("id") Long id, RedirectAttributes ra) {
        if (videogiocoService.getVideogiocoById(id).isPresent()) { // Verifica esistenza
            videogiocoService.deleteVideogioco(id); // Usa deleteVideogioco()
            ra.addFlashAttribute("message", "Videogioco eliminato con successo!");
        } else {
            ra.addFlashAttribute("errorMessage", "Videogioco non trovato per l'eliminazione!");
        }
        return "redirect:/videogiochi";
    }
}