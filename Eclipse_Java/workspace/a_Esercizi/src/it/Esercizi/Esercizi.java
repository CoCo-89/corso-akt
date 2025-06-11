package it.Esercizi;

import java.util.Random;

public class Esercizi {

	public static void main(String[] args) {
		/* ================= ESERCIZI DATATYPE ================
		- b1. Dichiarazione e inizializzazione:
		• Dichiara variabili di tipo int, double, char e boolean e inizializzale con valori a tua scelta.
		• Stampa a schermo il valore e il tipo di ciascuna variabile.
		*/
		
		int numero = 10;
		double dbl = 2.5;
		char chr = 'a';
		boolean bln = true;
		
		System.out.println(numero);
		System.out.println(dbl);
		System.out.println(chr);
		System.out.println(bln);
		
		
		/*b2. Conversioni implicite:
			• Assegna un valore di tipo int a una variabile di tipo double.
			• Stampa a schermo il risultato. Cosa noti?
		*/
		
		double dbl2 = 27;
		System.out.println(dbl2);
		
		
		/*b3. Cast espliciti:
		• Converti un valore di tipo double in un int.
		• Cosa succede alla parte decimale? Prova con diversi valori.
		*/
		
		int num = 20;
		double dou = 1.1;
		int num_dou = (int)dou;
		System.out.println(num_dou);
		
		/*b4. Operazioni aritmetiche:
			• Esegui diverse operazioni aritmetiche (somma, sottrazione, moltiplicazione, divisione) tra variabili di tipo int e double.
			• Osserva i risultati e i tipi dei risultati.
		*/
		
		int corrado = 36;
		double sara = 2.6;
		System.out.println(corrado + sara); //restituisce la somma in double
		System.out.println(corrado - sara); //restituisce la differenza in double
		System.out.println(corrado * sara); //restituisce il prodotto in double
		System.out.println(corrado / sara); //restituisce la divisione in double
		System.out.println(corrado % sara); //restituisce il resto
		
		/*b5. Altre operazioni applicate:
		• Dichiarare le variabili necessarie per calcolare perimetro e area di un rettangolo
		• Stampare a console il risultato nel seguente modo:  
				L'area del rettangolo è xxx
				Il perimetro del rettangolo è yyy
		*/
		
		int b = 30;
		int h = 60;
		int p = (p = (b+h)*2);
		int a = (b*h);
		System.out.println("L'area del rettangolo è " + a);
		System.out.println("Il perimetro del rettangolo è " + p);
		
		/*i2. Caratteri e numeri:
		• Converti un carattere numerico (es. '5') nel suo equivalente numerico di tipo int.
		• Converti un numero intero (es. 65) nel suo equivalente carattere (es. 'A').
		 */
		
		String carattere = "5";
		int carNum = Integer.parseInt(carattere);
		System.out.println(carattere);

		int numInt = 65;
		char chrEqui = (char) numInt;
		System.out.println(chrEqui);
		
//==================== ESERCIZI CONDIZIONI ===============		
		
		/*Esercizio 1
		Il programma legge due numeri e controlli se il primo è maggiore del secondo.
		*/
		
		int num1 = 5;
		int num2 = 2;
		if (num1 > num2) {
			System.out.println("Vero");
		} else {
			System.out.println("Falso");
			
		}
		
		/*Esercizio 2
		L’utente inserisce la propria età e il programma dice se è maggiorenne (ovvero con età maggiore uguale a 18 anni)
		*/
		
		int etaUtente = 36;
		if (etaUtente>=18) {
			System.out.println("E' maggiorenne");
		} else {
			System.out.println("Non è maggiorenne");
		}
		
		/*Esercizio 3
			Definire l’età a cui si può prendere la patente nello stato in cui si vive (in Italia a 18 anni)
			poi definire  l’utente quanti anni ha; il programma risponde se l’utente può prendere la patente.
		 */
		
		int patente = 18;
		int utente = 20;
		if (utente >= patente) {
			System.out.println("Può prenderla");
			} else {
				System.out.println("Non può prenderla");
				}
		
		/*Esercizio 4
		Il programma legge due numeri e controlla se il primo è multiplo del secondo.
		*/
		
		int num3 = 50;
		int num4 = 5;
		if (num3 % num4 == 0) { //se resto non è multiplo
			System.out.println("Si");
		} else {
			System.out.println("No");
		}
		
		/*Esercizio 8
	Scrivere un programma che, richiesti in input tre numeri interi, visualizzi a seconda dei casi una delle seguenti risposte:
	– Tutti uguali
	– Due uguali e uno diverso (indicando i numeri uguali)
	– Tutti diversi
		 */
		
		int num5 = 10;
		int num6 = 20; 
		int num7 = 30;
		switch (num5) {
		case 1:
			if(num5 == num6 && num6 == num7)
				System.out.println("Tutti uguali");
			break;
		
			
		}
			
			
		
//==================== ESERCIZI CICLI ===================
		
		/*ESERCIZIO 1
		Sommare i primi 10 numeri interi e restituire il risultato
		*/
		
		int conteggio = 0;
		for(int somma = 0; somma <10; somma++) { //seconda variabile assegnata direttamente nel ciclo
												 //finchè la seconda variabile risulta minore di 10, viene incrementata di 1 creando un ciclo fino a 10
			conteggio += somma; //istruzione in modo sintetico
			System.out.println("Il risultato finale è " + conteggio);
		}
		
		/*ESERCIZIO 2
		Catturare 10 numeri in input da tastiera e contare quante volte viene inserito il numero 9. Restituire il dato all'utente
		*/
		
		int[] numeriInInput = {1,2,3,4,5,6,7,8,9,10};
		for(int num9 = 9; num9 == 9; num9++) {
			System.out.println("Il numero 9 viene contato solo una volta");
			System.out.println(numeriInInput[num9]);
			
			
			}
		
		/*ESERCIZIO 3
		Catturati 5 numeri, dire quale è il più piccolo inserito
		 */
		
		int[] numeri = {1,2,3,4,5};
		for (int numpic = 1; numpic <=5; numpic++) {
			if (numpic <2) {
				System.out.println("1 è il numero più piccolo");
			}
		}
		
		
		/*ESERCIZIO 6
		Stampare a video tutti i numeri pari compresi tra due estremi rappresentati dalle variabili x e y.
		*/
		
		int x = 1;
		int y = 10;
		System.out.println("Numeri pari tra " + x + " e " + y + ":");
		for(int i = x; i <= y; i++) {
			if (i % 2 == 0) {
				System.out.println(i + " ");
			}
		}
				
		
//=================== ESERCIZI ARRAY ==================
		
		//Esercizio 01 - Cicli
		//Scrivere un programma in grado di stampare in modo ordinato la tabelina del 5;

		for(int r = 5; r <=5; r++) {
			for(int c = 1; c <=10; c++) {
				System.out.printf("%4d", r*c);
			}
			System.out.println();
		}
		
		//==================================================================================

		/*Esercizio 02 - Cicli
		Scrivere un programma in grado di stampare in modo ordinato tutte le tabeline
		da 3 a 30 sia sulle righe che sulle colonne (l'ultimo numero sarà 900);
		 */
		
		for(int r1 = 3; r1 <= 30; r1++) {
			for(int c1 = 1; c1 <= 30; c1++) {
				System.out.printf("%4d", r1*c1);
			}
			System.out.println();
		}
		
		//===========================================================================================
		
		/*Esercizio 03 - Cicli
		Dato un numero N scrivere un programma che verifichi se N è un numero primo e stampi un relativo messaggio. 
		Un numero è primo se è divisibile solo per 1 e per sé stesso.
		 */
		
		
		/*Esercizio 06 - Array e cicli:
		Riempire un array di 30 elementi casuali, controllando di inserire solo numeri pari.
		Stampare l'array
		 */
		
		int[] dimArray = new int[30];
		Random random = new Random();
		for (int i = 0; i <= dimArray.length-1;) {
			int estratto = random.nextInt();
			if(estratto%2 == 0) {
				dimArray[i] = estratto;
				i++;
			}
		}
				
		for(int estrazione : dimArray) {
			System.out.println(num + " ");
		}
		
		/* Esercizio 1: Libro
		Campi: titolo (String), autore (String), pagine (int), isCopertinaRigida (boolean).
		Metodi: apri() (stampa un messaggio), leggiPagina() (stampa "Sto leggendo una pagina"), descriviLibro() (stampa tutte le informazioni del libro).
		Crea un oggetto Libro e chiama i suoi metodi.
		 */
		
		
		
		
		
	}// fine main

}// fine classe
