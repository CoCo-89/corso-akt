package it.akt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class B_BufferedReader {

	public static void main(String[] args) {


		File file = new File("studenti.txt");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			
			String linea;
			while ((linea = reader.readLine()) != null)
				System.out.println(linea);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		//metodo più consigliato per i file di testo anche du grandi dimensioni
	}

}
