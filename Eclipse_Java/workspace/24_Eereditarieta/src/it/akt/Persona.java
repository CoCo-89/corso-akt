package it.akt;

public class Persona {

	public String nome;
	public String cognome;
	private int altezza;
	
	public static int eta;   //non viene ereditato - mettere età come static è un errore logico
	
	public final static int ALTEZZA_MAX = 220;  //(costante)
	public final static int ETA_MAX = 100;  //(costante)
	//anche questo 'static' non viene ereditato Perchè appartiene alla classe
	
	//I campi statici appartengono alla classe stessa, non agli oggetti della classe. 
	//In altre parole, i campi statici sono condivisi da tutte le istanze della classe 
	//e non variano da un oggetto all'altro.
	
/*
 * 	Dimostriamo anche che i costruttori NON vengono ereditati, ma vengono richiamati
 * 	a cascata, da quello della superclasse più in alto, fino a quello della sottoclasse che
 * 	sta istanziando l'oggetto:
 */
	
	
//COSTRUTTORE DI DEFAULT	
	public Persona() {
		System.out.println("Costruttore di Default di Persona");  
	}

	
//COSTRUTTORE PARAMETRICO	
	public Persona(String nome, String cognome, int altezza) {
		this.nome = nome;
		this.cognome = cognome;
		this.altezza = altezza;
		System.out.println("Costruttore Parametrico di Persona");  
	}

//GETTER di altezza
	public int getAltezza() {
		return altezza;
	}

//SETTER di altezza: vengono usati per filtrare i dati in ingresso
	public void setAltezza(int altezza) {
	      if (altezza <= 0 || altezza > ALTEZZA_MAX) {
	            throw new IllegalArgumentException("Altezza non valida: " + altezza);
	      }
	      this.altezza = altezza;
	}
	
	
	
	
	
}