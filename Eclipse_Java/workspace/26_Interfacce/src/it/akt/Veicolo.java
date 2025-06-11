package it.akt;

public abstract class Veicolo {	//Veicolo è una classe astratta
								//che generalizza una categoria

	private String nome;
	private int numeroPosti;
	
	public abstract void accelera();	//metodi astratti consoni alla classe astratta
	public abstract void decelera();	//verranno richiamati tramite Override
	
	public Veicolo() {}
	
	public Veicolo(String nome, int numeroPosti) {
		this.nome = nome;
		this.numeroPosti = numeroPosti;
	}
	
	//più eventuali getters, setters, override di toString ed altri metodi...
	
}
