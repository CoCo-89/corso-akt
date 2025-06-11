package it.akt;

public class Program {

	public static void main(String[] args) {

		//Istanza di Automobile con costruttore di default
		Automobile a1 = new Automobile();
		
		//Istanza di Automobile con costruttore parametrico
		Automobile a2 =  new Automobile("BMW", "320i", 1800, Colore.BLUE_NAVY);
		Automobile a3 =  new Automobile("BMW", "320i");
		
		a3.accelera(); //void non ritorna valori e non posso usare un risultato del metodo
		
		int nuovaVelocita = a3.acceleraEritorna();  //metodo di tipo int, ritorna un int che posso gestire
		System.out.println(a3.acceleraEritorna());
		
		System.out.println(Automobile.VELOCITA_MAX); //le costanti di classe vanno chiamate sulla classe
		
		
	}

}
