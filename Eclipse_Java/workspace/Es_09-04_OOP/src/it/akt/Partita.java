package it.akt;

public class Partita {
	
	/*Campi
	private int punteggioGiocatoreUno;
	private int punteggioGiocatoreDue;*/
	
	/*Costruttore
	public Partita(int punteggioGiocatoreUno, int punteggioGiocatoreDue) {
		if((punteggioGiocatoreUno>=1) && (punteggioGiocatoreUno<=21)) {
			this.puntegioGiocatoreUno = punteggioGiocatoreUno;
		} else {
			System.out.println("Hai sballato!");*/
	
	//Metodi
	public static int lancia4Dadi(Giocatore giocatore, Dado dado) {
		int somma = 0;
		for(int i = 0; i <4; i++) {
			somma = somma + giocatore.lancioDado(dado);
		}
		return somma;
	}
		public static void trovaVincitore(int puntiG1, int puntiG2) {
			if(puntiG1 > puntiG2 && puntiG1 <=21)
				System.out.println("Il giocatore 1 ha vinto!");
			else if (puntiG2 > puntiG1 && puntiG2 <=21)
				System.out.println("Il giocatore 2 ha vinto!");
			else if (puntiG1 == puntiG2 || (puntiG1 >21 && puntiG2 >21))
				System.out.println("Partita pari");
	}
}
