package it.akt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*  LINKED LIST
Una LinkedList in Java è una struttura dati dinamica che rappresenta una sequenza ordinata di 
elementi, simile a un'ArrayList, ma basata su nodi collegati invece di un array sottostante. 
Ogni nodo contiene un valore (l'elemento) e un riferimento al nodo successivo nella sequenza.

Componenti di un nodo:
	• data: L'elemento effettivo memorizzato nel nodo, di qualsiasi tipo generico.
	• prev: Un riferimento al nodo precedente nella lista. 
	• next: Un riferimento al nodo successivo nella lista. 

     ┌───────┐      ┌───────┐      ┌───────┐
null │ prev  │<───► │ prev  │<───► │ prev  │
     │ "A"   │      │ "B"   │      │ "C"   │
     │ next  │ ───► │ next  │ ───► │ next  │
     └───────┘      └───────┘      └───────┘
        ▲                               │
        └────────────── null ◄──────────┘

		Ogni nodo in Java è una classe interna definita più indicativamente come segue:
			private static class Node<E> {
			    E item;
			    Node<E> next;
			    Node<E> prev;
			}


*/
public class ListLinkedListProgram {

	public static void main(String[] args) {

		List<Integer> listaDiInteri = new LinkedList<>();
		//LinkedList<Integer> listaDiInteri = new LinkedList<>();
		
		System.out.println("dimensione della lista = " + listaDiInteri.size());
		System.out.println("la lista è vuota? " + listaDiInteri.isEmpty());
		
		listaDiInteri.add(50);
		listaDiInteri.add(30);
		listaDiInteri.add(50);
		listaDiInteri.add(0, 10);
		
		System.out.println(listaDiInteri);
		
		System.out.println(listaDiInteri.contains(30));
		System.out.println(listaDiInteri.indexOf(50));
		System.out.println(listaDiInteri.lastIndexOf(50));
		
		
//		addFirst(E element): Aggiunge un nuovo nodo all'inizio della lista.
		listaDiInteri.addFirst(12);	//primo elemento
		
//		addLast(E element): Aggiunge un nuovo nodo alla fine della lista.
		listaDiInteri.addLast(41);	//ultimo elemento
		
//		getFirst(): Restituisce il valore del primo nodo (se la lista è vuota lancia un'eccezione).
		System.out.println(listaDiInteri.getFirst());	//legge il primo elemento
		
//		getLast(): Restituisce il valore dell'ultimo nodo (se la lista è vuota lancia un'eccezione).
		System.out.println(listaDiInteri.getLast()); //legge ultimo elemento
		
//		removeFirst(): Rimuove il primo nodo dalla lista e restituisce il suo valore.
		listaDiInteri.removeFirst();	//rimuove dalla lista
		System.out.println(listaDiInteri);
		
//		removeLast(): Rimuove l'ultimo nodo dalla lista e restituisce il suo valore.
		listaDiInteri.removeLast();
		System.out.println(listaDiInteri);		
		
		// listaDiInteri.remove((Integer) 50);    //devo fare il cast altrimenti cerca di eliminare int 50 ovvero il valore literal
												  //mentre io devo passare il valore abbinato all'oggetto il cui valore è 50 - di fatto è un puntatore!!!		
		// listaDiInteri.remove(1);
		// listaDiInteri.clear();				  //svuota tutta la lista
		
		listaDiInteri.set(1, 70); //modifica posizione di un valore/posizione, valore
		
		for (int i = 0; i < listaDiInteri.size(); i++)	//ciclo for per percorrere le liste
			System.out.print(listaDiInteri.get(i) + " ");
		System.out.println();

		for (int numero : listaDiInteri)	//foreach
			System.out.print(numero + " ");
		System.out.println();
		
		Iterator<Integer> iteratore = listaDiInteri.iterator(); //stampa oggetto e si sposta sul prossimo con hasNext
		while (iteratore.hasNext())
			System.out.print(iteratore.next());
		System.out.println();
				
			
		
	}


}
