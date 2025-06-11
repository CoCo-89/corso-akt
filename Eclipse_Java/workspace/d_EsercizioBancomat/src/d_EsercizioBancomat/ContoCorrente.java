package d_EsercizioBancomat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContoCorrente  {

	//Campi
	private double saldo;
	private String titolare;
	private String numero;
	private List <Operazione> listaOperazioni = new ArrayList<>();
	
	
		
	//Costruttore parametrico
	public ContoCorrente(double saldo, String titolare, String numero) {
		this.saldo = saldo;
		this.titolare = titolare;
		this.numero = numero;
	}
	
	//Metodi
	public double stampaMov() {
		return 0;
	}
	
	public void aggiungiOperazione(Operazione operazioneDaInserire) {
		listaOperazioni.add(operazioneDaInserire);
	}
	
	public List<Operazione> getListaOperazioni() {
		return listaOperazioni;
	}
	
	public double calcolaSaldo() {
		
		for (Operazione op : listaOperazioni) {
			this.saldo = this.saldo + op.getImporto();
		}
//		for(int calSal = 0; calSal <5; calSal++) {
//			
//		}
		
		
		
		return saldo;
	}
	
	
	
	
	
	
	
	
	
	
	
}
