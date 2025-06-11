package it.akt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
COLLEZIONI: List<E>

L'interfaccia List in Java estende l'interfaccia Collection e fornisce 
funzionalità aggiuntive per gestire collezioni ordinate di elementi. 
Ecco alcune delle sue caratteristiche principali:

• Ordine: A differenza di Set, gli elementi in una List mantengono 
			un ordine di inserimento. È possibile accedere agli elementi 
			in base alla loro posizione (indice) nella lista.

• Duplicati: A differenza di Set, le List possono contenere elementi 
			duplicati. Lo stesso elemento può apparire più volte nella 
			lista.
	
	
Scegliere l'implementazione giusta:
-----------------------------------
•	Accesso casuale frequente: 
			ArrayList o Vector (se è richiesta la sincronizzazione).
•	Inserimento/rimozione frequenti in mezzo alla lista: 
			LinkedList.
•	Accessi concorrenti multithread: 
			Vector (Obsoleto) o CopyOnWriteArrayList.
•	Struttura LIFO: 
			Stack.	
	

	
  CARATTERISTICHE DELLE IMPLEMENTAZIONI
==========================================			
List ha diverse implementazioni in classi:
1. ArrayList (la più comune):
	Basata su array, offre un accesso casuale efficiente (get, set) tramite
		indici. 
	Memorizzazione efficiente in memoria.
	Meno efficiente per l'inserimento/rimozione di elementi in mezzo alla 
		lista, causando lo spostamento degli elementi successivi.
	Adatta a scenari che richiedono frequenti accessi casuale e sequenziali 
		agli elementi.


2. LinkedList:
	Basata su nodi collegati, offre un'inserimento/rimozione efficiente in 
		mezzo alla lista.
	Meno efficiente per l'accesso casuale (get, set) a causa della ricerca 
		lineare.
	Richiede più memoria per i nodi di overhead.
	Utile quando è frequente modificare l'ordine degli elementi o 
		inserire/rimuovere elementi in mezzo alla lista.
	
	
3. Vector:
	Simile ad ArrayList, ma sincronizzata per l'accesso multithread.
	Le operazioni di lettura e scrittura sono thread-safe, con un overhead 
		di prestazioni.
	Utile in scenari multithread dove l'accesso concorrente alla lista deve 
		essere controllato.
	
	
4. CopyOnWriteArrayList:
	Un ArrayList thread-safe con un'implementazione "copia su scrittura".
	Le modifiche alla lista creano una nuova copia interna, garantendo 
		la visibilità coerente agli altri thread che iterano sulla lista.
	Utile per scenari multithread dove la modifica della lista avviene 
		frequentemente durante l'iterazione.


5. Stack:
	Un'implementazione List che segue la regola LIFO (Last In, First Out).
	Le operazioni di push, pop e peek sono efficienti.
	Utile per implementare scenari come la gestione di una pila di chiamate 
		o l'annullamento/ripristino delle azioni.
*/	
public class ListArrayListProgram {

	public static void main(String[] args) {


		// ArrayList<Integer> numeriInteri = new ArrayList<>();
		List<Integer> numeriInteri = new ArrayList<>();
		
		//.add aggiunge elementi alla lista
		numeriInteri.add(50); //vanno aggiunti in coda
		numeriInteri.add(20);
		numeriInteri.add(60);
		numeriInteri.add(20);
		numeriInteri.add(0, 30);  // posso scegliere la posizione del valore, a patto che l'indice sia incluso nella lunghezza dell'array
		// numeriInteri.add(10, 40); ERRORE!   out of bounds!
		//NB. posizione esistente e viene shiftato il blocco inserendo il valore nell'indice indicato
		
		//non abbiamo .capacity()  ma size()	Questo perché l'array, per migliorare le prestazioni è costrutito in linguaggio nativo, ovvero in C++.	
		System.out.println("dimensione lista = " + numeriInteri.size()); //dimensione liste, quanto elementi compone la lista
		System.out.println("la lista è vuota? " + numeriInteri.isEmpty()); //metodo che specifica se la lista è vuota, restituisce un booleano
		//con is davanti il metodo restituisce quasi sempre un booleano
		
		System.out.println("la lista contiene il valore 20? " + numeriInteri.contains(20)); //restituisce booleano, si può andare direttemanete a cercare l'elemento
		System.out.println("indice del valore 20 = " + numeriInteri.indexOf(20));	
		System.out.println("indice dell'ultimo 20 = " + numeriInteri.lastIndexOf(20));
		
		numeriInteri.set(2, 40);	//modifica dell'elemento con il set
		System.out.println("elemento in posizione 2 = " + numeriInteri.get(2));	//restituisce la posizione dell'elemento
		
		for (int i = 0; i < numeriInteri.size(); i++)	//normalmente si usano i for
			System.out.print(numeriInteri.get(i) + " ");	//metodo get per passare il risultato
		System.out.print('\n');
		
		for (int numero : numeriInteri)	//foreach per estrarre un numero
			System.out.print(numero + " ");	//anche se Integer riesce a castare
		System.out.print('\n');
		
		Iterator<Integer> iteratore = numeriInteri.iterator();	//classe di servizio per percorrere le collezione con un altro sistema creando Iteratore dello stesso tipo generic dichiarato
		while (iteratore.hasNext())	//per collezioni di grandi dimensioni testare quale metodo sia migliore tra il foreach e iterator
			System.out.print(iteratore.next() + " ");
		System.out.print('\n');
		
		System.out.println(numeriInteri.toString());  //stampa direttamente il contenuto dell'arrayList come anteprima
		
		numeriInteri.remove(0); // 0 rappresenta l'indice dell'elemento da rimuovere
		numeriInteri.remove((Integer) 60); //se invece gli passo 60, gli sto passando il valore letterale 60, e il compilatore si confonde quindi devo castare a integer
		// numeriInteri.clear();
		
		System.out.println(numeriInteri.toString());
		
		String[] nomi = { "Lucia", "Riccardo", "Gabriele", "Giovanni", "Maria", "Lucia" };	//lista di inizializzazione da utilizzare con classi Wrapper
		Set<String> setDiNomi = new TreeSet<>(Arrays.asList(nomi));  //La classe Arrays di java.util ha un metodo asList che ci permette di passare i dati come una lista di valori
		List<String> listaDiNomi = new ArrayList<>(setDiNomi);  //dopo aver eliminato i duplicati, ripasso i nomi alla list
		listaDiNomi.set(1, "Marina");
		listaDiNomi.add("Gabriele");
		Collections.sort(listaDiNomi);  //riordino i nomi usando la classe Collections perché sort di ArryaList vuole un metodo comparator ovvero un'espressione lambda
		
		String[] nuovoArray = new String[listaDiNomi.size()];
		listaDiNomi.toArray(nuovoArray);
		System.out.println(Arrays.toString(nuovoArray));
		

	}

}
