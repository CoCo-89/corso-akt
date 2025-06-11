package com.example;

import java.util.List;

public class Program {

	public static void main(String[] args) {

		StudentService studentService = new StudentService();

		// Creazione
		System.out.println("Creazione nuovo studente:");
		int nuovoId = studentService.creaStudente("Chiara", "Neri");
		if (nuovoId > 0) {
			System.out.println("Studente creato con ID: " + nuovoId);
		}

		// Lettura (singolo studente)
		System.out.println("\nLettura studente con ID 2:");
		studentService.leggiStudente(2);

		// Lettura (tutti gli studenti)
		System.out.println("\nLettura di tutti gli studenti:");
		studentService.leggiStampaStudenti();

		// Lettura (tutti gli studenti e ritorna Collezione)
		System.out.println("\nLettura di tutti gli studenti e ritorna Collezione:");
		List<Studente> lista = studentService.leggiRitornaStudenti();
		lista.forEach(System.out::println);

		// Aggiornamento
		System.out.println("\nAggiornamento studente con ID " + nuovoId + ":");
		studentService.aggiornaStudente(nuovoId, "Chiara", "Moretti");

		// Lettura (dopo l'aggiornamento)
		System.out.println("\nLettura studente con ID " + nuovoId + " dopo l'aggiornamento:");
		studentService.leggiStudente(nuovoId);

		// Eliminazione
		System.out.println("\nEliminazione studente con ID " + nuovoId + ":");
		studentService.eliminaStudente(nuovoId);

		// Lettura (dopo l'eliminazione)
		System.out.println("\nLettura di tutti gli studenti dopo l'eliminazione:");
		studentService.leggiStampaStudenti();
		
	}

}
