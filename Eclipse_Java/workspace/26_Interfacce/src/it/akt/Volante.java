package it.akt;

public interface Volante {

	/*sottinteso public abstract*/ void decolla();
	public abstract void atterra();
	
	//Da java 8 posso mettere metodi di default
	default void plana(boolean carburanteFinito) {	//se omettessi default diventerebbe metodo public abstract
		if(carburanteFinito)
			System.out.println("L'aereo sta planando per tentare un atterraggio di emergenza!");
	}
	
}
