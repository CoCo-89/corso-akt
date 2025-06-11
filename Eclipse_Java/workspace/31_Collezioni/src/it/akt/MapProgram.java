package it.akt;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/* 	Map<K, V>

Una mappa è un array associativo, in cui per accedere ad un'area di memoria, usiamo stringhe, 
numeri, caratteri, oggetti, ecc...
Sintassi:
nomeMappa<key, value>

Ad esempio posso creare una mappa dove la chiave è il nome della regione e il valore 
è la popolazione
Una mappa per quanto riguarda gli indici, si comporta come un set. 
Non posso avere una	chiave ripetuta più volte!

Anche le tipologie di Map corrispondono a quelle di Set, con la differenza del doppio Generic

L'interfaccia MAP NON estende Collection per via del doppio Generic


*/
public class MapProgram {

	public static void main(String[] args) {
		
		Map<String, Integer> regioniItaliane = new LinkedHashMap<>();
		
		regioniItaliane.put("lombardia", 10027602);
		regioniItaliane.put("lazio", 5755700);
		//regioniItaliane.put("lazio", 0);
		regioniItaliane.put("campania", 5712143);
		
		System.out.println("numero di regioni = " + regioniItaliane.size());
		System.out.println("la mappa è vuota? " + regioniItaliane.isEmpty());
		
		System.out.println(regioniItaliane);
		
		
/*		
		NON posso usare un 'for' normale per estrarre i dati non essendoci un indice, inoltre 
		NON funziona Iterator perché ha un solo GENERIC.
		Tuttavia all'interno di MAP c'è una classe interna che si chiama Entry e permette di 
		estrarre dati con coppie K,V
		Entry userà due generic uguali a quelli della mappa.entrySet() da cui voglio estrarre 
		i dati poi chiamerò getKey() e getValue() per estrarre chiavi e valori
*/
		for (Entry<String, Integer> entry : regioniItaliane.entrySet())		//"Entry" permette di estrrare il singolo valore dalla mappa
			System.out.println(entry.getKey() + " " + entry.getValue());	//get.Key elemento contenuto nella chiave, get.Value estrae il contenuto del Valore 
		
		//E' possibile cercare di estrarre i dati usando un SET, usando il 
		//metodo keySet0() che ritorna le chiavi sotto forma di array
		Set<String> setRegioni = regioniItaliane.keySet();	//estrae chiavi di un Set
		System.out.println(setRegioni);
		
		for (String regione : setRegioni)		// get() di map estrae i valori dal Set creato
			System.out.println(regioniItaliane.get(regione));
		
		Map<String, Integer> mappaOrdinata = new TreeMap<>(regioniItaliane);
		System.out.println(mappaOrdinata);
		
		Map<String, Integer> mappaCasuale = new HashMap<>(mappaOrdinata);
		System.out.println(mappaCasuale);
	
	}

}
