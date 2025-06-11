package it.akt;

import java.util.Random;

public class Giocatore {
	
	Random random = new Random();
	
	//Campi
	private String nome;
	private int punteggioPartita;

	//Costruttore parametrico
	public Giocatore(String nome) {
		this.nome = nome;
	}
	
	//Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPunteggioPartita() {
		return punteggioPartita;
	}
	
	public void setPunteggioPartita(int punteggio) {
		punteggioPartita = punteggio;
	}
	
	//Altri metodi
	public int lancioDado(int numeroFacce) { //passaggio per valore
		int estratto = random.nextInt(1, numeroFacce+1);
		System.out.println("Metodo lancia dado di Giocatore: " + estratto);
		return estratto; //TODO correggere putput
	}
	
	public int lancioDado(Dado dado) { //passaggio per riferimento
		random.nextInt(1, dado.getNumeroFacce()+1); //mi estraggo le faccio dentro il metodo con il getter
		return random.nextInt(1, dado.getNumeroFacce()+1); //TODO correggere putput
	}
	
	

}
