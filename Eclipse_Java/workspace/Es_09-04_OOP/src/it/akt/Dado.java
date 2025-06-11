package it.akt;

public class Dado {
	
	//Campi
	private int numeroFacce;	//dichiarazione di generalizzazione del campo di ogni dado
	
	//Costruttore
	public Dado(int numeroFacce) { //Variabile locale assegnata nel main
		if(numeroFacce <4 || numeroFacce >120 || numeroFacce%2 != 0) //condizione di controllo
			System.err.println("Numero facce errate!");
		else
			this.numeroFacce = numeroFacce; //attribuisce facce al dado
	}
	
	//Getter
	public int getNumeroFacce() {	//Mi permette di restituire il valore dell'attributo private
		return numeroFacce;
	}
	
	//Nessun setter perchè mi permetterebbe di modificare il numero di facce del dado durante la partita

}
