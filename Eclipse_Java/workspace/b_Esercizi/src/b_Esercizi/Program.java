package b_Esercizi;

public class Program {

	public static void main(String[] args) {
		
		//Esercizio 1: Dato un array di quindici numeri, acquisire da tastiera un numero cercarlo
		//nell'array. Se il numero è presente allora visualizzare la posizione.
		
		int[] myArray = {21, 33, 12, 44, 1, 41, 53, 86, 545, 23, 4, 76, 78, 33, 99};
		int elemento = 40;
		int posizione = -1;
		for(int i = 0; i < myArray.length; i++) {
			if (myArray[i] == elemento) {
				System.out.println("Hai trovato il numero");
				System.out.printf("il %d è in posizione % \n", elemento, i);
				posizione = i;
				//break
			}
		}
			if(posizione == -1) {
				System.out.println("Numero non trovato");
			}
		
		
		
		
		
		
		
	}
}
