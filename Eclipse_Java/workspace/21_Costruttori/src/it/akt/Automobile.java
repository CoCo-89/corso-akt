package it.akt;
 
public class Automobile {

	public String modello;
	public int cilindrata;
	public String targa;
	public double peso;
	
	public Automobile (String modello) {
		if( modello.isBlank() || modello.isEmpty() || modello==null)
			System.out.println("Devi inserire un modello valido!");
		else
			this.modello = modello;
	}
	
	public Automobile (String modello, int cilindrata) {
		this(modello);
		if (cilindrata <=500 || cilindrata > 12000) 
			System.out.println("La cilindrata deve essere compresa tra 501 e 12000");
		else 
			this.cilindrata = cilindrata;
	}
	
	public Automobile (String modello, int cilindrata, String targa) {
		this(modello, cilindrata);
		if (targa.matches("^[A-Z]{2}[0-9]{3}[A-Z]{2}$"))
			this.targa = targa;
		else 
			System.out.println("Targa non valida!");
	}
	
	
}