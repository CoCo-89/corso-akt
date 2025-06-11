package it.akt;

public class Calcolatrice {

	/*
	Come detto, questo metodo è scritto volutamente malissimo... è un pessimo esempio di codice... 
 	Ci serve per obbligarlo a lanciare una runtime exception.
 */	 
	
	//METODO
	public int divisione(int numero1, int numero2) throws Exception  {
		//partiamo da qui...
		int risultato = numero1 / numero2; 
		//return numero1 / numero2;   //Questo se numero2 == 0 non funziona!

		
//Potrei tentare una soluzione di questo tipo (vedi codice che segue), ma è 
//matematicamente sbagliata perché la mia divisione per 0  ritornerebbe 0!
		
//		int risultato = 0;
//		try {
//			risultato = numero1 / numero2;
//		} catch (ArithmeticException e) {
//			System.err.println(e.getMessage());
//		}
//		return risultato;


//Oppure posso lanciare io un'eccezione! Se lancio una unchecked exception NON sono 
//obbligato a propagarla con il THROWS SUL METODO
//		if (numero2 == 0) throw new ArithmeticException("divisione per zero");



//INVECE se lancio una CHECKED exception (uso exception o uno dei suoi sottotipi) devo propagarla
//	questo mi obbliga ad usare un blocco try catch in Statistica o a propagare ancora l'eccezione
//NOTA: non è una buona pratica usare throw con Exception!!! Cercare di usare Eccezioni specifiche!
		if (numero2 == 0) throw new Exception("divisione per zero");
		return numero1 / numero2;
	
	}
	
	
}