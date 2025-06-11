package it.akt;

public class Program {

	public static void main(String[] args) {

/*		
	Dopo aver creato le classi Persona e Studente che eredita da Persona, proviamo a istanziare
	degli oggetti sia di una classe che dell'altra.
	
	Partiamo da Studente e vediamo come avvengono le chiamate ai costruttori		
*/		
		Studente s1 = new Studente();
				//Questo chiama:	Costruttore di Default di Persona
				//					Costruttore di Default di Studente
		
		System.out.println("======================================================");
		Studente s2 = new Studente("Mario", "Rossi", 183, 26);
				//Questo chiama:	Costruttore Parametrico di Persona
				//					Costruttore Parametrico di Studente
		
		
		//Proviamo finalmente l'operatore instanceof permette di vedere se un oggetto è istanza delle classi
		System.out.println(s1 instanceof Studente);		//true
		System.out.println(s1 instanceof Persona);		//true
		
		//Vediamo se il campo static ETA_MAX è disponibile?
		System.out.println(s1.ETA_MAX);
		//C'è, ma non è corretto accedervi così, perché essendo statico è un campo di Classe
		System.out.println(Studente.ETA_MAX);
		//Anche qui c'è... ma è sempre un campo di Persona. NON viene ereditato ma semplicemente 
		//reso accessibile in quanto in memoria statica
		
		//s1.eta = 12;
		//Stesso discorso per il campo "eta"
		
		
		
		
		
	}

}