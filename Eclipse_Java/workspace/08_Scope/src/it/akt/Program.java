package it.akt;

public class Program {

	//variabili d'istanza
	int numero = 100;
	String nome = "Mario";
	
	//variabili di classe a causa della presenza di 'static')
	static int num = 90;
	static String nome1 = "Lucia";
	
	
	public static void main(String[] args) {
		// Scope delle variabili: ambito di visibilità
		
/* Esistono diversi tipi di scope:
 * per blocco
 * per metodo
 * per classe o per istanza
 */
		
	//System.out.println(nome); non posso utilizzarlo essendo una variabile d'istanza
		System.out.println(nome1);
		
	boolean risultato;
	System.out.println(risultato = isBigger(5, 8));
	
	System.out.println("risultato invertito: " + !risultato);
	
	//Scope nei blocchi: una variabile esiste solo nel blocco in cui viene creata
	//e nei sottoblocchi
	{
		int x = 10;
		{
			int interna = 50;
			System.out.println(x);
			System.out.println(interna);
		}	// interna esiste solo all'interno del blocco di codice. Muore quando
			//arrivo alla graffa che lo delimita
		
		System.out.println(x);
		//System.out.println(interna);	qui interna non esiste più
		
		
	}
	int risultato1; //o lo inizializzo qui o devo gestire anche un else per 
					//assegnare a risultato1 un valore nel caso in cui la condizione sia false.
	int a=10, b=30;
	if(a>b) {
		risultato1 = a+b;
	} else {
		risultato1 = 0;
	}
	
	System.out.println("Risultato della condizione: " + risultato1);
	
	
	
	
	
	}// fine del main
	//a e b sono 2 variabili locali che esistono solo dentro questo metodo
	//(esempio metodo somma)
	//marcare come static per richiamarli nel main altrimenti non funzionano
	public static int somma(int a, int b) {
		return a+b;
	}
	
	public static boolean isBigger (int a, int b ) {
		if(a > b) {
			return true;
	}else {
			return false;
			}
	}
}// fine classe
