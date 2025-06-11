/*
	 REGOLE SUI COSTRUTTORI IN JAVA:
	 1. I costruttori non hanno tipo di ritorno (nemmeno void).
	 2. Se non definisci alcun costruttore, Java ne crea uno di default senza parametri.
	 3. Se definisci almeno un costruttore, Java NON crea più il costruttore di default automaticamente.
	 4. È possibile avere più costruttori (overloading) con firme diverse.
	 5. Per chiamare un altro costruttore della stessa classe, si usa "this(...)", 
	 	che deve essere la PRIMA istruzione nel costruttore.
	 6. Java NON fornisce un costruttore di copia automaticamente (come C++): se vuoi uno, lo devi scrivere tu.
	 7. I costruttori servono per inizializzare lo stato dell’oggetto al momento della sua creazione.
*/


package it.akt;

public class Program {

	public static void main(String[] args) {


		Persona p1 = new Persona();
		System.out.println("====================================== ");
		
		
		Persona p2 = new Persona("Mario");
		System.out.println("====================================== ");
		
		Persona p3 = new Persona("Luigi", 20);
		System.out.println("====================================== ");
		
		
//COPIA SEMPLICE DI UN OGGETTO:
		//In Java esiste anche la possibilità di copiare un oggetto
		Persona copyOfP3 = p3;		//Genera una copia debole
		
		p3.nome = "Sandra";			//se modifico l'originale modifico anche la copia
		System.out.println(copyOfP3.nome);
		
		
//COPIA DI UN OGGETTO CON COPY CONSTRUCTOR: ottengo una copia forte		
		
		Persona personaCopyConstructor = new Persona(p3);
		p3.eta = 45;	//se modifico l'originale non modifico la copia
		System.out.println("Oggetto copiato "+personaCopyConstructor.eta);	//Stampa sempre 20
		System.out.println("Oggetto originale "+p3.eta);	//Stampa sempre 20
		
		
		
		
	}
}