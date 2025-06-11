package it.akt;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class D_LocalDateTime {

	public static void main(String[] args) {
//LocalDateTime unisce in un unico dato sia Data che Ora
		
		LocalDateTime oggi = LocalDateTime.now();	
		System.out.println(oggi);
		
		LocalDateTime now = LocalDateTime.now();
		Duration duration = Duration.ofHours(2);
		LocalDateTime later = now.plus(duration);

		System.out.println("Data e ora attuale: " + now);
		System.out.println("Data e ora dopo 2 ore: " + later);

		
		
		
//In queste classi che abbiamo visto esistono anche delle costanti		
		System.out.println(LocalDateTime.MAX);
		System.out.println(LocalDateTime.MIN);
		System.out.println(LocalTime.NOON);
		System.out.println(LocalTime.MIDNIGHT);		
		
		
		
	}

}
