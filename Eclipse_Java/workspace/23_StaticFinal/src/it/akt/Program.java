// RIFERIMENTO: Java - Maggi ed 2024 - pagg. 104-107
package it.akt;

public class Program {

	public static void main(String[] args) {
		
/*
  REGOLE:
  Modificatori di comportamento:
  - static (condiviso tra tutte le istanze della classe)
  - finale (rende non mutabile
  - abstract
  - strictfp (deprecato)
===================
🔹 STATIC	(applicabile a campi e metodi)
===================
		- Un membro statico è condiviso da tutte le istanze della classe.
		- È accessibile anche senza creare un oggetto.
		- Quando si accede a un campo o metodo static, la classe viene caricata in memoria.

===================
🔹 FINAL		(applicabile a campi, metodi, parametri, variabili locali e classi)
===================
		- Può essere applicato a variabili, metodi, classi e parametri.
		  • final su variabile → diventa costante (non modificabile).
		  • final + static su campo della classe → costante di classe.
		  • final su metodo → non può essere sovrascritto (no override).
		  • final su classe → non può essere estesa (no inheritance).
		  • final su parametro → non può essere modificato all’interno del metodo.
		- final è l’opposto di abstract e **non possono essere usati insieme**.
*/

		// Una costante locale
		final int numero = 1;
		// numero++;    // ERRORE: variabile final non modificabile!
		
		ClasseGenerica cg1 = new ClasseGenerica();
		cg1.campo = 555;
		
		// cg1.CAMPO_FINAL = 22;  // ERRORE: campo final non assegnabile

		System.out.println(cg1.CAMPO_FINAL);  // 10

		// Anche se è static, posso accedere tramite l'oggetto (sconsigliato!)
		cg1.campoStatic = 123;
		
		ClasseGenerica cg2 = new ClasseGenerica();
		System.out.println(cg2.campoStatic); // 123 → condiviso tra tutte le istanze
		
		// Meglio: accedere direttamente tramite la classe
		ClasseGenerica.campoStatic = 789;

		int valoreDaCostante = ClasseGenerica.ALTRO_CAMPO_FINAL;

		System.out.println(ClasseGenerica.CAMPO_STATIC_FINAL); // 50
		ClasseGenerica.metodoStatic(); // chiamata a metodo static
	}
}
