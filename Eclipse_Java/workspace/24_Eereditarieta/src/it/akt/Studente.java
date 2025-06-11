package it.akt;

//Uno Studente è una persona pertanto, in questo caso, ha senso ereditare
public class Studente extends Persona {  //per ereditare usiamo 'extends'

	//public String nome;     -> da Persona
	//public String cognome;  -> da Persona 
	public int voto;
	
//COSTRUTTORE DI DEFAULT	
	public Studente() {
		super(); // Questa istruzione invoca il costruttore della classe base Persona
		System.out.println("Costruttore di Default di Studente");
	}
	
//COSTRUTTORE PARAMETRICO
	public Studente(String nome, String cognome, int altezza, int voto) {
		super(nome, cognome, altezza); 
		// 	Prima del super() non ci può essere alcuna istruzione
		//	tramite Super passiamo i parametri al costruttore della 
		//	Superclasse (quello con i campi corrispondenti)
		
		this.voto = voto;
		System.out.println("Costruttore Parametrico di Studente");

	}
}