//RIFERIMENTO: Java - Maggi ed 2024 - pagg. 95-97

package it.akt;

public class Program {

	public static void main(String[] args) {

/*
	E' importante imparare a gestire i passaggi di variabili 
		PER VALORE
	oppure
		PER RIFERIMENTO
		
PER VALORE:		
	Quando eseguo un passaggio per valore, è come se creassi una copia locale dell'elemento
	e quindi eventuali modifiche all'elemento stesso spariranno alla fine dell'esecuzione 
	del metodo
	
PER RIFERIMENTO:	
	Quando invece eseguo un passaggio per riferimento, sto passando al metodo l'elemento stesso
	e quindi qualsiasi modifica che dovessi applicare rimarrà presente sull'elemento anche
	dopo l'esecuzione del metodo
	
	
PROVIAMO...	
	Creiamo quindi una classe che rappresenta l'Elemento con il "valore" che verrà sottoposto a modifica
	
	E creiamo una classe ModificaValore, con due metodi che usino la classe Elemento, 
	per modificare "valore" per riferimento e per valore.
	
*/		
		//Creo un oggetto 'test' su cui chiamare il metodo modificaPerValore()
		ModificaValore test = new ModificaValore();
		

		System.out.println("============== PASSAGGIO PER VALORE: ==============");		
		
		//Istanzio elemento e attribuisco un numero al campo "valore"
		Elemento e1 = new Elemento();
		e1.valore = 10;			
		System.out.println("Valore in ingresso: " + e1.valore);
		
		//passo un tipo Primitivo (e1.valore è un int) dentro al metodo, come parametro:
		test.modificaPerValore(e1.valore);
/* Ottengo:
		Valore da modificare ricevuto in ingresso: 10
		Valore modificato all'interno del metodo: 12
		Ora controllo se anche valorePrimitivo è cambiato: 
*/
		System.out.println("Valore del campo originale nell'oggetto: " + e1.valore);

/* Ottengo: 10
		Il valore della variabile 'valore' in "e1" non è stato modificato.
		Praticamente, all'interno del metodo, ho usato una copia del valore originale 
*/

		
		
		
		System.out.println("\n============== PASSAGGIO PER RIFERIMENTO: ==============");		

		Elemento e2 = new Elemento(); 	//Istanzio un oggetto di tipo Valore
		e2.valore = 30; 				//assegno un valore al campo:
		System.out.println("Valore in ingresso: " + e2.valore);

		
		test.modificaPerRiferimento(e2); //passo l'intero oggetto nel parametro del metodo
		
/* Ottengo:
		Valore da modificare ricevuto in ingresso: 30
		Valore modificato all'interno del metodo: 32
		Ora controllo se anche 'valore' dentro 'e2' è cambiato: 
*/
		System.out.println("Valore del campo originale nell'oggetto: " + e2.valore);

/* Ottengo: 32!!!
		Il valore della variabile 'valore' non è stato modifica.
		Praticamente, all'interno del metodo, ho usato una copia del valore originale */
	
		
/*		
	RIASSUMENDO E SEMPLIFICANDO:
	Passaggio per valore: 
			è come se scriviamo un numero su un foglio. Poi ne facciamo la fotocopia. 
			In seguito modifichiamo uno dei due fogli. Ovviamente l’altro non cambia.

	Passaggio per riferimento: 
			è come se abbiamo le chiavi di una stanza. Ne facciamo la copia e la diamo 
			ad un amico. 
			Poi entriamo nella stanza e spostiamo i mobili. 
			Quando il nostro amico usa le chiavi per accedere alla stanza, i mobili sono spostati 
			anche per lui, anche se la chiave è praticamente la stessa!	
	
	Uso sempre questi due sistemi per passare le informazioni tra due classi.
		• o istanzio un oggetto della classe A nella classe B come fosse un campo
		• oppure passo un oggetto o un valore della classe A come parametro in un metodo 
				della classe B, a seconda che voglia o meno modificare il valore originale
				dei campi presenti nella classe A
*/	
		
		

		
		
		
	}
}