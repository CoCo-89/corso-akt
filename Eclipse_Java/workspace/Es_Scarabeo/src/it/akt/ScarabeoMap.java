package it.akt;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScarabeoMap {

	private Map<String, Integer> tessere = new HashMap<>();

	public ScarabeoMap() {
		String[][] valoriTessereIniziali = {
                {"A", "1"}, {"B", "3"}, {"C", "3"}, {"D", "2"}, {"E", "1"}, {"F", "4"}, {"G", "2"},
                {"H", "4"}, {"I", "1"}, {"J", "8"}, {"K", "5"}, {"L", "1"}, {"M", "3"}, {"N", "1"},
                {"O", "1"}, {"P", "3"}, {"Q", "10"}, {"R", "1"}, {"S", "1"}, {"T", "1"}, {"U", "1"},
                {"V", "4"}, {"W", "4"}, {"X", "8"}, {"Y", "4"}, {"Z", "10"}
        };
//		Inizializzazione mappa con ciclo for
		for (String[] tile : valoriTessereIniziali) {
            this.tessere.put(tile[0], Integer.parseInt(tile[1]));
        }
	}//fine costruttore

	
	
	public Map<String, Integer> getTessere() {
		return tessere;
	}
	
	
	
}
