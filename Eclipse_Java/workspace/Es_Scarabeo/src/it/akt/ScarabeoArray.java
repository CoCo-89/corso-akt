package it.akt;

import java.util.Arrays;

public class ScarabeoArray {

	private int[] punteggi = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
	
	
	public int calcolaPuntiParola (String parola) {
		parola=parola.toUpperCase();
		char[] caratteri = parola.toCharArray();
		//System.out.println(Arrays.toString(caratteri));
		int punteggio = 0;
		for (int i = 0; i < caratteri.length; i++) {
			int indice = caratteri[i]-65;
			punteggio += punteggi[indice];
		}
		
		return punteggio;
	}
	
}
