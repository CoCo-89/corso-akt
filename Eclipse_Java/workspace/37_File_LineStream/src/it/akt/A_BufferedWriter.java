package it.akt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class A_BufferedWriter {

	public static void main(String[] args) {

//In questo modo possiamo solo leggere o scrivere file di testo, una riga per volta.
//E' il metodo più veloce.
		
		
		
		String[] studenti = {
				"Gabriele Rossi",
				"Domenico Bianchi",
				"Franco Neri"
			};
			
			File file = new File("studenti.txt");
		
			//La sintassi storica originale è questa: 
			//	try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {...
			//Ma corrisponde a chiamare la classe Printwriter.
			//Quindi tanto vale usare direttamente PrintWriter.  Usa lo stesso metodo println() dell'oggetto out della console.
			//Questa sintassi però non supporta il parametro "true" per attivare l'append
			try (PrintWriter writer = new PrintWriter(file)) {
				
				for (String studente : studenti)
					writer.println(studente);
				
			} catch (IOException e) {
				e.printStackTrace();
			}

	
			String[] studenti1 = {
					"Lorenzo Verdi",
					"Emanuele Biondi"
				};		
			

			//Devo invece usare la sintassi estesa se voglio eseguire l'APPEND
			try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
				
				for (String studente : studenti1)
					writer.append(studente + "\n");  //metodo da usare per eseguire l'append 
					//writer.println(studente);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			

			
			
			
		
		
		
	}

}
