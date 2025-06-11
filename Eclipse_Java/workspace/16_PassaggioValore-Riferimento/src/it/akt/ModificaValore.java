
package it.akt;

public class ModificaValore {

//	PASSAGGIO PER VALORE
// 	metodo che modifica una variabile di tipo Primitivo
	public void modificaPerValore(int valoreDaModificare) {
		
		System.out.println("NEL METODO: Valore ricevuto in ingresso: " + valoreDaModificare);
		valoreDaModificare += 2;
		System.out.println("NEL METODO: Valore modificato: " + valoreDaModificare);
	}

	
	
	
	
	
//	PASSAGGIO PER RIFERIMENTO
// 	metodo che modifica un OGGETTO di tipo Valore
	public void modificaPerRiferimento(Elemento valoreDaModificare) {
		System.out.println("NEL METODO: Valore ricevuto in ingresso: " + valoreDaModificare.valore);
		valoreDaModificare.valore += 2;
		System.out.println("NEL METODO: Valore modificato: " + valoreDaModificare.valore);
	}

}
