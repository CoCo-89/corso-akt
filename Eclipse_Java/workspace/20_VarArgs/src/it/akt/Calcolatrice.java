package it.akt;

public class Calcolatrice {

	/*
	 * REGOLE SUI VARARGS IN JAVA:
	 *
	 * - Il varargs (es. double... args) deve essere l'ULTIMO parametro della
	 *   lista del metodo.
	 *
	 * - Un metodo può avere solo un parametro varargs.
	 *
	 * - È possibile dichiarare altri parametri prima del varargs.
	 *
	 * - Non è obbligatorio passare argomenti al varargs quando si chiama il metodo.
	 *
	 * - Internamente, il varargs è trattato come un array.
	 */

	// Somma tutti i valori passati come argomenti
	double somma(double... args) {
		double risultato = 0.0;
		for (int i = 0; i < args.length; i++)
			risultato += args[i];
		return risultato;
	}

	// Moltiplica almeno due valori, ed eventualmente altri se passati
	double moltiplica(double a, double b, double... args) {
		double risultato = a * b;
		for (int i = 0; i < args.length; i++)
			risultato *= args[i];
		return risultato;
	}
}
