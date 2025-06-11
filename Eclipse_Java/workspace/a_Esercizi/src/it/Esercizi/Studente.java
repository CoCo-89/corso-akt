package it.Esercizi;

public class Studente {
	
	/*Esercizio 4:Studente
	Campi: nome (String), matricola (String), mediaVoti (double).
	Metodi: aggiungiVoto() (riceve un voto e aggiorna la media - semplificare assumendo che ogni voto abbia lo stesso "peso"), getNome() (restituisce il nome), getMedia() (restituisce la media).
	Crea un oggetto Studente, aggiungi alcuni voti e stampa la sua media.
	 */
	
	//Campi
	
	private String nome;
	private String matricola;
	private double mediaVoti;
	int totaleVoti = 40;
	int contaVoti = 5;
	
	//Costruttore 
	public Studente(String nome, String matricola, double mediaVoti) {
		this.nome = nome;
		this.matricola = matricola;
		this.mediaVoti = 0.0;
	}
	
	//Metodi
	public double aggiungiVoto(double voto) {
		totaleVoti = totaleVoti + (int)voto;
		contaVoti++;
		return(mediaVoti);
		}
	
	public String getNome() {
		return nome;
	}
	
	public double getMedia() {
		return mediaVoti;
	}
	
	
	
	
	
	
	
	
	
	

}
