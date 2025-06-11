package it.akt;

public class Program {

	public static void main(String[] args) {
		// ARRAY
		/*	GLI ARRAY

		Un array è un insieme di elementi omogeneo (nel tipo di dati) e immutabile (nella lunghezza!)
		tuttavia è possibile modificare il contenuto dei singoli elementi

		Gli array in Java sono una struttura di base del linguaggio e non derivano da una classe esplicita, 
		ma internamente sono gestiti come oggetti.
		In Java, gli array sono oggetti speciali, anche se hanno una sintassi particolare e 
		caratteristiche simili ai tipi primitivi (come la lunghezza fissa e l’accesso rapido 
		agli elementi). 
		Sono istanze di classi speciali che estendono direttamente Object.
		
		In Java, ci sono due concetti/classi distinti relativi agli array:

	Array (java.lang.reflect.Array):  	 
		Questa classe serve per operazioni avanzate via reflection, ma non è usata nella creazione 
		o gestione normale degli array. 
		
		Reflection permette di importare stringhe e leggere il codice della classe con cui è scritta
		nomeArray.metodo() metodo non statico
		
		Si creano array utilizzando le parentesi quadre [] dopo il tipo di dato,		
		ad esempio 			int[] numeri = new int[5];

	Classe Arrays (java.util.Arrays): 	Questa è una classe di utilità all'interno del package 
		java.util che fornisce diversi metodi statici per lavorare con gli array. 
		Offre funzionalità che normalmente non si avrebbero con la sintassi base degli array.
		Arrays.metodo(nomeArray) metodo statico
	 
	 
	 	Il numero di elementi in un array, detto lunghezza dell’array, deve essere dichiarato 
	 	al momento della sua allocazione e non può essere cambiato
	 
	 
	 	La sintassi per la dichiarazione di una variabile di tipo array è la seguente
	 	Dove 'Tipo' può essere sia un tipo primitivo di Java, sia il nome di una classe. 
	 	Per allocare l’array, si utilizza la keyword 'new'
	 	'n' indica il numero di elementi che l'array conterrà
	 	
	 	Tipo[] nome = new Tipo[numero_elementi]; Dichiarazione standard di un Array
	 	
	 	Di solito numero_elementi viene dichiarata come costante alle prime righe del codice per dichiarare Array
	 	Ed avere la possibilità di dichiarare più volte determinati array in caso di bisogno
	 	Es. int final NUM_ELEM = 15; final permette di non modificare array
	 		Tipo[] nomeArray = new  Tipo[NUM_ELEM]
	 	
	 	
	 	Ogni elemento è identificato da un numero intero detto INDICE.
	 	Il primo elemento ha indice 0
	 	A causa di questo sfalsamento l'indice dell'ulitmo elemento sarà sempre uguale al 
	 	numero 'n' di elementi -1
	 	
	 	int[] numeri = {32, 44, 12, 55, 65}; n 5 elementi new int dopo uguale sarebbe metodo corretto per inizializzare array
		indici:			0	1	2	3	4			
										indice utimo elemento
		
		In Java possiamo dichiarare gli array in diversi modi:								
	
		
		Dichirazione e inizializzazione di un array
		tipo[] nome = new tipo[numero di elementi];
		Questo crea un array di 5 elementi, vuoto, ovvero dove gli elementi sono inizializzati 
		al valore di default del tipo di dato usato per dichiarare l'array
		
			* VALORI DI DEFAULT DI INIZIALIZZAZIONE
			* array di tipo boolean						-> false
			* array di tipo byte, short, int, long		-> 0
			* array di tipo float e double				-> 0.0
			* array di tipo char						-> ''
			* array di tipo object						-> null

*/		
		int[] numeri1 = new int[5]; //tutti gli elementi valgono 0 a meno di specificarli
		int numeri2[] = new int[5];
		
		for(int numero : numeri1) {
			System.out.print(numero + " "); //foreach metodo più veloce per estrarre dati di array
		}
		
		int[] numeri3 = new int[]{13, 4, 22, 45, 33};//inzializza l'array con valori scelti e non di default
		//in questo caso l'array viene creato del numero di elementi che ho passato nell'inizializzatore
		
		int[] numeri4 = {13, 4, 22, 45, 33}; //analogo alla precedente
		
		System.out.println();
		//Accesso agli elementi dell'array:  nomeArray[indice]
		System.out.println(numeri4[2]);		//in lettura | estrarrà il 22 dell'array numeri4
		int elemento = numeri4[2];			//in lettura | per dichiarare una variabile del 22 estratto 
		numeri4[2] = 78;					//in sovrascrittura | per modificarne il contenuto
		System.out.println(numeri4[2]);		//avremo a schermo il 78 avendolo modificato e riassegnato
		
		for (int numero : numeri4) {		//se indice -1 crasha il programma
			System.out.println(numero + " ");
		}
		System.out.println("\n================");
		
		//System.out.println(numeri4[5]);  //Lancia ArrayIndexOutOfBoundsException
		
		//Se ad esempio dovessi ricevere l'indice da console tramite scanner, dovrei usare un blocco 
		//try per evitare di fare crashare l'applicazione
		
		int indiceDaScanner =8;
		try {
			System.out.println(numeri4[indiceDaScanner]);
		} catch (ArrayIndexOutOfBoundsException e) {	//"Exception" è eccezione generica che si può usare se non si conosce il tipo di errore |	errore da copiare e incollare direttamente dal log dell'errore per gestire le eccezioni
			System.err.println("Devi inserire un numero tra 0 e " + (numeri4.length-1));
		}
		
//STAMPA DI TUTTI GLI ELEMENTI DELL'ARRAY:
		for(int num : numeri4) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		
		//for(int i = 0; i <= numeri4.length-1; i++ )    è uguale a quello sotto
		for(int i = 0; i < numeri4.length; i++ ) {//length è sempre più grande di 1 della grandezza dell'indice
			System.out.println(numeri4[i]);//lenght restituisce il numero di elementi dell'array e non dell'indice
		}

		System.out.println();
		
		int indice = 0;
		while(indice < numeri4.length) {
			System.out.println(numeri4[indice]);
			indice++;
		}
		
		System.out.println();
		
//Posso dichiarare una costante che rappresenti il numero di elementi dell'array
		final int NUM_ELEM = 20;	//final non crea una costante, ma finalizza il valore immagazzinato nell'area di memoria. 
									//Di fatto lo rende in sola lettura!
									//Comunque non siamo costretti a passare il valore come final all'array.
		int[] test = new int[NUM_ELEM];
		
		
//Array diversi:
		String[] nomi = {"Marco", "Lucia", "Monica", "Franco", "Antonio", "Cinzia"};
		
		double[] decimali = {12.3, 44.12, 52.3, 5.0, 3, 33.1};
		
		boolean[] boolArray = {true, false, false, true, false};		
		

		//ARRAY DI OGGETTI: Devo creare una classe dell'oggetto da rappresentare (es: Automobile)			
		
		/*			Posso agire in 2 modi:
						1•	creo i singoli oggetti e poi li inserisco nell'array
						2•	creo un array di istanze anonime della classe
		*/			

//			1•			
				Automobile a1 = new Automobile();		//creo l'oggetto col costruttore vuoto
				a1.modello = "Fiat Panda 30";			//valorizzo il campo esplicitamente
					
				Automobile a2 = new Automobile("Autobianchi A112");	//creo l'oggetto col costruttore parametrico valorizzando il campo contestualmente
				Automobile a3 = new Automobile("Lancia Delta HF int");
					
				Automobile[] automobili1 = {a1, a2, a3};	//creo l'array
				

//			2•			
				Automobile[] automobili2 = {new Automobile(),	//con Costruttore vuoto creando istanze anonime
											new Automobile()};	//crea due oggeti automobile di tipo vuoto
				
				automobili2[0].modello = "Saab 900";		//e valorizzazione esplicita dei campi di ogni elemento
				automobili2[1].modello = "Audi A1";			//valori attribuiti all'array con costruttori vuoti appena creato
				
			
				Automobile[] automobili3 = {new Automobile("Peugeot 207"),	//con costruttore Parametrico evita di dover scrivere valori per ogni elemento
											new Automobile("Lancia Y"),
											new Automobile("BMW 320i", 2000, "blu"),
											new Automobile("Fiat Punto")};
				
				System.out.println("============ for standard ============");
				for(int i = 0; i < automobili3.length; i++) {
					System.out.print(automobili3[i].modello + " - ");
				}
				
				
				
				
				System.out.println();
				
				System.out.println("============ for each ============");

				for (Automobile auto : automobili3) {
					System.out.println(auto.modello);
				}
					
				for(Automobile automobile: automobili3)	{
					System.out.println(automobile);
				}
						
		
		
		

	}

}
