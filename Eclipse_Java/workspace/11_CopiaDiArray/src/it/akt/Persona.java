package it.akt;

public class Persona {

	//Campo
	String nome;
	
	//Costruttore Parametrico
	public Persona(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + "]";
	}


	
	
}
