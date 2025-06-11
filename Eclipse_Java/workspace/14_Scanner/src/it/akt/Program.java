package it.akt;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
/*
	Classe SCANNER - Acquisizione di Stream in ingresso da tastiera

	Scanner va importata da java.util.Scanner 
	NOTA: le classi che non stanno in java.lang DEVONO essere tutte importate!
		
	Scanner è in grado di acquisire su qualsiasi input nel computer, ma per ora ci limitiamo a 
	usarla per acquisire input da tastiera.
	
	CTRL e clic sulla classe si possono vedere come sono scritte le classi stesse
*/		
		
		Scanner scanner = new Scanner(System.in);  //da importare con tasto destro o con ctrl + spazio
		//al costruttore di scanner devo passargli la fonte dei dati (System.in) rappresenta la console
		//in per catturare info sulla console
		//out
		//print
		
		//Creo un'interazione con l'utente stampando una semplice domanda, dando comando all'utente:
		System.out.println("Come ti chiami?");
		
		//Dopo aver istanziato e inizializzato la classe scanner la posso usare:
		//Ho a disposizione diversi metodi  next...() , che variano 
		//in  base al tipo di carattere che devo acquisire
		
		//per le stringhe uso .next() oppure .nextLine()
		//se usassi next()  si fermerebbe al primo spazio ' ' che incontra
		String nome = scanner.nextLine(); //cattura i caratteri che vengono digitati di seguito
		//next cattura sempre le stringhe si ferma al primo spazio che incontra
		//nextline cattura tutto fino a quando non premo invio
		
		
		System.out.println("Quanti anni hai?"); //int per chiedere età o qualcosa con numeri interi
		int eta = scanner.nextInt();
		//con dati di tipo double lo scanner si inceppa
		
		//A volte, l'Invio a capo mi fa  saltare un input perché il tasto invio corrisponde a \r\n
		//a volte capita che venga letto solo il \r e il \n venga preso automaticamente dallo scanner seguente 
		//In questo casi, per risolvere, posso solo aggiungere un nextLine() vuoto
		//scanner.nextLine();
		System.out.println("Quanto pesi?");  
		int peso = scanner.nextInt();
		
		
		
		System.out.println("Ciao " + nome);
		System.out.println("Hai " + eta + " anni");
		System.out.println("Il tuo peso è " + peso + " kg");
		
		//Poi devo chiudere lo scanner:
		scanner.close();
		//lo streaming resterebbe aperto e a rischio hacker
		//per via di processi in background
		//appesentisce il sistema
		//ogni streaming va chiuso con uno scanner.close
		//visibile in gestione attività
		
		

		//In alternativa esiste una classe Console (non compatibile con ambiente IDE)
		//ma non è utilizzata perché appunto limitata alla console e leggermmente 
		//più complicata da usare.
		
		
		
	}

}
