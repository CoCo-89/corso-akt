package it.Esercizi;

public class Contatore {

	/*Esercizio 3:Contatore
	Campo: valore (int).
	Metodi: incrementa() (aumenta il valore di 1), decrementa() (diminuisce il valore di 1), getValore() (restituisce il valore corrente), resetta() (imposta il valore a 0).
	Crea un oggetto Contatore, incrementalo e decrementalo alcune volte, poi resettalo e stampa il valore.*/
	
	//Campi
	private int valore;
	
	//Costruttore 
	public Contatore() {
		valore = 0;
	}
	
	//Metodi
	void incrementa() {
		valore++;
	}
	
	void decrementa() {
		valore--;
	}
	
	public int getValore() {
		return valore;
	}
	
	public void resetta() {
		valore = 0;
	}
	
	
	
	
}
