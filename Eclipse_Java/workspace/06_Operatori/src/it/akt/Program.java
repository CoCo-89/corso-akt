package it.akt;

public class Program {

	public static void main(String[] args) {
		// OPERATORI
		
/*
	Si dividono in
		UNARI
		BINARI
		TERNARIO
	In base al numero di operandi con cui interagiscono
 */
	
//UNARI: 		+- (come simboli algebrici) ++ -- ! (significa NOT)
	System.out.println("========= UNARI =========");
		
	int x = 10;
	int y = -10;
		
	System.out.println(x);
	//	++	--	incrementano o diminuiscono di 1 il valore della variabile a cui sono applicati
	//Entrambi sono prefissi o postfissi: ++x	o x++	possono essere messi primo o dopo la variabile
	System.out.println(x++);	//prefisso: prima stampa X poi ne incrementa il valore
	System.out.println(x);		//se ristampo X ora vedo che vale 11
	
	//equivale alle due seguenti sintassi:
	x = x + 1;
	x += 1;
	
	//NOT ! inverte il valore di un booleano
	boolean vf = true;
	System.out.println(!vf);	//stampa false
	
//BINARI: 	matematici, relazionali, instanceof, logici, di assegnamento, bitwise (operazioni sui bit)
	System.out.println("========= BINARI =========");
	//MATEMATICI: / * - + % (non è percentuale: è MODULO. Indica il resto di una divisione tra due numeri)
	System.out.println(4+6);
	int a = 30, b = 9;
	System.out.println(a*b);
	
	System.out.println(a%b);	//il resto di 30/9 è 3. modulo ritorna questo valore
	int resto = a % b;
	System.out.println(resto);
	
	//relazionali	<> <= >= ==	!=	(anche istanceof è un operatore relazionale)
	//mi restituiscono sempre un booleano (true o false)
	
	System.out.println(a > b);	//true
	System.out.println(a == 20);	//false
	System.out.println(b != 9);	//diverso: false
	boolean check = (b >= 5);	//true
	System.out.println(check);
	
	//OPERATORI LOGICI: &&(AND)	||(OR)	!(NOT)
/*

	AND && (In serie)
	true	&&	true	=	true
	true	&&	false	=	false
	false	&&	true	=	false
	false	&&	false	=	false
	
	OR	||	(Parallelo)
	true	||	true	=	true
	true	||	false	=	true
	false	||	true	=	true
	false	||	false	=	false
	
	NOT	!
	!true	=	false
	!false	=	true

*/
//OPERATORI DI ASSEGNAMENTO	=	+=	-=	/=	%=
/*
		z =	10;
		faccio un'operazione che modifica il valore di z
		
		z = z + a;
		z += 4; è un modo sintetico per scrivere l'istruzione precedente
		
		z = z * 2;
		z *= 2;
		
		z = z / 3
		z /= 3;
		
		z = z - 8;
		z -= 8;
		
		z = z%2;
		z %=2;
 */
// OPERATORE TERNARIO: corrisponde a una condizione
	System.out.println("========= TERNARIO =========");
	
	int estratto = 7;
	
	int premio = (estratto > 5) ? 10 : 1;
//Se estratto è maggiore di 5 allora premio=10 ALTRIMENTI(else) premio=1;
	
	int calorie = 250;
	
	String dietetico = (calorie < 200) ? "light" : "calorico";
	System.out.println(premio);
	
		
		
		

	}

}
