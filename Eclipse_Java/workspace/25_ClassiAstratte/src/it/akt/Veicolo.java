package it.akt;

public abstract class Veicolo {

	//La mia classe può avere gli stessi membri di una classe normale, 
	// oppure anche solo metodi astratti
	
	public static final int VELOCITA_MAX = 1300;

	private String produttore;
	private String modello;
	private int velocita;
	
	
	//Costruttore di default implicito - posso anche creare quello/i parametrici
	
	
	//METODI ASTRATTI:
	public abstract void accelera();
	public abstract void decelera();
	//public abstract int altroMetodo();
	//ecc...
	
	//METODI NORMALI
	public void collaudo(boolean collaudoOk, String modello) {
		if (collaudoOk) {
			this.modello = modello;	//se passa il collaudo assegna un codice di modello del veicolo
		}
	}
	
	
	//GETTERS e SETTERS
	public String getProduttore() {
		return produttore;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public int getVelocita() {
		return velocita;
	}
	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}
	public String getModello() {
		return modello;
	}
	
}
