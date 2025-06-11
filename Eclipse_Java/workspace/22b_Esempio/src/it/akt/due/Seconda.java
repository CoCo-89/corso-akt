package it.akt.due;
//public aggiunto in un secondo momento per un esempio con getter e setter costruttore
public class Seconda {
	
	public String pubblicoSeconda = "PubblicoSeconda";
	private	int eta;
	
	//Costruttore
	public Seconda(String pubblicoSeconda, int eta) {
		this.pubblicoSeconda = pubblicoSeconda;
		this.eta = eta;
		//setEta(eta);
	}

	//getter
	public int getEta() {
		return eta;
	}

	//setter
	public void setEta(int eta) {
		if (eta <= 0 || eta >120)
			System.err.println("Età inserita errata!");
		else
			this.eta = eta;
	}
	
	//getter e sertter servono per avere un tipo di lettura o scrittura
	
	
	
	
	

}
