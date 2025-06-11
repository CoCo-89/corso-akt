package it.akt;

public class Program {

	public static void main(String[] args)  {
// Per fare un esempio di funzionamento, scriveremo due PESSIME classi Calcolatrice e Statistica
// Pessime perché ci serve che si comportino male per generare le eccezioni necessarie alla spiegazione
// Creiamo Calcolatrice e Statistica
		
		
		//Proviamo le varie soluzioni con la classe Calcolatrice...
//		 Calcolatrice calcolatrice = new Calcolatrice();
//		 System.out.println(calcolatrice.divisione(5, 0));		
		
		
/*		Vediamo cosa succede con Statistica...
		Mi creo un array di int[].
		Poi istanzio statistica e chiamo il metodo....
		Ma se l'array fosse vuoto?	Magari i dati mi arrivano da una sorgente esterna e 
			per qualche motivo oggi	non ne ho ricevuti...
		Il programma parte in automatico e calcola la media...
		L'eccezione parte sempre da Calcolatrice!
		
		A questo punto posso provare a gestire l'eccezione con un blocco try catch
	
*/	
		//int[] valori = {10, 20, 25, 33};
		int[] valori = { };
		Statistica statistica = new Statistica();
		try {
			System.out.println(statistica.media(valori));
		} catch (Exception e) {
			System.err.println("Si è verificato un errore... " + e.getMessage());
			e.printStackTrace();
		}
		
	
	}
}