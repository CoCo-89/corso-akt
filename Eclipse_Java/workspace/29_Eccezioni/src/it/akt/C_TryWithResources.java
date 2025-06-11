package it.akt;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class C_TryWithResources {

	public static void main(String[] args) {

/*		Questo tipo di struttura prende il nome di try with resources (JDK >= 8)
		
		Con lo scanner devo ricordarmi di chiamare il metodo close(), ma se questo dovesse crashare 
		o dovessi dimenticare di chiamarlo, non potrei riaprire la console.
		
		il try with resources chiama automaticamente il close() 
		lo posso fare solo se la classe che chiamo (Scanner) implementi le interfacce Cosable 
		o AutoClosable sono quasi tutte le classi che aprono uno STREAM ovvero un  flusso di 
		byte verso una risorsa.
*/		
		try (Scanner scanner = new Scanner(System.in)) {
		
			System.out.print("Quanti anni hai? ");
			int eta = scanner.nextInt();	//se inserisco un numero in lettere va in errore InputMismatchException
			
			System.out.printf("Hai %d anni! \n", eta);
			
		
/* ************  ALTRO ESEMPIO - aggiunta di catch opzionale  ************* */
			scanner.nextLine(); //svuoto il buffer
			
			
			System.out.print("Quando sei nato? ");
			String dataNascita = scanner.nextLine();
			
			LocalDate  data = LocalDate.parse(dataNascita); // yyyy-mm-dd devo passare la stringa così
			System.out.println("La tua data di nascita è... " + data);
		
		} catch (InputMismatchException | DateTimeParseException e) { 
			System.err.println("Si è verificato un errore... " + e.getMessage());
		}
		
		System.out.println("---Fine---");

		
		
		
		
	}

}