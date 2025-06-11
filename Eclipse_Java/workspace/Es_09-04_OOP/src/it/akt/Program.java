package it.akt;

public class Program {

	public static void main(String[] args) {
		
		//Con la programmazione ad oggetti posso creare un pezzo di codice da poyer riutilizzare in progetti futuri
		//Rappresentare uun gioco dadi tra 2 giocatori.
		//Lo scopo è di arrivare il più vicino possibile a 21 senza sballare.
		//Uso 4 dadi a 6 facce
		
		/*DEFINIRE ENTITA'
		 * CLASSE GIOCATORE
		 * CAMPI: nome (String)
		 * METODI (statici): lancioDado (int)
		 * 
		 * CLASSE DADO
		 * CAMPI: numeroFacce (int)
		 * 
		 * CLASSE GIOCO
		 * CAMPI: punteggioGiocatoreUno (int) | punteggioGiocatoreDue (int)
		 * METODI(statici): sommaQuattroLanciDado (int) | confrontoPunteggio (P1+P2)
		 */
			
		
			Dado dado1 = new Dado(6);
			
			
			
			Giocatore g1 = new Giocatore("Franco");
			Giocatore g2 = new Giocatore("Giovanni");
			/*Test lancio dado ok
			int estratto1 = g1.lancioDado(dado1.getNumeroFacce());
			System.out.println(estratto1);*/
			
			//System.out.println(Partita.lancia4Dadi(g1, dado1));
			//System.out.println(Partita.lancia4Dadi(g2, dado1));
			
			int punteggio1 = Partita.lancia4Dadi(g1, dado1);
			int punteggio2 = Partita.lancia4Dadi(g2, dado1);
			
			g1.setPunteggioPartita(punteggio1);
			g2.setPunteggioPartita(punteggio2);
			//uguale a sopra ma salto il passaggio di creazione della variabile
			
			System.out.println("PunteggioG1: " + g1.getPunteggioPartita());
			System.out.println("PunteggioG2: " + g2.getPunteggioPartita());
			
			Partita.trovaVincitore(punteggio1, punteggio2);
	}

}
