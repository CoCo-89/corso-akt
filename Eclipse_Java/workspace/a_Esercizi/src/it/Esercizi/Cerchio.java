package it.Esercizi;

public class Cerchio {
	
	/*Esercizio 2: Cerchio
	Campo: raggio (double).
	Metodi: calcolaArea() (restituisce l'area del cerchio), calcolaCirconferenza() (restituisce la circonferenza).
	Crea un oggetto Cerchio e stampa la sua area e circonferenza.*/
	
	//Campi
	public double raggio = 5.0;

	//Costruttore di default
	public Cerchio( ) {}
	
	//Metodi
	public void calcolareArea() {
		double area = Math.PI * Math.pow(raggio, 2);
		System.out.println(area);
		}
	public void calcolaCirconferenza() {
		double circon = 2 * Math.PI * raggio;
		System.out.println(circon);
	}
	
	
	

	
	
	
	

}
