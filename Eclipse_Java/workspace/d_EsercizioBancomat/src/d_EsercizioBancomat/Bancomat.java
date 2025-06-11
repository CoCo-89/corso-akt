package d_EsercizioBancomat;

public class Bancomat {

	public static void main(String[] args) {
		/*
		 * Conto Corrente/Bancomat
Scrivere un programma che simuli il funzionamento di uno sportello bancomat basico.
- Dovrà essere possibile scegliere dal menù 4 operazioni: saldo conto, versamento, prelievo, estratto conto
- Ogni operazione dovrà movimentare un conto corrente registrando data e ora dell'operazione, tipo dell'operazione (solo se versamento o prelievo), importo dell'operazione.
- La stampa del saldo dovrà essere in grado di restituire le ultime 5 operazioni effettuate, visualizzandole in modo comprensibile.
- La stampa dell'estratto conto deve stampare tutte le operazioni dalla data scelta alla data odierna.

Non è necessario usare la persistenza dei dati. E' sufficiente fare uso delle collezioni adatte.
		 */
		
		ContoCorrente cc = new ContoCorrente(0, "Mario Rossi", "IT00123");
		/*Operazione op1 = new Operazione("Saldo Conto", 1000);
		 *Operazione op2 = new Operazione("Versamento", 200);
		 *Operazione op3 = new Operazione("Prelievo", 100);
		 *Operazione op4 = new Operazione("Estratto Conto", 600);
		
		cc.aggiungiOperazione(op1);
		cc.aggiungiOperazione(op2);
		cc.aggiungiOperazione(op3);
		cc.aggiungiOperazione(op4);
		*/
		
		cc.aggiungiOperazione(new Operazione("Saldo Conto", 1000));
		cc.calcolaSaldo();
		
		cc.aggiungiOperazione(new Operazione("Prelievo", 100));
		
		cc.aggiungiOperazione(new Operazione("Versamento", 200));
		
		cc.aggiungiOperazione(new Operazione("Estratto conto", 600));
		
		System.out.println(cc.getListaOperazioni());
		
		
		

	}

}
