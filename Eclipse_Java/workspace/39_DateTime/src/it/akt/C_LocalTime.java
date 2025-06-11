package it.akt;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class C_LocalTime {

	public static void main(String[] args) {

//Il funzionamento è analogo a LocalDate		
		LocalTime adesso = LocalTime.now();
		System.out.println(adesso);
		
		// LocalTime fineLezione = LocalTime.of(18, 0);
		LocalTime fineLezione = LocalTime.parse("18:00:00");
		
		long quantoManca = ChronoUnit.MINUTES.between(adesso, fineLezione);
		System.out.println(quantoManca);
		
		System.out.println(adesso.getHour());
		System.out.println(adesso.getMinute());
		System.out.println(adesso.getSecond());
		System.out.println(adesso.getNano());
		
		
//Qui invece di Period abbiamo Duration, ed anche qui abbiamo i metodi plus() e minus()	
		System.out.println("Tra 30 minuti: " + adesso.plus(Duration.ofMinutes(30)));
		
		Instant start = Instant.parse("2024-04-10T10:15:30.00Z");
		Instant end = Instant.parse("2024-04-10T10:16:30.00Z");
		Duration duration = Duration.between(start, end);
		
		System.out.println("Durata: " + duration);
		//oppure
		Instant ora = Instant.parse(LocalTime.now().toString());

//Confronto tra durate
		Duration duration1 = Duration.ofMinutes(30);
		Duration duration2 = Duration.ofHours(1);

		if (duration1.compareTo(duration2) < 0) {
		    System.out.println("duration1 è minore di duration2");
		} else if (duration1.compareTo(duration2) > 0) {
		    System.out.println("duration1 è maggiore di duration2");
		} else {
		    System.out.println("duration1 è uguale a duration2");
		}


	}

}
