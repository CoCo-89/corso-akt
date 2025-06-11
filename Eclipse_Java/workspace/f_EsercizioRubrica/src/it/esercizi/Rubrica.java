package it.esercizi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Rubrica {

	private Map<String, Contatto> contatti = new HashMap<>();

		//metodi
		public void aggContatto(String nome, Contatto contatto) {
			contatti.put(nome, contatto);
		}
		
		public void rimuoviContatto(String nome) {
			contatti.remove(nome);
		}
		
		public Contatto cercaContatto(String nome) {
			if(contatti.containsKey(nome)) {
				Contatto contatto = contatti.get(nome);
				return contatto;
			} else {
				System.out.println(nome + " non trovato ");
				return null;
			}
		}
		
		public void stampaContatti() {
			for (Entry<String, Contatto> entry : contatti.entrySet())		//"Entry" permette di estrrare il singolo valore dalla mappa
				System.out.println(entry.getValue().getNome() + " " + entry.getValue().getNumeroTelefono());
		}
}

