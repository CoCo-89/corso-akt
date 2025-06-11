//RIFERIMENTO: Java - Maggi ed 2024 - pagg. 256-269

package it.akt;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class B_LocalDate {

	public static void main(String[] args) {
/*
	In Java le date vengono trattate come numero di secondi trascorsi dalla 
	Epoch Date ovvero il 01/01/1970.

	LocalDate ritorna generalmente dati nel formato YYYY-MM-DD  2021-01-20
	LocalTime ritorna una formato del tipo 	hh:mm:ss:ms	14:20:00.0
	LocalDateTime fonde i due dati separati da un T

	Abbiamo a disposizione dei metodi per estrarre le informazioni più piccole 
	come giorni mesi, anni, ore, secondi, ecc...

	Abbiamo a disposizione degli enumeratori che indicano i giorni della settimana o i mesi.
	Con i metodi plus e minus, ci permettono di aggiungere unità temporali
*/

		LocalDate oggi = LocalDate.now();	//inizializza oggi con i dati dell'istante attuale
											//cattura data dall'orologio di sistema	
		
		System.out.println(oggi.toString());
		System.out.println(oggi.toEpochDay());	//conta i giorni trascorsi dall'Epoch Day 01/01/1970
		
		System.out.println(oggi.getYear());
		System.out.println(oggi.getMonthValue());	//estrae mese come Gennaio, Febbraio ecc
		System.out.println(oggi.getMonth());		//estae mese come Valore
		
		System.out.println(Month.JANUARY);		//Enumeratore che contiene i mesi
		System.out.println(DayOfWeek.TUESDAY);	//Enum che contiene i giorni della settimana
		
		
System.out.println("======================================");
		System.out.println(oggi.getDayOfWeek());	//ritorna il giorno della settimana corrente
		System.out.println(oggi.getDayOfMonth());	//ritorna il giorno del mese attuale
		System.out.println(oggi.getDayOfYear());	//conta i giorni trascorsi da inzio anno
		
		LocalDate natale1 = LocalDate.of(1980, 12, 25);  
		//mi permette di passare una serie di parametri che compongono la data.
		
		LocalDate natale2 = LocalDate.parse("1980-12-25");  
		//mi permette di passare una stringa e usa un PARSE, ma devo rispettare 
		//il formato che mi impone la classe inglese LocalDate. 
		//Se voglio cambiarlo devo usare un DateTimeFormatter e un pattern
		
		System.out.println(natale1.getDayOfWeek());
		System.out.println(natale1.getDayOfYear());
		
		
System.out.println("==================== PERIOD ==================");
//Classe di java.time.Period - va importata e permette di calcolare la distanza tra 2 date
		
		Period periodoDiTempo = Period.between(natale1, oggi);		//estrae un oggetto periodo contenete la distanza
		System.out.println(periodoDiTempo); 			//Stampa P43Y3M16D : anni/mesi/giorni
		System.out.println(periodoDiTempo.getDays());	//estrae da periodoDiTempo i giorni
		System.out.println(periodoDiTempo.getMonths());	//estrae da periodoDiTempo i mesi
		System.out.println(periodoDiTempo.getYears());	//estrae da periodoDiTempo gli anni 
		
		
		//Come istanziare una LocalDate e calcolare la distanza tra due date
		LocalDate arrivo =  LocalDate.of(2024, 8, 10);
		LocalDate partenza =  LocalDate.of(2024, 8, 22);
		System.out.println("Vacanze: " + arrivo.until(partenza, ChronoUnit.DAYS));
		

		//La classe period mi permette di creare dei blocchi di tempo di anni mesi o giorni 
		//i metodi plus() e minus() mi permettono di aggiungere o togliere tempo
		LocalDate tra15Giorni = oggi.plus(Period.ofDays(15));
		System.out.println(tra15Giorni.getDayOfWeek());
		
		System.out.println(Locale.getDefault());
		Locale.setDefault(Locale.US);
		
		System.out.println("==================== ChronoUnit ==================");
		//Un altro modo per calcolare il tempo è java.time.temporal.ChronoUnit

		long giorniTrascorsi = ChronoUnit.DAYS.between(natale1, oggi);
		System.out.println(giorniTrascorsi);//permette di calcolare la differenza tra le date
				
//DATE_TIME FORMATTER				
		//Attraverso dei placeholder ci permette di formattare come deve essere passata
		//una data a un oggetto localDate o come stamparla
		// DateTimeFormatter formatter = DateTimeFormatter.ISO_ORDINAL_DATE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMMM dd/MM/yyyy");
		System.out.println(oggi.format(formatter));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
