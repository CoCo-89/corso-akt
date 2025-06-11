package c_Esercizio_Scarabeo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Program {

	public static void main(String[] args) {
		
		Map<Character, Integer> punteggio = new LinkedHashMap<>();
		
		punteggio.put('A', 1);
		punteggio.put('B', 3);
		punteggio.put('C', 3);
		punteggio.put('D', 2);
		punteggio.put('E', 1);
		punteggio.put('F', 4);
		punteggio.put('G', 2);
		punteggio.put('H', 4);
		punteggio.put('I', 1);
		punteggio.put('J', 8);
		punteggio.put('K', 5);
		punteggio.put('L', 1);
		punteggio.put('M', 3);
		punteggio.put('N', 1);
		punteggio.put('O', 1);
		punteggio.put('P', 3);
		punteggio.put('Q', 10);
		punteggio.put('R', 1);
		punteggio.put('S', 1);
		punteggio.put('T', 1);
		punteggio.put('U', 1);
		punteggio.put('V', 4);
		punteggio.put('W', 4);
		punteggio.put('X', 8);
		punteggio.put('Y', 4);
		punteggio.put('Z', 10);
		
		System.out.println("numero di lettere" + punteggio.size());
		
		for (Entry<Character, Integer> entry : punteggio.entrySet())		//"Entry" permette di estrerare il singolo valore dalla mappa
			System.out.println(entry.getKey() + " " + entry.getValue());
		
		Set<Character> setPunteggio = punteggio.keySet();	//estrae chiavi di un Set
		System.out.println("CIAO");
		
		for (Character punteggi : setPunteggio)		// get() di map estrae i valori dal Set creato
			System.out.println(punteggio.get(punteggi));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
