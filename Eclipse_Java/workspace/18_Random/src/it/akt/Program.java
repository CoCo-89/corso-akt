
package it.akt;
 
import java.util.Random;

public class Program {

	public static void main(String[] args) {

/*
	Da Java 6 è stata introdotta la classe Random definita in java.util
	Questa classe deve essere istanziata!
	
	Sull'oggetto posso applicare diversi metodi per generare numeri casuali
*/
		
		//Istanzio la classe "Random" e creo un oggetto "random"
		Random random = new Random();
		
		//genero un valore casuale di tipo false/true
		System.out.println( random.nextBoolean() );
		
		//un numero casuale compreso tra -2147483648 a 2147483647
		System.out.println( random.nextInt() );
		
		//in questo caso voglio un numero casuale compreso tra 1 e 6 (incluso) o 7 (escluso)
		System.out.println( random.nextInt(6) + 1 );
		//nextInt(origin, bound) disponibile da Java 17
		System.out.println("Lancio dado da 20: " + random.nextInt(1, 21));
		
		System.out.println("Float casuale: " + random.nextFloat());
		System.out.println("Long casuale: " + random.nextLong());

		//ottengo un numero casuale compreso tra 0.0 (incluso) e 1.0 (escluso)
		System.out.println( random.nextDouble() );
		
		// Differenza: Math.random() restituisce double, range [0.0, 1.0)
		System.out.println("Con Math.random(): " + Math.random());

		
		
	}

}
