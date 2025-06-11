package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // Import per la gestione degli errori di binding/validazione
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // Per messaggi di successo/errore dopo un redirect

import com.example.model.Contatto;
import com.example.repository.ContattoRepository;
import com.example.service.ContattoService;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller // Indica a Spring che questa classe è un controller Spring MVC
@RequestMapping("/contatti") // Tutti i mapping di questo controller avranno il prefisso /contatti
public class ContattoController {

    private final ContattoRepository contattoRepository;

    private final ContattoService contattoService;

    @Autowired // Iniezione della dipendenza ContattoService tramite costruttore
    public ContattoController(ContattoService contattoService, ContattoRepository contattoRepository) {
        this.contattoService = contattoService;
        this.contattoRepository = contattoRepository;
    }


    /**
     * 1. Mostra la lista di tutti i contatti
     * Accessibile via GET su http://localhost:8080/contatti
     * @param model
     * @return Restituisce il nome della vista Thymeleaf contatti/list.html
     */
    @GetMapping(path={"", "/"})
    public String listContatti(Model model) {
        List<Contatto> listaContatti = contattoService.getAllContatti();
        model.addAttribute("contatti", listaContatti); // Aggiunge la lista di contatti 
        return "contatti/list"; 
    }



    /**
     * 2. Mostra il form per creare un nuovo contatto
     * Accessibile via GET su http://localhost:8080/contatti/new
     * Il Flag isEdit ci permetterà di usare lo stesso form sia per creare che per
     * modificare e quindi fare l'update di un Contatto.
     * @param model
     * @return Restituisce il nome della vista Thymeleaf contatti/form.html
     */
    @GetMapping("/new")
    public String showNewContattoForm(Model model) {
        model.addAttribute("contatto", new Contatto()); // Aggiunge un nuovo oggetto Contatto vuoto
        model.addAttribute("isEdit", false); // Flag indica alla vista se è una creazione o update
        return "contatti/form"; 
    }


    /**
     * 3. Salva un nuovo contatto dal form
     * Riceve la richiesta POST da http://localhost:8080/contatti/save
     * @param contatto
     * @param result	Contiene eventuali errori di validazione (se @Valid fosse usato)
     * @param redirectAttributes 	Aggiungere messaggi "flash" che servono per passare parametri col redirect
     * @return "redirect:/contatti" Reindirizza l'utente alla lista dei contatti per 
     * 								evitare doppi invii del form
     */
    @PostMapping("/save")
    public String saveContatto(@ModelAttribute("contatto") Contatto contatto,
                               BindingResult result,
                               HttpServletRequest request,
                               RedirectAttributes redirectAttributes) { 

        // Qui, in un'applicazione reale, useresti l'annotazione @Valid su 'contatto'
        // e controlleresti 'result.hasErrors()' per la validazione a livello di applicazione.
        if (result.hasErrors()) {
            // Se ci sono errori di binding o validazione, ritorna al form
            // La vista 'form' avrà accesso agli errori tramite 'result'
            return "contatti/form";
        }

        try {
        	String data = request.getParameter("dataDiNascita");
        	LocalDate dataNascita = LocalDate.parse(data);
        	contatto.setDataNascita(dataNascita);
            contattoService.saveContatto(contatto);
            redirectAttributes.addFlashAttribute("message", "Contatto salvato con successo!");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (IllegalArgumentException e) {
            // Cattura eccezioni di logica di business dalla service (es. vincolo nome/cognome)
            redirectAttributes.addFlashAttribute("message", "Errore durante il salvataggio: " + e.getMessage());
            redirectAttributes.addFlashAttribute("messageType", "error");
            // Puoi anche scegliere di tornare al form con l'errore se l'errore è direttamente relativo al form
            // model.addAttribute("errorMessage", e.getMessage()); return "contatti/form";
        }
        return "redirect:/contatti"; // Reindirizza l'utente alla lista dei contatti 
    }



    /**
     *  4. Mostra il form per modificare un contatto esistente
     *  Accessibile via GET su http://localhost:8080/contatti/edit/{id}
     * @param id
     * @param model	Popola il form con i dati del contatto esistente
     * 				Flag per indicare alla vista che è un'operazione di modifica
     * @param redirectAttributes
     * @return "redirect:/contatti"  Se il contatto non esiste, reindirizza alla lista
     */
    @GetMapping("/edit/{id}")
    public String showEditContattoForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Contatto> contatto = contattoService.getContattoById(id);
        if (contatto.isPresent()) {
            model.addAttribute("contatto", contatto.get()); 
            //System.out.println("CONTATTO: " + contatto.get());
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            String dataFormattata = contatto.get().getDataNascita().format(formatter); 
//            System.out.println("DATA FORMATTATA: " + dataFormattata);
//            model.addAttribute("dataFormattata", dataFormattata);
            model.addAttribute("isEdit", true); 
            return "contatti/form";
        } else {
            redirectAttributes.addFlashAttribute("message", "Contatto non trovato con ID: " + id);
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/contatti"; 
        }
    }



    /**
     * 5. Aggiorna un contatto esistente dal form
     * Riceve la richiesta POST da http://localhost:8080/contatti/update/{id}
     * @param id
     * @param contatto
     * @param result
     * @param redirectAttributes
     * @return "redirect:/contatti"
     */
    @PostMapping("/update/{id}")
    public String updateContatto(@PathVariable Integer id,
                                 @ModelAttribute("contatto") Contatto contatto,
                                 BindingResult result,
                                 HttpServletRequest request,
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "contatti/form";
        }
        try {
            // Imposta l'ID del contatto dall'URL, assicurando che il contatto ricevuto dal form abbia 
        	// l'ID corretto
            contatto.setIdContatto(id);
            //Catturo la data inviata con name=""
            String dataDiNascita = (String) request.getParameter("dataDiNascita");
            LocalDate dataNascita = LocalDate.parse(dataDiNascita); //faccio il parse per convertirla in LocalDate
            contatto.setDataNascita(dataNascita);//aggiorno il contatto
            contattoService.updateContatto(id, contatto); // in Service: logica di recupero e aggiornamento
            redirectAttributes.addFlashAttribute("message", "Contatto aggiornato con successo!");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (RuntimeException e) { // Cattura eccezioni dalla service (es. contatto non trovato, validazione)
            redirectAttributes.addFlashAttribute("message", "Errore durante l'aggiornamento: " + e.getMessage());
            redirectAttributes.addFlashAttribute("messageType", "error");
        }
        return "redirect:/contatti";
    }


    /**
     *  6. Elimina un contatto
     *  Accessibile via GET su http://localhost:8080/contatti/delete/{id}
     *  
     *  <b>NOTA:</b> Per le operazioni di eliminazione, è generalmente più sicuro usare POST o DELETE
     *  per prevenire eliminazioni accidentali (es. da crawler o precaricamento browser).
     *  Qui usiamo GET per semplicità con i link Thymeleaf.
     * @param id
     * @param redirectAttributes
     * @return "redirect:/contatti"
     */
    @GetMapping("/delete/{id}")
    public String deleteContatto(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            contattoService.deleteContatto(id);
            redirectAttributes.addFlashAttribute("message", "Contatto eliminato con successo!");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("message", "Errore durante l'eliminazione: " + e.getMessage());
            redirectAttributes.addFlashAttribute("messageType", "error");
        }
        return "redirect:/contatti";
    }
}