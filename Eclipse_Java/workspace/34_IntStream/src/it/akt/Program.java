/*
    IntStream è una classe introdotta in Java 8 che rappresenta un flusso di valori interi primitivi.
    È parte del package java.util.stream ed è specializzato per lavorare in modo efficiente con int,
    evitando l'auto-boxing (conversione tra int e Integer).

    Fornisce metodi potenti per operazioni come:
    - filter()
    - map()
    - reduce()
    - forEach()
    - sum(), average(), max(), min(), ecc.
*/

package it.akt;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Program {

    public static void main(String[] args) {

        // Creazione di uno stream da un array di interi
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        
        // NB: uno stream può essere consumato una sola volta.
        // Quindi, lo ricreo direttamente nella pipeline.
        IntStream.of(numbers)
                 .filter(n -> n % 2 == 0)   // Filtra solo i numeri pari, si possono utilizzare le stesse lettere nelle parentesi perchè variabili locali
                 .map(n -> n * 2)           // Raddoppia ogni numero
                 .forEach(System.out::println); // Stampa i risultati uno per riga

        // Method reference: System.out::println è equivalente a n -> System.out.println(n)

        System.out.println("======= Tombola: numeri pari da 1 a 90 =======");

        // Generazione di un array contenente tutti i numeri pari tra 1 e 90 (incluso 90)
        int[] tombolaPari = IntStream.rangeClosed(1, 90)      // Include 90, genera valori da 1 a 90
                                     .filter(n -> n % 2 == 0) // Pari, filtra i numeri pari
                                     .toArray();              // Terminal operation → array, li scarico in un array

        System.out.println(Arrays.toString(tombolaPari));     // Stampa l’array

        System.out.println("======= Anni NON bisestili (ordinati) =======");

        // Verifica degli anni NON bisestili
        IntStream.of(2021, 1900, 2020, 1997, 2024, 2008, 1975, 2000)
                 .filter(anno -> !isBisestile(anno))  // Filtra solo quelli non bisestili
                 .sorted()                           // Ordina in modo crescente
                 .forEach(System.out::println);      // Stampa uno per riga

        
        
    //Metodo .map()
/*        
        Cos'è map()?
		Il metodo map() serve per trasformare gli elementi di uno stream uno per uno.
        
        Caratteristiche principali:     
		• map() è intermedio → cioè fa parte della pipeline, ma da solo non esegue nulla finché non arriva un'operazione terminale (es. forEach(), collect(), count()...).
		• Non modifica l'originale, ma restituisce un nuovo stream.
		• Può cambiare il tipo degli elementi: da String a Integer, da Integer a Double, ecc.
		 
		Sintassi:
		stream.map(elemento -> trasformazione)
*/        
        IntStream.of(1, 2, 3, 4, 5)
	        .map(n -> n * 2) //moltiplica l'elemento per 2
	        .forEach(System.out::println);

        
    }

    
    // Funzione di utilità per verificare se un anno è bisestile
    public static boolean isBisestile(int anno) {
        return (anno % 400 == 0 || (anno % 100 != 0 && anno % 4 == 0));        
    }


}
