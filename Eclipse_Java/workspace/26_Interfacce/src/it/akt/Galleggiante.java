package it.akt;

//Questa interfaccia eredita dall'interfaccia Natante
public interface Galleggiante extends Natante{

//Essendo un'interfaccia ad ereditare, non sono obbligato a fare l'override dei metodi astratti
	
	/*sottinteso public abstract*/ void galleggia();
	
}
