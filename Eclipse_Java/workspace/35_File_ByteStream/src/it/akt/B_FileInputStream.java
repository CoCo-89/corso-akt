package it.akt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class B_FileInputStream {

	public static void main(String[] args) {

		//BYTE STREAM: permette di leggere e scrivere qualsiasi tipo di file
		//LETTURA: FileInputStream
		
		//Mi creo di nuovo l'oggetto File da leggere		
		File file = new File("band.txt");// o file o percorso
				
		//Faccio un check se il file esiste o meno, nel percorso specificato per evitare errori
		if (file.exists()) {
			try (FileInputStream inputStream = new FileInputStream(file)) {  
				//Anche qui ho una FileNotFoundException che è sottotitpo di IOException 
				//quindi uso un try catch come per la scrittura.
				
				//FileInputStream ha un metodo read() che legge un byte per volta 
				//read() restituisce il byte sotto forma di numero 'int' 
				
				int carattere;
				while ((carattere = inputStream.read()) != -1) 	//quando ritorna -1 significa che ho raggiunto la fine del file
					System.out.print((char)carattere); 			//ora devo castare a (char) i numeri interi letti
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		} else
			System.err.println("il file " + file.getName() + " non esiste nel percorso specificato");
				
		
		
		
		
		
	}

}
