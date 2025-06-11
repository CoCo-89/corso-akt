package it.akt;

public class Automobile { //dichiarazione di class || public modificatore di visibilità

	//COSTANTE di CLASSE
	public static final int VELOCITA_MAX = 240; //DEVE ESSERE INIZIALIZZATA QUI!
	//final per definire la costante
	//static sposta la proprietà di questo oggetto alla classe
	//bisogna inizializzare e definire immediatamente il valore della costante appena dichiarata
	
	
	//Campi: sono variabili di istanza, appartengono all'oggetto e vengono valorizzato dall'oggeto
	public String marca; //String è il tipo di dato, marca è il nome del campo
	public String modello;	// valore di default in caso anche per String
	public int cilindrata = 1000;	//posso impostare dei valori predefiniti || impostato valore di default
	public Colore colore;	//Un'altra classe creata con i colori di default della macchina oggetto
	public int velocita;	//la classe si poteva creare anche con "motore"
	
	//Costruttori
	//costruttore di default o vuoto - 
	//REGOLE DI BASE: 	esiste anche se non viene dichiarato. 
	//					se però creo uno o più costruttori parametrici viene "nascosto"
	//					in questo secondo caso, se mi serve anche quello di default, lo devo ridichiarare esplicitamente 
	public Automobile () {
		System.out.println("Sono nel costruttore di default");
		//colore=Colore.BIANCO;
		//marca = "Fiat";
	}
	
	//Costruttori parametrici per velocizzare l'assegnamento ad ogni oggetto
	public Automobile (String marca, String modello, int cilindrata, Colore colore) {
		this.marca = marca;	//this serve per far capire che è l'elemento che appartiene alla classe
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.colore = colore;
	}
	
	
	public Automobile(String marca, String modello) {	//esempio di overloading, rispettare ordine parametro
		this.marca = marca;
		this.modello=modello;
	}
	
	
	//metodi
	//void:  non ha un return e quindi non restituisce valori riutilizzabili
	public void accelera() {
		if (velocita < VELOCITA_MAX)
			velocita++;  //se ho una sola istruzione nell'if posso omettere le {}
	}
	
	
	//con valore di ritorno: il tipo di dato indicato nella firma deve corrispondere al tipo di dato ritornato dal metodo - return variabile_dello_stesso_tipo; 
	public int acceleraEritorna() {
		if(velocita < VELOCITA_MAX)	//deve corrispondere al valore dichiarato a quello restituito
			velocita++;
		return velocita;  //questo metodo ora ritorna il valore aggiornato di velocita
	}
	
	
	//OVELOADING: uso void accelera() 
	public void accelera(int velocitaImpostata) {	//esempio cruise control "Velocita Fissa"
		if(velocita < VELOCITA_MAX && velocitaImpostata < VELOCITA_MAX) 
			velocita = velocitaImpostata;		
	}

	
	//OVERRIDE: è fondamentale per riscrivere e personalizzare per la classe corrente, un metodo ereditato da una superclasse. Nel caso del metodo .toString() è ereditato dalla classe Object
	@Override
	public String toString() {	//permette di trasformare qualcosa e stamparla in stringa
		return "Automobile [marca=" + marca + ", modello=" + modello + ", cilindrata=" + cilindrata +
				", colore="	+ colore + ", velocita=" + velocita + "]";
	}
	
	
	
	
	
}
