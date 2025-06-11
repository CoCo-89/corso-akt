package it.akt.uno;

public class Prima {

	//Campi della classe con diversi modificatori di visibilità
	public 		String pubblico = "public";
				String _default = "default o package private";
	protected 	String protetto = "protected";
	private 	String privato = "private";
	
	
	//internamente anche alla classe private sono visibili e utilizzabili
	//GETTER
	public String getPrivato() {
		return privato;
	}
	
	//SETTER
	public void setPrivato (String privato) {
		this.privato = privato;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
