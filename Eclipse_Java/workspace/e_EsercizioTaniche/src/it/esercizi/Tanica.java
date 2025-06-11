package it.esercizi;

public class Tanica {

	
	private int capacita;
	private int contenuto;
	public final static int MIN = 0;
	
	public Tanica(int capacita) {
		this.capacita = capacita;	
	}
	
	public int getCapacita() {
		return capacita;
	}
	
	public int getContenuto() {
		return contenuto;
	}
	public void setContenuto(int contenuto) /*throws IllegalArgumentException*/{
		//if (ltVersati + this.contenuto > capacita) {
			if (contenuto > capacita) {
				//throw new IllegalArgumentException("Contenuto non corretto");
				System.out.println("Contenuto non corretto");
			} else if (contenuto < MIN) {
				//throw new IllegalArgumentException ("Contenuto non corretto");
				System.out.println("Contenuto non corretto");
			} else {
				this.contenuto = contenuto;
			}
	}
}
