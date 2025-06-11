package it.Esercizi;

public class Program {

	public static void main(String[] args) {
		//Istanza di libro
		
		Libro naruto = new Libro("Naruto", "Kishimoto", 400, false);
		
		naruto.apri();
		naruto.leggiPagina();
		naruto.descriviLibro();
		
		Cerchio cerchio = new Cerchio();
		
		cerchio.calcolareArea();
		cerchio.calcolaCirconferenza();
		
		System.out.println("=====================================================");
		
		Contatore contatore = new Contatore();
		
		contatore.incrementa();
		contatore.incrementa();
		contatore.incrementa();
		
		contatore.decrementa();
		contatore.decrementa();
		
		System.out.println("Valore prima del reset: " + contatore.getValore());
		
		contatore.resetta();
		
		System.out.println("Valore dopo il reset: " + contatore.getValore());
		
		System.out.println("====================================================");
		
		Studente s1 = new Studente("Marco", "Uno", 0.0);
		s1.aggiungiVoto(7);
		
		
		
		
		
	}


}
