package it.akt;


public class Automobile extends Veicolo {

/*	L'unica cosa che deve fare la classe che eredita dalla classe astratta è
	l'override dei metodi astratti.
	Potrebbe anche non essere necessario fornire un'implementazione a tutti, ma è consigliato farlo
	anche per coerenza col meccanismo di ereditarietà. 
	Se un metodo non serve in una sottoclasse, allora significa che non è comune a tutte le sottclassi
	e quindi c'è un errore di progettazione.
*/	
	
	private String targa;
	private int cilindrata;
	
	//COSTRUTTORI
	public Automobile () {}
	
	public Automobile(String targa, int cilindrata) {
		this.cilindrata = cilindrata;
		setTarga(targa);			//anche con i campi locali obbligo il costruttore a passare 
									//dai setter per eseguire i controlli sui dati in ingresso
	}
	
	public Automobile(String produttore, int velocita, String targa, int cilindrata) {
		setProduttore(produttore);	//campi privati nella Superclasse dove non ho specificato un costruttore parametrico
		setVelocita(velocita);
		setTarga (targa);		
		this.cilindrata = cilindrata;
	}
	

	//OVERRIDE DEI METODI ASTRATTI
	@Override
	public void accelera() {
		setVelocita(getVelocita()+5);
	}

	@Override
	public void decelera() {
		setVelocita(getVelocita()-1);
	}

	//GETTERS E SETTERS
	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		if (targa.matches( "^[A-Z]{2}[0-9]{3}[A-Z]{2}$" )) {
			this.targa = targa;
		} else {
			throw new IllegalArgumentException("La targa inserita non è corretta: " + targa);
		}
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	
}	
	