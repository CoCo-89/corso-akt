package it.akt;

import java.util.Locale;

public class A_Locale {

	public static void main(String[] args) {

		//Locale: questa classe identifica lingua e area geografica 
		//si trova in java.util.Locale e va importata
		
		// Internazionalization, noto come I18N  ->  I_18_lettere_N
		//Per capire in che lingua e area geografica la mia JVM pensa di essere
		//uso getDefault che ritorna un oggetto di tipo Locale
		
		//Le prime due lettere indicano la lingua le altre 2 l'area geografica. 
		
		Locale localizzazione = Locale.getDefault();
		System.out.println(localizzazione);
		
		//Sintassi deprecata da Java 19
		Locale nuovaLocalizzazione = new Locale(
				Locale.UK.getLanguage(),
				Locale.UK.getCountry());
		
		//Nuova sintassi:
		//Versione 1:
		Locale nuovaLocalizzazione1 = Locale.of(
				Locale.UK.getLanguage(), 
				Locale.UK.getCountry());

		//Versione 2:
		Locale nuovaLocalizzazione2 = new Locale.Builder()
			    .setLanguage(Locale.UK.getLanguage())
			    .setRegion(Locale.UK.getCountry())
			    .build();
		
		//Design Pattern = strumento importante nella programmazione avanzata
				//29 pattern per risolvere problematiche ai programmatori
				//Uno tra questi è il .Builder
				//Consigliato comprare manuale/libro sui design pattern per fare uno step in più

		
		System.out.println(Locale.ITALY);
		Locale.setDefault(nuovaLocalizzazione);
		
		System.out.println(Locale.getDefault());
		
		
	}

}
