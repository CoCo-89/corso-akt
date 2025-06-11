package it.akt;

public class Statistica {

/*
 	Questo metodo è scritto anche peggio di quello precedente... 
	
	media dovrebbe essere double, non dovrei usare calcolatrice che contiene una unchecked exception
	ed altre accortezze che potrei aggiungere...
 
	Detto ciò, creo il mio metodo, e sapendo di avere calcolatrice a disposizione decido di usarla.
 
 */
	
	public int media(int... valori) throws Exception {
		Calcolatrice calcolatrice = new Calcolatrice();
		int somma = 0;
		
		for (int valore : valori)
			somma += valore;
		
		return calcolatrice.divisione(somma, valori.length);
	}
		
	//Ora andiamo in Program e vediamo cosa succede e come di propagano le eccezioni 
	//quando uso questi metodi 
	
	
}
