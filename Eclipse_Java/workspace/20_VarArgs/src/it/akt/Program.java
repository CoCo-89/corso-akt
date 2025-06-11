// RIFERIMENTO: Java - Maggi ed. 2024 - pagg. 103-104

package it.akt;

public class Program {

	public static void main(String[] args) {

		// Test della classe Calcolatrice per mostrare l'uso dei varargs
		
		Calcolatrice calc = new Calcolatrice();
		
		double sum = calc.somma(2.6, 4, 1.1, 5, 0, 3);
		System.out.println(sum);
		
		double multip = calc.moltiplica(3.1, 4);
		System.out.println(multip);
		
		System.out.println(calc.moltiplica(2.3, 5, 10, 2.7));
		
		System.out.println(calc.moltiplica(2.0, 3.0)); // Solo 2 argomenti, args sarà vuoto
		System.out.println(calc.somma()); // Nessun argomento: args.length == 0

		
		
	}
}
