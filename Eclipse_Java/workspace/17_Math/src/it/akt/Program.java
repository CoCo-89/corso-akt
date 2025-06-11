
//RIFERIMENTO: Java - Maggi ed 2024 - pagg. 248-250, 142
//											Math	 import static
 
package it.akt;

import static java.lang.Math.sin; //è comunque un import a tutti gli effetti e va subito sotto il package
//static import che serve per richiamare la classe Math senza scriverla ogni volta
//Math. per vedere tutta la lista delle funzioni Math


public class Program {

	public static void main(String[] args) {

/*
	la classe Math fa parte di java.lang e serve per eseguire 
	operazioni matematiche attraverso i suoi metodi
	La classe Math non si può istanziare: il costruttore di Math 
	è private quindi ha un comportamento simile ad una classe astratta!
			Math math = new Math(); ERRORE! NB= NON VA ISTANZIATA

	Ovviamente, per permetterne il funzionamento, la maggior parte dei 
	metodi di Math sono STATICI NB= SONO TUTTI STATIC
	
	Questo significa che si possono richiamare senza bisogno 
	di avere un oggetto sui quali invocarli ma li posso chiamare 
	direttamente sulla classe. 
		Math.nomeMetodo();
		Math.CONSTANTE;
	
	Se uso spesso un metodo o una costante posso fare
	import static java.lang.Math.metodo;
	
	Questo permette di richiamare i metodo o la costante specificati 
	senza bisogno di specificare Math. ogni volta.	
	
	Quasi tutti ricevono valori double e ritornano double

*/
		
		double numero = 4;
		
		//tutti i metodi della classe Math sono statici
		//si invocano direttamente sulla classe
		System.out.println( Math.sqrt(numero) );	//radice quadrata(n)
		System.out.println( Math.pow(5, 2));		//potenza 5^2	= 25 ||	base, esponente
		System.out.println( Math.log(numero) );		//logaritmo(n)
		

		//questa sintassi richiede l'import static del metodo sin
		System.out.println( sin(numero) );			//seno(n)
		
		//In Math troviamo anche le due costanti PI e E 
		System.out.println( Math.PI ); //costante del P Greco
		System.out.println( Math.E );
		
		double valore = 1.5;
		
		//il metodo floor arrotonda sempre per difetto
		System.out.println( Math.floor(valore) );	//arrotonda sempre per difetto
		
		//il metodo ceil arrotonda sempre per eccesso
		System.out.println( Math.ceil(valore) );	//arrotonda per 2
		
		//da .0 a .4 arrotonda per difetto, da .5 a .9 arrotonda per eccesso
		System.out.println( Math.round(valore) );	//arrotondamento classico
		
		//il metodo random genera un numero casuale 
		//compreso tra 0.0 (incluso) e 1.0 (escluso)
		//si usava prima di Java 6
		System.out.println( Math.random() );	//non si usa più
		
		//simulo il lancio di un dado a 6 facce
		System.out.println( (int)(6 * Math.random()) + 1 );
	
		// valore assoluto
		System.out.println( Math.abs(-10) ); // 10 ingnora il segno

		// massimo e minimo tra due numeri
		System.out.println( Math.max(10, 20) ); // 20	numero massimo
		System.out.println( Math.min(10, 20) ); // 10	numero minimo
		
		
		
		
		
	}

}
