package it.akt;

import java.util.HashMap;
import java.util.Map;

public class ScarabeoSemplice {

	private Map<String, Integer> tessere = new HashMap<>();
	
	public ScarabeoSemplice () {
        tessere.put("A", 1);
        tessere.put("B", 3);
        tessere.put("C", 3);
        tessere.put("D", 2);
        tessere.put("E", 1);
        tessere.put("F", 4);
        tessere.put("G", 2);
        tessere.put("H", 4);
        tessere.put("I", 1);
        tessere.put("J", 8);
        tessere.put("K", 5);
        tessere.put("L", 1);
        tessere.put("M", 3);
        tessere.put("N", 1);
        tessere.put("O", 1);
        tessere.put("P", 3);
        tessere.put("Q", 10);
        tessere.put("R", 1);
        tessere.put("S", 1);
        tessere.put("T", 1);
        tessere.put("U", 1);
        tessere.put("V", 4);
        tessere.put("W", 4);
        tessere.put("X", 8);
        tessere.put("Y", 4);
        tessere.put("Z", 10);
	}
	
	
	public int calcolaPuntiParola (String parola) {
		int punteggio = 0;
		parola=parola.toUpperCase();
		for(int i = 0; i < parola.length(); i++) {
			String lettera = parola.substring(i, i+1);
			int punto = tessere.get(lettera); //ritorna il punteggio abbinato alla lettera
			punteggio += punto;
		}			
		return punteggio;
	}
	
	
	
	
	
	
}
