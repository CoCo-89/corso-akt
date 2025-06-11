//step 2
package it.akt;

public class ScatolaGenerica<T> { //<> diamond operator
//la <T> rappresenta un tipo di dato generico, ma omogeneo per tutta l'istanza della classe
	
	//Campo Generico
	private T contenuto; //la T serve per specificare cheil paramento è generico
	
	//Campi normali
	private String campoStringa;
	private int campoInt;
	//ecc...
	
	//Costruttore di default
	public ScatolaGenerica() {}

	
	//Costruttore parametrico
	public ScatolaGenerica(T contenuto, String campoStringa, int campoInt) {	//campoStringa poteva è una variabile locale che può avere qualsiasi nome, ma è consigliato utilizzare già nomi di metodi creati
		this.contenuto = contenuto;
		this.campoStringa = campoStringa;
		this.campoInt = campoInt;
	}


	//Getter setter e altri metodi con generic vengono sviluppati come segue
	public T getContenuto() {
		return contenuto;
	}


	public void setContenuto(T contenuto) {
		this.contenuto = contenuto;
	}
		
	public T elaboraDati(T datoInIngresso, int valore) {
		//codice di elaborazione dei dati in ingresso
		T risultato = null;
		return risultato;
		}
}
