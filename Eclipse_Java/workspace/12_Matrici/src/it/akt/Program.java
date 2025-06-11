package it.akt;

public class Program {

	public static void main(String[] args) {
		// MATRICI O ARRAY MULTIDIMENSIONALI
		// ARRAY[RIGHE][COLONNE]
		
		//Possono essere regolari (colonne tutte uguali)
		//Irregolari con alcune colonne di lunghezza diversa
		
		
		//Dichiarazione MATRICE REGOLARE:
		int [][] matriceRegolare1 = new int [2][4];
									//		[2 righe][4 colonne]
		
		//Dichiarazione ed inizializzazione
		int [][] matriceRegolare2 = {
				{4, 12, 33, 2},
				{54, 21, 44, 9}
		};
		
		//Accesso agli elementi
		System.out.println(matriceRegolare2[0][0]);
		
		//MATRICE IRREGOLARE
		//Dichiarazione:
		int[][] matriceIrr1 = new int [3][];
		
		//Inizializzazione
		matriceIrr1[0] = new int[] {21, 2, 33, 4};
		matriceIrr1[1] = new int[] {2, 65};
		matriceIrr1[2] = new int[] {91, 112, 4, 78, 33, 91};
		
		//Dichiarazione ed inizializzazione
		int [][] matriceIrr2 = {
				{20, 6, 33, 4},
				{2, 5},
				{115, 112, 4, 77, 33, 91}
		};
		
		
		//Per accedere agli elementi devo conoscere il numero di righe e colonne
		int numeroColonna0 = matriceIrr2[0].length; 
		int numeroColonna1 = matriceIrr2[1].length; 
		int numeroColonna2 = matriceIrr2[2].length; 
		int numeroRighe = matriceIrr2.length;
		
		// 'r' indica il numero di riga
		// 'c' indica il numero di colonna o elemento della riga
		
		for(int r = 0; r < matriceIrr2.length; r++) {
			for(int c = 0; c < matriceIrr2[r].length; c++) {
				System.out.print(matriceIrr2[r][c] + " ");
			}
			System.out.println();  //va a capo quando finisce di stampare gli elementi di una riga
		}
		
		
		System.out.println();
		//Stampa delle tabelline da 1 a 10
		for(int r = 1; r <= 10; r++) {
			for(int c = 1; c <= 10; c++) {
				System.out.printf("%4d", r*c);
			}
			System.out.println();
		}
		
		//printf permette di formattare le stringhe. %d allinea i numeri decimali interi.
		//aggiungendo il 4, gli dico di usare 4 spazi per ogni numero
		//printf con placeholder aiuta molto a velocizzare e tenere in ordine i vari valori da stampare
		
		
	}

}
