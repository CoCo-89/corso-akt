package it.Esercizi;

/*Esercizio 1: Libro
Campi: titolo (String), autore (String), pagine (int), isCopertinaRigida (boolean).
Metodi: apri() (stampa un messaggio), leggiPagina() (stampa "Sto leggendo una pagina"), descriviLibro() (stampa tutte le informazioni del libro).
Crea un oggetto Libro e chiama i suoi metodi.*/

public class Libro {
	//Campi
	public String titolo;
	public String autore;
	public int pagine;
	public boolean isCopertinaRigida;
	
//	public Libro () {}
	
	//Costruttore parametrico
	public Libro (String titolo, String autore, int pagine, boolean isCopertinaRigida) {
		this.titolo = titolo;
		this.autore = autore;
		this.pagine = pagine;
		this.isCopertinaRigida = isCopertinaRigida;
	}
		
	
	//Metodi
	public void apri() {
		System.out.println("Benvenuto in questa nuova avventura...");
	}
	public void leggiPagina() {
		System.out.println("Sto leggendo una pagina");
	}
	public void descriviLibro() {
	    System.out.println("Titolo: " + titolo + " - Autore: " + autore + " - pagine: " + pagine + isCopertinaRigida);   
	}
	
	
	
	
	

}//fine classe
