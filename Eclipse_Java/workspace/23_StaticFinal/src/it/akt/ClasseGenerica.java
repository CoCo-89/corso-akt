package it.akt;

public class ClasseGenerica {

/*	• CAMPI D'ISTANZA */
	public int campo;

	// Campo static condiviso da tutte le istanze
	public static int campoStatic;

	// Campo costante: deve essere inizializzato subito o nel costruttore
	public final int CAMPO_FINAL = 10;

	// Campo statico e final: costante di classe
	public static final int CAMPO_STATIC_FINAL = 50;

	// Costante di classe inizializzata in blocco statico
	public static final int ALTRO_CAMPO_FINAL;

	
	
/*	• BLOCCO o COSTRUTTORE STATICO
	 Usato per inizializzare campi static final complessi
*/	static {
		ALTRO_CAMPO_FINAL = 1000;
		System.out.println("Blocco static: eseguito una sola volta al caricamento della classe");
	}

	
	
/*	 • METODO STATIC
	 Può accedere solo a membri static
*/	public static void metodoStatic() {
		campoStatic = 10;  						 // OK
		System.out.println(CAMPO_STATIC_FINAL);  // OK
		System.out.println(ALTRO_CAMPO_FINAL);   // OK

/*		 campo = 10; 						// ❌ ERRORE: campo non static
		 System.out.println(CAMPO_FINAL); 	// ❌ ERRORE: campo non static   */
	}

	
	
	
/*	 • METODO NON STATIC   */
		public void metodoNonStatic() {
		campo = 10;  // OK
		System.out.println(CAMPO_FINAL); // OK

		campoStatic = 10;  // OK: static accessibile anche da istanza
		System.out.println(CAMPO_STATIC_FINAL);
		System.out.println(ALTRO_CAMPO_FINAL);
	}

/*	 • PARAMETRI FINAL	*/
	public int altroMetodo(final int numero) {
/*		numero++; // ❌ ERRORE: parametro dichiarato final, non modificabile     */
		return numero;
	}
}
