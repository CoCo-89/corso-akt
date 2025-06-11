package it.akt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class A_FileWriter {

	public static void main(String[] args) {

/*
	Il Character Stream si adatta solo a file di testo ma è più veloce del ByteStream
	Usa le classi 
		FileReader
		FileWriter
		
	Provo a scrivere un nuovo file.
*/
		

//Mi creo il solito elenco di nomi sotto forma di array 	
		String[] studenti = {
			"Gabriele Rossi",
			"Domenico Bianchi",
			"Franco Neri"
		};
		
//Come nei precedenti esempi creo un oggetto di tipo file.
		File file = new File("studenti.txt");
		//File file = new File("..\\..\\studenti.txt");
		
		try (FileWriter writer = new FileWriter(file, false)) { //false: sovrascrive - true: append
			
			for (String studente : studenti) {
				writer.write(studente);   	//Qui non devo convertire in array di byte, ma in array di caratteri. 
											//Ma visto che un array di char è una stringa, posso usare un overloading di .write() che accetta stringhe in ingresso
				writer.write('\n');
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Faccio il solito check e do un esito all'utente
		if (file.exists() && file.length() > 0)
			System.out.println("file creato in modo corretto!");
	
		
	}
}
