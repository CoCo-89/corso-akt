package it.akt;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ProgramURL_Scanner {

	public static void main(String[] args) {
		// Come anticipato con scanner posso acquisire da diverse sorgenti come ad esempio
		//l'URL di una pagina Web - Da Java 9 si usa URI invece di URL

        try {
			Scanner consoleScan = new Scanner(System.in);
			System.out.println("Inserisci un URL da catturare: ");
			String urlString = consoleScan.nextLine();
        	
        	URI uri = new URI(urlString); // oppure passo l'url direttamente: "https://www.google.com/"
        	//URI rappresenta indirizzo generico

        	URL url = uri.toURL(); //connessione all'url inserito
            URLConnection connection = url.openConnection(); //apre connessione
            Scanner scanner = new Scanner(connection.getInputStream()); //creazione nuovo scanner che cattura canale input

            while (scanner.hasNextLine()) { //cattura ricorrente "finchè trovi una riga"
                String line = scanner.nextLine(); //prendi la riga | StringBuilder appende ogni line per memorizzarla
                System.out.println(line); //stampi la riga
            }

            
            scanner.close(); //chiude entrambi i flussi
        } catch (IOException | URISyntaxException e) { //eccezioni
            System.err.println("Errore durante la creazione dell'URL o la lettura della pagina web: " + e.getMessage());
        }

        
        
        
	}
}