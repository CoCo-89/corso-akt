package it.akt.uno;

//E' una sottoclasse di Prima e sta nello stesso Package
public class PrimaSottoclasseInterna extends Prima{
	
	//Questo metodo riceve in ingresso un oggetto generato da Prima 
	//in modo da poter testare l'accessibilità di tutti i campi
	public static void metodo (Prima primaObj) {
		//provo a vedere quali campi dell'oggeto generato da Prima sono visibili
		System.out.println(primaObj.pubblico);
		//System.out.println(primaObj.protetto);	non più visibile: altro package
		//System.out.println(primaObj._default);	non più visibile: altro package
		//System.out.println(primaObj.privato); è visibile solo nella classe Prima
		
		
	}
	
	
	
	
	

}
