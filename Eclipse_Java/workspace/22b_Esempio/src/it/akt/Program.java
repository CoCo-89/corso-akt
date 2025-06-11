package it.akt;

import it.akt.due.Seconda;
import it.akt.uno.Prima;
import it.akt.uno.PrimaSottoclasseInterna;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Prima primaObj = new Prima();
		
		PrimaSottoclasseInterna.metodo(primaObj);
		//La classe Seconda essendo privata a livello di package (mod: default)ù
		//Non è visibile al di fuori del proprio package nemmeno importandola
		//Seconda secondaObj = new Seconda();
		
		//GETTER E SETTER (accessor e mutator)
		String str = primaObj.getPrivato();
		System.out.println(primaObj.getPrivato());
		
		primaObj.setPrivato("nuovo valore privato");
		System.out.println((primaObj.getPrivato()));
		
		Seconda sec = new Seconda("qualcosa", 12000);
		System.out.println(sec.getEta());
	}

}
