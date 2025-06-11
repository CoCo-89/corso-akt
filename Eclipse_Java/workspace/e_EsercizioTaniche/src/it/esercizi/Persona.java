package it.esercizi;

public class Persona {
/* Non ho bisogno di altro se non di eseguire queste operazioni
 * riempi()
 * svuota()
 * travasa()
 * In questo caso posso scegliere se non istanziare Persona e avere tutti i metodo static
 * Oppure creare un oggetto Persona da usare per chiamare i metodi
 */
	public void riempi(Tanica tanica) {	//gli passo un oggetto generico col nome della classe
		tanica.setContenuto(tanica.getCapacita());
// imposto il contenuto con il valore letto <-	leggo la capacita
	}
	
	public void svuota(Tanica tanica) {
		tanica.setContenuto(Tanica.MIN);
	}
	
	public void travasa(Tanica tVersa, Tanica tRiceve) {
		int quantitaDaVersare = 0;
		if(tRiceve.getCapacita() == tRiceve.getContenuto()) {
			//se non ho spazio nella tRiceve lascio invariati i contenuti:
			tVersa.setContenuto(tVersa.getContenuto());
			tRiceve.setContenuto(tRiceve.getContenuto());
		} else {
			int spazioInRiceve = tRiceve.getCapacita() - tRiceve.getContenuto();
			if(spazioInRiceve <= tVersa.getContenuto()) {	//lo spazio in riceve è sufficiente per tutto il contenuto da versare
				tRiceve.setContenuto(tRiceve.getContenuto() + tVersa.getContenuto());
				tVersa.setContenuto(0);
			} else {
				//lo spazio in riceve non è sufficiente per tutto il contenuto da versare
				riempi(tRiceve);
				tVersa.setContenuto(tVersa.getContenuto() - spazioInRiceve);
			}
		}
		
	}
}
