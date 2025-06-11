
/* 
   Un'espressione lambda in Java è, per definizione, un'espressione anonima: non ha un nome 
   e quindi non può essere riutilizzata direttamente.

   Ma se una lambda è una funzione anonima, significa che in Java esistono le funzioni? No.
   Java è un linguaggio completamente orientato agli oggetti e non prevede il concetto 
   di funzione libera come in altri linguaggi (es. JavaScript o Python).

   Tuttavia, James Gosling e il team di progettazione di Java hanno riconosciuto che, 
   di fatto, i metodi sono funzioni associate a oggetti (oppure alle classi, se dichiarati statici).

   In questo contesto, è possibile rappresentare una funzione anonima utilizzando una 
   interfaccia funzionale. Si tratta di un'interfaccia (o, più raramente, una classe astratta) 
   che contiene un solo metodo astratto non implementato: questa viene chiamata 
   functional interface.

   Una lambda può quindi essere utilizzata come implementazione "al volo" di quel metodo.

   Il metodo dell'interfaccia può:
      - restituire un valore oppure essere void
      - avere parametri o essere senza parametri
      - essere generico o no

   Poiché in Java tutto deve essere associato a oggetti, anche una lambda deve essere
   assegnata o passata come riferimento a un oggetto di tipo interfaccia funzionale.
*/


package it.akt;

import java.util.ArrayList;
import java.util.List;



/*  **01**
	Partiamo con un esempio da manuale, estremamente inutile, ma semplice, un Lambda-Hello-World!
	Senza parametri e con un metodo void. Come faccio? 
	Creo una functional interface con un metodo void e senza parametri
	devo aggiungere anche l'annotazione @FunctionalInterface
*/
@FunctionalInterface //evita che possa inserire altri metodi che farebbero saltare le lambda
interface Messaggio {	//prima di dichiarare metodo
	public abstract void stampa();
	//public abstract void nuovometodo();
}



/*  **02**
	ESEMPIO PARAMETRICO
	Accetta in ingresso una stringa come parametro e ritorna una stringa
*/
@FunctionalInterface
interface RitornaMessaggio {
	String invia(String messaggio);
}




/*  **03**
	ESEMPIO DI UN OPERAZIONE
	Ho due parametri double e ritorno un double
	Voglio usare questa Func Interf per fare tutte le operazioni.
*/
@FunctionalInterface
interface OperazioneMatematica {
	double esegui(double num1, double num2);
}




/*  **04**
	Questa classe ha un metodo "eseguiOperazione(double, double, OperazioneMatematica)"
	a cui passo un terzo oggetto di tipo OperazioneMatematica...
	Ovvero un'altra FunctionalInterface!
	Poi faccio in modo che questo metodo ritoni operazione.esegui(x, y);
	Questa è una chiamata di callback.
	Di fatto questo metodo NON ha un'implementazione, perché per fare qualsiasi cosa deve richiamare 
	il comportamento attraverso "operazione"
	Vediamo come eseguirlo...
*/
class Calcolatrice {
	// questo tipo di metodo prende il nome di funzione di callback
	public double eseguiOperazione(double x, double y, OperazioneMatematica operazione) {
		return operazione.esegui(x, y);
	}
}





public class Program {

	public static void main(String[] args) {

System.out.println("============================== 01 =============================");
/*  **01**		
	Creo un oggetto che abbia come tipo di dato la FunctionalInterface, poi devo passargli tanti 
	parametri quanti sono i parametri del metodo.
	Poi uso l'operatore lambda  ->  - >
	A questo punto devo mettere {} che contengono l'implementazione del metodo.
*/		Messaggio messaggioDiSaluto = () -> { //-> operatore lambda
			String testo = "Ciao, Mondo!";
			System.out.println(testo);
		};
		
//per chiamare la mia lambda faccio:
		
		messaggioDiSaluto.stampa();
/*
	Per intenderci, la parte anonima è quella a destra dell' "=", ovvero l'implementazione 
	della funzione.
	NON l'oggetto (che poi non è altro che un puntatore alla funzione). 
	se io facessi 
*/		messaggioDiSaluto = null; 
/*	non avrei modo di recuperare l'implementazione, ma l'oggetto 'esiste' sempre e mi basterebbe 
 *  reimplementarlo.
	Di fatto è solo PARZIALMENTE ANONIMA.

	Se in una espressione lambda è presente una sola istruzione allora si possono rimuovere le 
	parentesi graffe
		 */
		messaggioDiSaluto = () -> System.out.println("Hello, World!");
		messaggioDiSaluto.stampa();
/*		
	QUESTO VIENE CHIAMATO ANCHE MECCANISMO DI CHIAMATA PER DELEGA.	Perché "delego" di volta in 
	volta la chiamata a un blocco di codice diverso perché non ha un indirizzo di memoria vero e 
	proprio (in quanto aninomo).
	Quindi "revoco la delega" all'oggetto a chiamare quell'istruzione, questa viene rimossa dalla 
	memoria ed è persa.
*/	


		
		
		
System.out.println("============================== 02 =============================");
/*  **02**
*/	
		RitornaMessaggio messaggio = (String testo) -> {
			return testo.toUpperCase();
		};
//	Eseguo la Lambda
		System.out.println(messaggio.invia("Ciao, Mondo!"));

/* LA POSSO SEMPLIFICARE:
 	# Il tipo di dato del parametro viene determinato tramite inferenza del tipo pertanto si può 
   		omettere (ovvero, il parametro è di tipo String e NON posso cambiarlo)
  
 	# Se la funzione ha un solo parametro si possono rimuovere anche le parentesi tonde
  
 	# Se la funzione è composta da una sola istruzione di tipo return allora si possono rimuovere 
 		sia le parentesi graffe che il return
*/
		RitornaMessaggio messaggio1 = testo -> testo.toUpperCase();	//con due parametri mantenere parentesi tonde
		System.out.println(messaggio1.invia("Ciao, Mondo!"));



System.out.println("============================== 03 =============================");
/*  **03**
	Provo a creare una somma.
	Creo un oggetto "somma" che deve avere 2 parametri, obbligatoriamente di tipo double, 
	quindi li posso omettere, poi rimuovo graffe e return
*/		
//		OperazioneMatematica somma = (double a, double b) -> {return a + b};

		OperazioneMatematica somma = (a, b) -> a + b;
		System.out.println(somma.esegui(10, 20));
		
		OperazioneMatematica moltiplicazione = (a, b) -> a * b;
		System.out.println(moltiplicazione.esegui(10, 20));
		System.out.println(moltiplicazione.esegui(2, 12));
		System.out.println(moltiplicazione.esegui(5, 9));
/*	
	MA PERCHE' DOVREI USARE QUESTA ROBA COMPLICATA?
	Un motivo sono i metodi di CALLBACK.
	Cosa è?
	E' un metodoto che non esegue un'operazione specifica, ma delega l'esecuzione dei compiti a 
	un puntatore a funzione (oggetto) che riceve sotto forma di lambda l'operazione che deve svolgere.
	
	Immaginate una classe Calcolatrice ^^04^^
	con un metodo
*/


	
	
System.out.println("============================== 04 =============================");
/*  **04**
	Se volessi fare una somma con Calcolatrice, devo istanziarla.
	Poi prendo l'oggetto, chiamo eseguiOperazione e gli passo i valori e la relativa lambda che 
	identifica la somma.
	Dentro
		return operazione.esegui(x, y);
	verrà semplicemente copiato "a + b"

*/	
		Calcolatrice calcolatrice = new Calcolatrice();
		System.out.println(calcolatrice.eseguiOperazione(10, 20, somma));
		System.out.println(calcolatrice.eseguiOperazione(230, 10, moltiplicazione));
		
/*		
	Se ora volessi addirittura eseguire una divisione, che non ho definito... potrei farlo al volo!		
	Ovviamente in questo caso dovrei riscrivere il codice ogni volta perché non ho un nome (oggetto) 
	da richiamare.
*/		
		System.out.println(calcolatrice.eseguiOperazione(10, 20, (a, b) -> a / b));
		
		
/*		
	Vediamo un modo SERIO di usare questa roba....
	Supponiamo di avere una collezione di dati, ad esempio di nomi su cui volgio fare un'operazione 
	unica... ad esempio estrarre tutti i nomi delle persone che iniziano per una determinata 
	lettera "S":
*/		List<String> nomi = new ArrayList<>();
		
		nomi.add("Tullio");
		nomi.add("Stefania");
		nomi.add("Simone");
		nomi.add("Paolo");
		nomi.add("Sonia");
		nomi.add("Lucia");
		
// 	In modo algoritmico come dovrei fare per estrarre tutti i nomi che iniziano per "S"?
		
		List<String> nomiCheInizianoConS = new ArrayList<>();
		for (String nome : nomi)
			if (nome.startsWith("S"))
				nomiCheInizianoConS.add(nome);
		System.out.println(nomiCheInizianoConS);
		

/*	
	Prendo "nomi" e apro uno STREAM sulla collezione.
	Cheeee????
	Che vuol dire aprire uno stream????
	Vuol dire andare a "serializzare" l'oggetto, ovvero trasformarlo in un flusso di dati.
	Aperto lo stream ho a disposizione una serie di metodi che mi permettono di eseguire 
	alcune operazioni sui dati.
	Vi ricordate tutti quei metodi che richiedono oggetti tipo Predicate, Comparator, Spliterator...
	
	Che cosa è Predicate? E' una FunctionalInterface disponibile in Java.lang, che il 
	programmatore può usare per fare operazioni sulle collezioni.
	Predicate contiene un unico metodo che si chiama "test" che ritorna un valore booleano 
	a fronte di un parametro che gli passo....
	
	Lista FunctionalInterface di java.util
	https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/function/package-summary.html

	posso quindi provare a fare una cosa del genere usando i predicati, e filter ne usa:



	==>	 questo è un esempio di pipeline
		 
		 prendi la collezione, trasformala in stream e applicale un filtro, dove 'nome' 
		 rappresenta il singolo elemento (come nel for-each) 
		 poi controlla se nome.startsWith("S")
		 ma filter mi ritorna uno stream e non una lista.
		 Potrei anche usare un'interfaccia Stream<String> nomiTrovati = nomi.stream.....    
		 ma è presto.... intanto facciamo così:
		 */
		nomi.stream()   
		    .filter(nome -> nome.startsWith("S"))  	//usa Predicate, quindi gli dico di controllare 
		    .forEach(System.out::println);			//se nome finisce per "S"
	
/*	
	Lo scopo di una Pipeline è quello di raggruppare, ordinare o estrarre i dati presenti in 
		una collezione.
	Le pipelines fanno uso di espressioni lambda perché i metodi che andiamo a usare 
		supportano tutti gli stream.
*/


	
	
	}

}
