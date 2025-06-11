package it.akt;

public class Program {

	public static void main(String[] args) {
		//CONDIZIONI
		//ne abbiamo 4 tipi: if-else, oper ternario, switch-case, try-catch
		
//if-else
/*	SINTASSI:
 * if (condizione) {
 * 		istruzioni se condizione true
 * 	} else if (altra condizione) {
 * 		istruzioni se altra-condizione true
 * 	} else {
 * 		istruzioni se condizioni precedenti tutte false
 * 	}
 * 
 * 	A parte if (condizione) { ... } tutti gli altri blocchi sono opzionali
 *	Parentesi graffe si possono omettere se riga di condizione unica
 */
	int eta = 30;
	if (eta >= 18) {
		System.out.println("Hai l'età adeguata per conseguire la patente");	
	}
		
	if (eta >= 18) {
		System.out.println("Puoi prendere la patente");
	} else {
		System.out.println("Non hai l'età minima");
	}
	//le prime due condizioni vanno scambiate altrimenti la prima intercetta tutti i casi
	//compresi quelli che sarebbero di competenza della seconda
	if (eta >= 18) {	//ci va prima eta > 95
		System.out.println("Puoi prendere la patente");
	} else if (eta > 95) {	// e qui va eta >= 18
		System.out.println("Non puoi più avere una patente valida");
	} else if (eta <= 0) {
		System.out.println("età errata");
	} else {
		System.out.println("Non hai l'età minima necessaria");
	}
	
	
	int etaElementari = 12;
	if (etaElementari >= 5 && etaElementari <= 11) {
		System.out.println("Ti puoi iscrivere alle elementari");
	}
		
	
//SWITCH serve per eseguire un controllo su valori specifici, il break interrompe il controllo restituendo il match della variabile assegnata
	
	int voto = 10;
	switch (voto) {
	case 1:
		System.out.println("Potevi stare a dormire");
	case 2:
		System.out.println("1 perchè ti sei alzato e 1 perchè sei venuto a scuola");
	case 3:
		System.out.println("Non classificato");
		break;
	case 4:
		System.out.println("Gravemente insufficiente");
		break;
	case 5:
		System.out.println("Insufficiente");
		break;
	case 6:
		System.out.println("Sufficiente");
		break;
	case 7:
	case 8:
		System.out.println("Buono");
		break;
	case 9:
		System.out.println("Distinto");
		break;
	case 10:
		System.out.println("Ottimo");
		break;
	default:
		System.out.println("Voto non valido");
	}

	String cibo = "Pesca";
	switch (cibo) {
	case "Mela":
	case "Pesca":
	case "Banana":
	case "Kiwi":
		System.out.println("E' frutta");
		break;
	case "Salsicce":
	case "Bistecca":
		System.out.println("E' carne");
	default:
		System.out.println("Cibo non riconosciuto");
	}
//Siccome il colore viene definito in una Enum (che di fatto è una classe)
//questo definisce un tipo di dato derivato. Quando istanzio una variabile
//di tipo colore devo quindi usare il nome della classe o enum come Tipo di Dato.
	
	Colore color = Colore.GREEN;
	
	switch (color) {
	case RED:
		System.out.println("Rosso");
		break;
	case BLUE:
		System.out.println("Blu");
		break;
	case GREEN:
		System.out.println("Verde");
	}
	
	
	
	
	
	
	
	
	
	}

}
