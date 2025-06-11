package it.esercizi;

public class Program {

	public static void main(String[] args) {
		
		/*Esercizio 1: Rubrica telefonica
Crea una classe Contatto con campi nome, numeroTelefono. Crea una classe Rubrica che utilizza una Map<String, Contatto> dove la chiave è il nome.

Funzionalità da implementare:
	Aggiungi un nuovo contatto.
	Cerca un contatto per nome.
	Rimuovi un contatto.
	Stampa tutti i contatti.*/
		
		
		Contatto c1 = new Contatto("Mario", "33345486498");
		Contatto c2 = new Contatto("Giovanni", "055647896");
		Contatto c3 = new Contatto("Luca", "0745668761");
		Rubrica miaRubrica = new  Rubrica();
		
		miaRubrica.aggContatto(c1.getNome(), c1);
		miaRubrica.aggContatto(c2.getNome(), c2);
		miaRubrica.aggContatto(c3.getNome(), c3);
		
		
		miaRubrica.cercaContatto("gigi");
		
		miaRubrica.rimuoviContatto(c3.getNome());
		
		miaRubrica.stampaContatti();;

	}

}
