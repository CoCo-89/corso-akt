package it.esercizi;

public class Program {

	public static void main(String[] args) {
		
		Taniche t3 = new Taniche(3);
		Taniche t5 = new Taniche(5);

		
		t3.riempi();
		t3.versa(t5);
		t3.riempi();
		t3.versa(t5);
		t5.svuota();
		t3.versa(t5);
		t3.riempi();
		t3.versa(t5);
		
		
	}

}
