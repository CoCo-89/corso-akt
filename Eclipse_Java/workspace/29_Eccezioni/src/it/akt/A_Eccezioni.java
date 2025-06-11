package it.akt;
 
public class A_Eccezioni {

	public static void main(String[] args) {


		//Aggiungo due stampe di INIZIO e FINE (in fondo al codice)
		//mi servono solo per visualizzare quando inizia e finisce l'esecuzione del mio programma
		System.out.println("--- inizio ---");  
		
		
		//Dichiaro 2 variabili int (non double perché non mi genererebbero gli errori che cerco)
		int numero1 = 5, numero2 = 0;	
		//System.out.println(numero1 / numero2);    //Se eseguo ovviamente dà errore!
		
		
/*  	Con 'int' creo una ArithmeticException che è una RuntimeException
		quindi non sarei costretto a usare un try...catch ma di fatto l'errore c'è!
		
		L'eccezione generata ha un nome: "Division by zero". 
		Questa stringa è un messaggio di errore, che ogni classe che rappresenta un'eccezione, 
		può ritornare all'utente, tramite un metodo:
			 .getMessage();
			
		Ovviamente in questo caso il programma non termina l'esecuzione, quindi tutto quello 
		che potrei voler fare in seguito non viene eseguito, anche se sono istruzioni non 
		legate, come se volessi fare una somma o una moltiplicazione...  */
		
		System.out.println(numero1 + numero2);
		System.out.println(numero1 * numero2);
/*		... ecc...
		Queste non verrebbero mai eseguite senza una gestione dell'eccezione!
		
		
		Posso risolvere includendo ciò che genera eccezione in un blocco 
		
SINTASSI:		
		try{
			istruzione potenzialmente dannosa
		} catch (Eccezione eccezione) {			
			stampa eccezione
		} finally {									<- finally è opzionale
			viene sempre eseguito, sia che entri nel catch sia che no
		}  
	*/
		
		
		//faccio un test con i seguenti valori dichiarati sopra
		//int numero1 = 5, numero2 = 0;
		try {
			System.out.println(numero1 / numero2);
			System.out.println("questo codice non viene raggiunto in caso di eccezione!"); 
//		} catch (Exception e) {						Eccezione generica - cattura tutte le eccezioni
//		} catch (RuntimeException) {				Cattura tutte le Unchecked Exceptions
		} catch (ArithmeticException e) {			//Cattura solo le ArithmeticExceptions
			System.out.println("ECCEZIONE!");		//posso stampare un messaggio personalizzato
//			System.out.println(e.getMessage());		//posso stampare il messaggio di errore contenuto in 'e'
//			e.printStackTrace();					//oppure posso stampare lo stacktrace completo
		} finally {									//finally mi permette di eseguire sempre e comunque quello che contiene
			System.out.println("questa istruzione viene sempre e comunque eseguita...");
		}
	
		//Nb è consigliato togliere tutti gli "e.printStrackTrace() prima di consegnare il software;
		
		
/*
		L'oggetto 'e' cattura e contiene i dati dell'eccezione generata.
		ne posso stampare il contenuto con 
			.getMessage() 
			.printStackTrace()
		
		Inoltre in Java non sono obbligato a seguire la struttura try-catch-finally, ma 
		i blocchi catch e finally sono opzionali.
		Posso creare quindi le varianti più adatte alle mie esigenze.

*/

		
		try {  //nei blocchi try catch SONO OBBLIGATO A METTERE LE {}
			
		} catch (Exception e) {
			
		}
		
		
		
		try {
			
		} finally {
			
		}
		
		// try () { }         detto  'try with resources'  -> vedi file TryWithResources 
		
		System.out.println(numero1 * numero2);
		
		System.out.println("---  fine  ---");
	
		
		
		
		
		
	}

}