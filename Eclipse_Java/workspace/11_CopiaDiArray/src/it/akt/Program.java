package it.akt;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		// COPIA DI ARRAY gli array vengono utilizzati per lavoro solo per un 15% dei casi
		// il restante 85% circa è utilizzato solo per casi di studio
		//è comunque consigliato imparare a manipolarli bene e studiarli

		//Creo un array di oggetti con una copia di oggetti creo un alias
		//quindi modificando la copia si modifica anche la copia originali dell'array
		Persona[] persone = {
				new Persona("Mario"),
				new Persona("Monica"),
				new Persona("Fulvio")
		};
		
		//.clone()  metodo per copiare un array
		Persona[] copiaPersone = persone.clone();
		System.out.println(Arrays.asList(persone));
		
		copiaPersone[1].nome = "Alfonso"; //modifico la copia
		System.out.println(Arrays.asList(persone)); //ma quando stampo l'array originale, 
													//scopro che si è modificato anche quello!

/*		Questo succede perché i metodi di copia di array, quando lavoriamo con oggetti, 
 		creano una shallow copy, o copia debole. 
 		Creano di fatto solo un alias, ovvero una copia del reference all'oggetto originale.
		Quando lavoro con array di tipi primitivi o di stringhe (se generate nella String Pool) 
		la copia è una copia forte, genera proprio 2 array distinti
		
*/		
		//.copyOf()  - con oggetti genera sempre una copia debole
		
		Persona[] copia2 = Arrays.copyOf(persone, persone.length); //permette di scegliere quanti elementi voglio copiare dell'array orginale
							//			(origine, numeroElementiDaCopiare) 
		
		
		//.arrayCopy() - con oggetti genera sempre una copia debole
		Persona[] copia3 = new Persona[persone.length]; //devo prima creare un nuovo array vuoto
		System.arraycopy(persone, 0, copia3, 0, persone.length); //array originale, punto di inizio, array di destinazione, punto di fine, lunghezza array copiato
		
		//Per fare una copia forte con gli oggetti, devo creare una copia fisica a mano
		Persona[] hardCopy = new Persona[persone.length];
		for(int i = 0; i < persone.length; i++) {
			Persona nuovaPersona = new Persona(persone[i].nome);
			hardCopy[i] = nuovaPersona;
		}
		
		
		
	}

}
