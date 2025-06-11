//RIFERIMENTO: Java - Maggi ed 2024 - pagg. 100-101
package it.akt;

public class Persona {

	public String nome;
	public int eta;
	
//Costruttore di default
	public Persona() {
		System.out.println("Costruttore di default");
	}
	
	
//Costruttore Parametrico
	//Definisco un costruttore parametrico per poter passare direttamente il nome all'oggetto	
	public Persona(String nome) {
		this.nome = nome;	//il this specifica il nome dato in entrata nella classe
		System.out.println("Costruttore solo con 'String nome'");
	}	
	

	
	//Definisco un costruttore parametrico per poter passare nome ed eta all'oggetto	
	public Persona(String nome, int eta) {
/* 		La chiamata ad un costruttore precedente deve essere la prima cosa
		che dichiariamo in un altro costruttore e si fa tramite "this(...)"
		 
		Prima del "this(...)" non ci deve essere nulla
*/
		this(nome); //chiamo il costruttore Persona(String nome)
		this.eta = eta;
		System.out.println("Costruttore con 'nome ed età' che chiama quello con 'String nome'");
	}
	
	
//COPY CONSTRUCTOR: NON esiste di default come in altri linguaggi!
//					riceve un oggetto e ne crea uno nuovo con gli stessi valori 
//					sono due oggetti distinti, quindi crea una copia forte	
		public Persona (Persona persona) {
			this.nome = persona.nome;
			this.eta = persona.eta;
			System.out.println("Sono nel Copy Constructor");
		}
	
	
	
}