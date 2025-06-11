package it.akt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class BenvenutoController {
	
	@GetMapping("/rest")
	public String benvenuto() {
		return "Benvenuto a Spring RESTful Web Services";
	}
	
	@GetMapping("/indice/{titolo}")
	public String indice(@PathVariable String titolo) {
		return "Indice " + titolo;
	}

}
