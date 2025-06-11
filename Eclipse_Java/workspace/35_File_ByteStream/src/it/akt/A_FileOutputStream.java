//Introduzione a I/O e Stream
//RIFERIMENTO: Java - Maggi ed 2024 - pagg. 367-371 

//Stream Binari
//RIFERIMENTO: Java - Maggi ed 2024 - pagg. 374 

package it.akt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class A_FileOutputStream {

	public static void main(String[] args) {
	
	//BYTE STREAM: permette di leggere e scrivere qualsiasi tipo di file
	//SCRITTURA: FileOutputStream
		
		String[] bandList = {
				"Metallica",
				"Rammstein",
				"Slayer",
				"Iron Maiden",
				"Avenged Sevenfold",
				"Arch Enemy",
				"Foo Fighters"
			};
			
			
//Quando costruisco un oggetto di tipo File, gli devo passare percorso e nome del file. 
//Posso usare sia un percorso assoluto, che un percorso relativo a partire dal progetto		
//Se non viene fatto automaticamente devo fare l'escape delle \	
//https://it.wikipedia.org/wiki/Percorso  gestione percorsi files	
			File file = new File("band.txt");
			//File file = new File("..\\..\\band.txt"); sempre con doppio slash altrimenti legge come se andassimo a capo
								//in questo modo torneremo indietro di due cartelle						
								//con windows i percorsi si usa il back slash, gli altri la slash normale
			
			
/*			
  La chiamata a "new FileOutputStream(file)"  Viene segnato rosso per via del'eccezione che lancia. 
  Devo quindi usare un blocco TRY CATCH.
  Inoltre viene aperto un processo di stream verso il file. Se il file esiste, quello esistente 
  viene distrutto e rimpiazzato.
  Alla fine devo chiudere lo stream usando un metodo close() che lancia un'altra eccezione.
  Per risolvere uso un TRY with RESOURCES per chiudere automaticamente tutto	
  visto che FileOutputStream Estende OutputStream che a sua volta implementa Closeable	
*/		
			try (FileOutputStream outputStream = new FileOutputStream(file)) {		//In questo modo sovrascrivo il file col nuovo contenuto
			//   FileOutputStream outputStream = new FileOutputStream(file, true)  	//Fa APPEND! ovvero aggiunge il testo in coda al testo presente nel file
																					//Senza true sovrascrove il file che già c'era
				for (String band : bandList) {  				//estraggo i dati con un for each
					outputStream.write(band.getBytes());    //chiamo .write() che permette di scrivere un array di bytes quindi gli passo nome.getBytes()
					outputStream.write('\n');				//mando a capo bisogna eesplicitarlo
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			//Stampo un messaggio di servizio all'utente per dirgli se l'operazione di scrittura è andata a buon fine
			if (file.exists()) {
				System.out.println("il file " + file.getName() + " è stato creato");
				System.out.println("dimensione: " + file.length() + " bytes");
				System.out.println("file creato nel percorso: " + file.getAbsolutePath());
			}

		
		
		
		
	}

}
