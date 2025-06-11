package it.akt.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.akt.model.Fumetto;
import it.akt.service.FumettoService;

@RestController
@RequestMapping("/fumetto")

public class FumettoController {
	
	@Autowired
	private FumettoService fumettoService;
	
	@GetMapping("/catalogo")
	public List<Fumetto> getFumettiList() {
		return fumettoService.getFumettiList();
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> createFumetto(@ModelAttribute Fumetto fumetto) {
    	if (!fumettoService.createFumetto(fumetto))
    		return ResponseEntity.unprocessableEntity().body("Id already exists!");
    	return ResponseEntity.ok("Success!");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteFumetto (@PathVariable Long id) {
		try {
			fumettoService.deleteFumettoById(id);
			return new ResponseEntity<>("Il fumetto è stato eliminato con successo ", HttpStatus.OK);
		}
	}
	
}
