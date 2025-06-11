package it.akt;

import java.io.Serializable;


public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 715423811547651180L;
	//il serialVersionUID serve per assicurarsi che i dati vengano deserializzati con una classe 
	//compatibile con quella di seiralizzazione, in modo da evitare errori di conversione
	//1L è quello di default, oppure si può generare un Long casuale per attivare la sicurezza.
	
	private String firstName;
	private String lastName;
	private int age;
	
	//potrei marcare TRANSIENT il numero di carta di credito se non voglio serializzarlo per sicurezza
	private transient String numeroCartaDiCredito;
	

	public Persona() {

	}

	public Persona(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNumeroCartaDiCredito() {
		return numeroCartaDiCredito;
	}

	public void setNumeroCartaDiCredito(String numeroCartaDiCredito) {
		this.numeroCartaDiCredito = numeroCartaDiCredito;
	}


	@Override
	public String toString() {
		return "Persona [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

}

