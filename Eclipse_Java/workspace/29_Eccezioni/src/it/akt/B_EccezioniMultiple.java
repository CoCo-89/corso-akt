package it.akt;

public class B_EccezioniMultiple {

	public static void main(String[] args) {

		
/*	Rimaniamo in una situazione simile alla prima, con una stampa di inizio e una di fine.
	
	Mi creo un array di interi.
	Poi allestisco le solite divisioni tra numeri.
	Creo due unchecked exception:
		un divide by 0
		un out of bound
	Il problema è che mi blocco già alla prima.
	Diciamo che la correggo e aggiusto il valore nell'array... mi resta sempre la seconda.
	
	Come gestisco più eccezioni?
	Posso mettere più blocchi catch, ognuno dei quali intercetta un'eccezione.
	Ovviamente quando un errore viene catturato dal primo blocco, il secondo non viene eseguito.
*/		
		System.out.println("--- inizio ---");
		
		int[] numeri = { 5, 0, 2 };
		
		try {
			
			// prima unchecked exception... ArithmeticException
			System.out.println(numeri[0] / numeri[1]);
	
			// seconda unchecked exception... ArrayIndexOutOfBoundsException
			System.out.println(numeri[2] / numeri[3]);
			
		} catch (ArithmeticException e) {   //se cattuto una RuntimeException il secondo catch diventa dead code
			System.err.println("divisione per zero");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("indice non consentito");
		}
		
//		Siccome questo blocco corrisponde a un if - esle if - else if... 
//		sono soggetto agli stessi rischi di dead code se la prima condizione è più inclusiva
//		ed intercetta anche le seguenti	che ne sono dei sottotipi	

		
		if (numeri[0] != 0 && numeri[1] != 0)
			System.out.println(numeri[0] / numeri[1]);
		else
			System.err.println("uno dei due operandi è uguale a 0");
		
//	A volte è può essere meglio usare l'if se rende più corretto, solido e leggibile il codice
		
		
		try {
			
			// prima unchecked exception... ArithmeticException
			System.out.println(numeri[0] / numeri[1]);
	
			// seconda unchecked exception... ArrayIndexOutOfBoundsException
			System.out.println(numeri[2] / numeri[3]);
			
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {  // questo si può fare da Java 8 in poi
			System.err.println("Si è verificato un errore... " + e.getMessage());
		}
		
		System.out.println("---  fine  ---");

		
	}

}