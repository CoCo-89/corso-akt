package it.akt;
 
public class Automobile {	//public permette di accedere a questa classe anche in un package diverso

	//Campo della classe o Variabile d'istanza
	public String modello;	
	public String colore;
	public int cilindrata;
	

	//Costruttore Vuoto o Costruttore di Default
	public Automobile () {};
		
	//Costruttore Parametrico | permette di passare determinate voci in questo caso per poter valorizzare velocemente la mia automobile
	public Automobile (String modello) {
		this.modello = modello;
	}

	
	public Automobile (String modello, int cilindrata, String colore) {
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.colore = colore;
	}
	
	
	@Override	//permette di andare a stampare i valori di quel determinato oggetto e dei singoli elementi
	public String toString() {
		return "Automobile [modello=" + modello + ", colore=" + colore + ", cilindrata=" + cilindrata + "]";
	}
	//NB tasto destro mouse => generate toString() => campi da stampare => Generate => crea in automatico l'Override
	//con chiocciolina sono annotazione, esplicitano a cosa serve il codice
	
}