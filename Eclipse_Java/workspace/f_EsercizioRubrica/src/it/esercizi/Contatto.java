package it.esercizi;

public class Contatto {

	//Campi
	private String nome;
	private String numeroTelefono;
	
	//Costruttore parametrico
	public Contatto(String nome, String numeroTelefono) {
		this.nome = nome;
		this.numeroTelefono = numeroTelefono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	
}
