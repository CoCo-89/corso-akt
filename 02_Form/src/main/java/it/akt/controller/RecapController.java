package it.akt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.akt.model.Interessi;
import it.akt.model.Utente;

@Controller
public class RecapController {

	@PostMapping("/recap")
	public String receiveData(@ModelAttribute Utente utente, Model model ){
	    // La lista degli interessi selezionati sarà ora disponibile in utente.getListaInteressi()
        List<Interessi> interessiSelezionati = utente.getListaInteressi();
        System.out.println("Interessi selezionati: " + interessiSelezionati);
        //aggiungo date e ora di registrazione
        utente.setDataOraRegistrazione(LocalDateTime.now());
        // ... (logica per salvare l'utente con i suoi interessi) ...
        model.addAttribute("utente", utente);
		return "recap";
	}
	
}
