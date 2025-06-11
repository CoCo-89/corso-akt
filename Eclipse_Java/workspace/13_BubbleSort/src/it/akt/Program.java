
package it.akt;
 
import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		int[] numeri = { 53, 12, 4, 11, 73, 41, 23, 90, 1 }; // Array di esempio

		System.out.println("Array non ordinato:" + Arrays.toString(numeri));

		ordinaBubbleSort(numeri);  //Chiamata al metodo che ordina

		System.out.println("Array ordinato:" + Arrays.toString(numeri));

	}

	
	//Metodo che effettua ordinamento con algortimo Bubble Sort
	private static void ordinaBubbleSort(int[] numeri) { //passaggio array 
		boolean scambiato = true; //Flag per verificare se sono stati effettuati scambi

        // Ciclo esterno: ripete il processo finché non ci sono più scambi
		for (int i = 0; i < numeri.length -1 && (scambiato == true); i++) {
			scambiato = false;	// Resetta il flag per ogni iterazione
			for (int j = 0; j < numeri.length -i -1; j++) {

				// Se l'elemento corrente è maggiore del successivo, scambiali
				if (numeri[j] > numeri[j + 1]) {  	//j= 53  j+1=12
					int temp = numeri[j];			//temp=j=53	j=53
					numeri[j] = numeri[j + 1];		//j=12   j+1=12
					numeri[j + 1] = temp;			//j+1=temp=53	temp=53  j=12
					scambiato = true;				// Indica che è avvenuto uno scambio
				}
			}
		}
	}
}
