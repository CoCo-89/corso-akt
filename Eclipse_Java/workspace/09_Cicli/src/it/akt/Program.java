package it.akt;

public class Program {

	public static void main(String[] args) {
		// Cicli: si dividono in finiti e infiniti
		
/*while (condizione)
 * do {codice...}
 * 
 * do {codice..}
 * while (condizione)
 * 
 * for (dich_contatore; condizione; incremento_contatore){ codice...}
 * 
 * for (elemento: raccolta_elementi) { codice ... }
 * questo si chiama foreach
 */
		
//while...do: richiede la creazione di un contatore esterno
		int count = 0;
		while (count <= 10) {
			System.out.println("Contatore: " + count);
			count++; //oppure count+=1 oppure count=count+1
		
		}
		count=10;//reinizializzo la variabile per non portarmi dietro
				 //il valore residuo del ciclo precedente
		while (count > 1) {
			System.out.println(count + " ");
			count--;
		}
		
		System.out.println(); //mi manda a capo alla fine del ciclo
		
//do{...} while (condizione)	: richiede sempre un contatore esterno
//viene sempre eseguito il codice almeno 1 volta.
		int i = 10;
		do {
			System.out.println(i);
			i+=10;
		} while (i <= 100);
		
		
//for
		for(int j = 0; j<= 10; j+=3) {
			System.out.println(j);
		}
		
		int k = 1;
		for( ; k<5; ) {
			System.out.println(k);
			k++;
		}
		
//		for(;;) {
//			System.out.println("Ciao");
//		}
		
		
		
		
//break interrompe il ciclo
			for(int j = 0; j<100; j+=3) {
				System.out.println(j);
				if(j==72) break;
			}
		
//continue
			for(int j=0; j<10; j++) {
				if (j==5) continue;
				System.out.println(j);
			}
		
//foreach è un ciclo molto veloce e semplificato che ci permette di percorrere
//interamente un contenitore come un array, una list o un set
			
			int[] numeriInteri = {2, 5, 12, 2, 44, 91, -2, -20, 10};
//inizializzazione rapida di un array
			for(int numero : numeriInteri) {
				if(numero%2 == 0) { //controlla numeri pari nell'array
				System.out.println(numero);
			}
					
					
			System.out.println("Lunghezza array: " + numeriInteri.length);
		
			for(int z = 0; z < numeriInteri.length; z++) {
				System.out.println(numeriInteri[z]);
			}
			//posso fare
			// for(int z =0; z < numeriInteri.lenght; z++)
			//oppure
			//for(int z = 0; z <= numeriInteri.lenght-1; z++)
		
			}
		
	}

}
