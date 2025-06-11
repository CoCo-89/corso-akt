package it.akt;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class B_FileReader {

	public static void main(String[] args) {

/*
	Provo a leggere il file e funziona esattemente come il byte read
*/
		
		//creo l'oggetto file
		File file = new File("studenti.txt");
		
		try (FileReader reader = new FileReader(file)) {
			//Cambiando la classe leggo i caratteri invece che i bytes dell'esempio precedente
			
			int carattere;
			while ((carattere = reader.read()) != -1)  //ancora il read legge il carattere e lo ritorna come valore numerico 'int'
				System.out.print((char)carattere);
			
			//System.out.print('\n');
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		
		
	}

}
