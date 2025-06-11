package it.akt;

public class Program {

	public static void main(String[] args) {
		//STRINGBUILDER: è una classe che permette di rendere le stringhe (normalmente immutabili)
		//modificabili
		
		String parola = "Java";
		
		//creo un oggetto modificabile con StringBuilder
		StringBuilder parolaModificabile = new StringBuilder(parola);
		
		//aggiungo una stringa alla fine 
		parolaModificabile.append("aa! Corso Programmatore.");
		System.out.println(parolaModificabile);
		
		//aggiungo una sottostringa in una posizione definita
		parolaModificabile.insert(8, "FIRST: ");
		System.out.println(parolaModificabile);
		
		//sostituzione di una parte di stringa
		parolaModificabile.replace(0, 6, "Java");	//( indice iniziale, indice finale escluso, nuova parola)
		System.out.println(parolaModificabile);
		
		//Per riportare in String la frase modificata: riassegno la stringa editata alla stringa originale.
		
		parola = parolaModificabile.toString();
		
		
		
		
		
		
		
		

	}

}
