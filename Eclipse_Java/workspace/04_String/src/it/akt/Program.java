package it.akt;

public class Program {

	public static void main(String[] args) {
		//STRING
		
		//Come istanziare una stringa
		
		//Metodo 1 (il più sconsigliato)
		char[] chars = {'s', 'o', 'l', 'e'};	//come array di caratteri
		String sole = new String(chars);		//passo l'array di caratteri tramite costruttori
		
		//Metodo 2
		String nome = new String("Mario");		//sempre tramite costruttore passo la stringa
		
		//Metodo 3
		String frutto = "mela";					//metodo da preferire sfrutta un'area di memoria chiamata String Pool dove tutte le stringhe vengono allocate
		
/*
 * Il metodo 3, diversamente dagli altri 2, istanzia la stringa in un'aerea di memoria riservata
 * che ha tutta lo stesso indirizzo di memoria.
 */
		
//	con i primi due metodi	(metodo consigliato per fare confronti in quanto va a creare oggetti diversi)
		String frutto1 = new String("mela");
		String frutto2 = new String("mela");
		
		System.out.println(frutto1 == frutto2);	//sono soggetti diversi con diverse aree di memoria
		System.out.println(frutto1.equals(frutto2));	//true: il confronto esclude le aree di memoria

		
// col 3° metodo	(metodo più semplice se c'è la possibilità)
		String nome1 = "Mario";
		String nome2 = "Mario";
		
		System.out.println(nome1 == nome2);		//entrambi i numeri stanno nella String Pool che condivide lo stesso indirizzo di memoria con tutte le stringhe istanziate nel 3° modo

		
		//Esempio form login
		String utenteSalvato = "mRossi";
		
		String utenteDaForm = "mrossi";
		
		System.out.println("Utente autorizzato? " + (utenteSalvato.toLowerCase().equals(utenteDaForm.toLowerCase())));
		
		//toLowerCase() trasforma tutta la stringa in minuscolo	creando un nuovo oggetto che contiene la stringa
		//toUpperCase() trasforma tutta la stringa in MAIUSCOLO creando un nuovo oggetto che contiene la stringa
	
		System.out.println(utenteSalvato.toLowerCase());
		System.out.println(utenteSalvato.toUpperCase());
		System.out.println(utenteSalvato);	//questi metodi generano sempre una nuova stringa lasciando inalterata l'originale
		
		//Le stringhe in Java vengono gestite come array, ovvero ogni carattere ha un indice che parte da zero
		
		//Estraggo il primo carattere di una stringa
		System.out.println(utenteSalvato.charAt(0));
		
		//Estraggo la posizione di una lettera, se non viene trovata ritorna a -1
		System.out.println(utenteSalvato.indexOf("s"));
		System.out.println(utenteSalvato.indexOf("s", 4));
		int posizione = utenteSalvato.indexOf("s");		//salva la posizione trovata
		//help: nome del metodo, tipo di dato, classe di appartenzenza quando si usa un index of
		
		System.out.println(utenteSalvato.lastIndexOf("s"));	//parte a cercare da destra verso sinistra e trova l'indice precedente
		
		String frase = "Oggi c'è il sole ma siamo in aula a lezione";
		
		//I seguenti metodi mi restituiscono un booleano
		System.out.println(frase.startsWith("O"));	//vedo se una stringa inizia con una determinata lettera o parola
		System.out.println(frase.endsWith("pippo"));	//vedo se termina con una lettera o sottostringa
		System.out.println(frase.contains("sia"));	//vedo se è contenuta
		
		//Ritorna una nuova stringa col contenuto selezionato
		posizione = frase.indexOf("siamo");
		
		
		//Estraggo una parte di frase dalla posizione iniziale alla fine
		String nuovaFrase = frase.substring(posizione);	//substring seleziona una sottostringa
		System.out.println(nuovaFrase);
		
		posizione = frase.lastIndexOf(" ma");
		System.out.println(posizione);
		String fraseParziale = frase.substring(0, posizione);
		System.out.println(fraseParziale);
		
		//Replace sostituisce i caratteri generando una nuova stringa
		String email = "guido. cavallini @ gmail.com";
		String emailPulita = email.replaceAll("\\s+", "");	//con uso di espressione regolari o regex
		System.out.println(emailPulita);
		
		//NB. In caso di necessità consultare intelligenza artificiale per avere informazioni sui metodi di utilizzo
		//In alternativa manuali cartacei sono sempre molto consigliati per averli sempre a portata di mano
		
		System.out.println(email.replace('i', 'y'));	//sostituisce i caratteri
		
		//Fa il contrario del Parse: converte un numero in stringa
		String numero = String.valueOf(123);	//123 da numero diventa stringa
		System.out.println(numero);
		
		//Trim elimina gli spazi in testa in coda alla stringa
		String email2 = "   gcavallini@  gmail .com  ";
		System.out.println(email2.trim());

		//Split: spezza la stringa in corrispondenza di un carattere o sottostringa indicati trasformandola in un array di sottostringhe
		String frase2 = "E' quasi ora di merenda!";
		String[] arrayDiStringhe = frase2.split(" "); //se mettessi un carattere spezzerebbe la stringa in corrispondenza di quello specifico carattere ed eventuale spaziatura 
		
		for(String parola : arrayDiStringhe) {
			System.out.println(parola);
		}
		
				
		
		
		
		
		
		
		
	}

}
