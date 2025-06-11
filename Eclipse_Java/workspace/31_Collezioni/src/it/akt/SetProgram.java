package it.akt;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
LE COLLEZIONI: Set<E>


I dati di un Set hanno 3 caratteristiche:
	1. NON hanno indici con cui cercare gli elementi
	2. NON accetta valori duplicati
	3. In base al tipo hanno diversi modi di ordinare i dati contenuti
			HashSet: 		ordine casuale
			LinkedHashSet:	ordine di inserimento
			TreeSet:		ordine crescente
	
	
Dopo che ho inserito i dati in un Set non so come sono distribuiti nella memoria e NON ho gli 
indici di un Set.

Gli elementi di un Set possono essere estratti tutti insieme, cancellati tutti insieme, ma non 
posso gestirli singolarmente.


Se in un set dispongo: 10, 20, 30, 10, 40, 20;
nel set ci saranno solo: 20, 10, 40, 30 (in ordine ignoto)

Questo funziona perché il set usa o tabelle di Hash (HashSet - dati non ordinati) o alberi 
binari (TreeSet - dati ordinati in ordine crescente)per tenere i dati a disposizione
Grazie a questo sono le collezioni più veloci nel ritornare dati
	• HashSet:	il più veloce
	• TreeSet: 	il più lento perchè per mantenere gli oggetti ordinati, ad ogni inserimento 
				deve riarrangaiare il Set
	• LinkedHashSet: è una via di mezzo. Applica la gestione della memoria Hash con la 
				struttura di una LinkedList - gli elmeenti restano ordinati nell'ordine di 
				inserimento
*/
public class SetProgram {

	public static void main(String[] args) {
		
		//Come istanziare o NON istanziare un Set:
				
				//Collection: Massima flessibilità, verifica del tipo a runtime, codice meno chiaro.
				Collection<Integer> setDiInteri1 = new HashSet<>(); // Meglio di NO! Consumo di risorse e codice poco chiaro
				
				//Set: Flessibilità limitata a Set, verifica del tipo a compile-time, codice più chiaro.
				Set<Integer> setDiInteri2 = new HashSet<>();   //Si
				
				
				//Implementazioni specifiche (HashSet, TreeSet): Ancora più flessibilità limitata, verifica del 
				//tipo a compile-time, codice più chiaro, ottimizzazioni per specifiche operazioni.
				HashSet<Integer> setDiInteri = new HashSet<>();	 //Si	
				
				//ovviamente questo mi fa perdere i metodi aggiuntivi della classe Set
				
				System.out.println("dimensione del set = " + setDiInteri.size());
				System.out.println("il set è vuoto? " + setDiInteri.isEmpty());
				
				//Aggiunta di elementi al Set
				setDiInteri.add(10);
				setDiInteri.add(20);
				setDiInteri.add(20); // il valore 20 è già presente: non viene inserito
				setDiInteri.add(30);
				setDiInteri.add(10); // il valore 10 è già presente: non viene inserito
				
				
				
				//L'unico modo che ho di estrarre gli elementi è un ciclo su tutto il set!
				for (int numero : setDiInteri)
					System.out.print(numero + " ");
				System.out.print('\n');
				
				System.out.println(setDiInteri.toString());
				
				
				/*
					Iterator è una classe particolare che permette di estrarre oggetti da una collezione. 
					Tuttavia, soprattutto quando i dati sono pochi, il forEach è molto più veloce.
					Funziona così:
					Dall'interfaccia, mi creo un'oggetto Iterator. Ovviamente non lo potrei istanziare. 
					Quindi per farlo, chiamo il metodo iterator delle collezioni.
					L'iteratore avrà al suo interno un metodo importantissimo: 
						hasNext()
					questo mi avverte se c'è un altro elemento da estrarre all'interno della collezione, 
					e passa al successivo:			
				*/
				Iterator<Integer> iteratore = setDiInteri.iterator();
				while (iteratore.hasNext())  //fintanto che c'è un elemento da estrarre - hasNext ritorna false 
											 //quando non trova altri elementi.
					System.out.print(iteratore.next() + " ");
				System.out.print('\n');
				
				System.out.println("il set contiene il numero 20? " + setDiInteri.contains(20));
				
				setDiInteri.remove(20);  	//rimuove un singolo valore
				setDiInteri.clear();		//pulisce tutti i valori
				
				System.out.println("dimensione del set = " + setDiInteri.size());
				System.out.println("il set è vuoto? " + setDiInteri.isEmpty());
				
				Double[] decimali = { 1.23, 2.34, 3.45, 2.34, 1.23 };
				
				/*	Vediamo come convertire un array in un set o un set in array
					Le collezioni SET non prevedono l'inizializzazione rapida dei valori in stile array:
					
							Set<Double> setDecimal = new HashSet<>(){1.23, 2.34, 3.45, 1.23};   NO!
							
					Per inserire gli ementi nel set lo possiamo fare sfruttando il suo costruttore:
					Posso ad esempio creare un set da 10 elementi inziali.
					O posso passargli un'altra collezione di dati ma non un array
					Però posso trasformare un array in una collezione di tipo list, questo mi permette 
					di fare il passaggio in 2 step usando Arrays.asList
					
				*/
				// Set<Double> setDiDecimali = new HashSet<>(10);
				Set<Double> setDiDecimali = new HashSet<>(Arrays.asList(decimali));
				System.out.println(setDiDecimali);
				
				
				//Se volessi riconvertire in array...  Devo ricopiare nuovamente i valori dentro un nuovo array, che avrà dimensione
				//setDecimal.size, poi chiamo .toArray e gli passo nuovoArray
				Double[] nuovoArray = new Double[setDiDecimali.size()];  
				setDiDecimali.toArray(nuovoArray);
				
				//Poi lo posso stampare con Arrays.toString
				System.out.println(Arrays.toString(nuovoArray));
				
				// un piccolo esempio di espressione lambda...
				setDiDecimali.forEach(System.out::println);
				
				//containAll, ForEach, ecc... sono metodi particolari che usano delle functional interfaces
				// e quindi usano la sintassi lambda

				
			}

}
