package it.akt.esempio2;

import it.akt.esempio1.ClasseA; //devo importare la classe perché è in un altro Package

public class ClasseB extends ClasseA {
	public void stampa() {
		ClasseA a = new ClasseA();
		System.out.println("Dalla ClasseB (stessa classe ma altro package):");
		System.out.println(a.pubblico);         // ✅ OK
		// System.out.println(a.protetto);     // ❌ ERRORE: protetto non accessibile fuori package tramite istanza
		// System.out.println(a.packagePrivate); // ❌ ERRORE: visibilità package-private
		// System.out.println(a.privato);       // ❌ ERRORE: privato

		System.out.println("Da sottoclasse ClasseB con eredità:");
		System.out.println(this.pubblico);       // ✅ OK
		System.out.println(this.protetto);       // ✅ OK: accessibile in sottoclasse anche da altro package
		// System.out.println(this.packagePrivate); // ❌ ERRORE
		// System.out.println(this.privato);     // ❌ ERRORE
	}
}
