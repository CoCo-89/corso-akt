package it.akt;

public class Program {

	public static void main(String[] args) {
		// CLASSI WRAPPER
		
		//Salvo alcuni casi che vedremo non è corretto usarle per inizializzare delle variabili al posto dei tipi primitivi
		
		Integer numero = new Integer(10);	//da Java 9 non dovrei più fare questo!
		Integer numero1 = 10;				//se proprio devo usare la classe Wrapper devo fare così
		Integer numero2 = 5;
		
		System.out.println(numero1 - numero2);
/*
	I nomi delle classi Wrapper corrispondono ai dati primitivi salvo 2 (char e int)
		Classe Wrapper		Tipo primitivo
		Boolean				boolean
	*	Character			char
		Byte				byte
		Short				short
	*	Integer				int
		Long				long
		Float				float
		Double				double		
 */
		String valore = "10";
		String altra = "20";
		System.out.println(valore-altra);
		
//PARSE converte una stringa di cifre in un numero vero (Ho dei Parse per ogni classe Wrapper)
		int num = Integer.parseInt(valore);
		int num1 = Integer.parseInt(altra);
		System.out.println(num-num1);
		
		String veroFalso = "true";
		boolean vf = Boolean.parseBoolean(veroFalso);
		System.out.println(vf);
		
		String test = "5,6";
		try {
			int conversione = Integer.parseInt(test);
			System.out.println("prosecuzione dell'esecuzione se tutto è andato bene");
		} catch (Exception e) {
			System.err.println("Formato non corretto!");
			System.out.println("Eccezione: " + e.getMessage());
			e.printStackTrace();		//questo stampa tutto lo stracktrace
			
		}
		
		System.out.println("FINE ESECUZIONE");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}//fine main

}//fine classe
