package it.akt;

import java.math.BigInteger;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nome = "Guido"; //dichiaro una variabile di tipo Stringa
		
		System.out.println("Ciao " + nome);
		
		System.out.print("Non va a capo...");
		System.out.println("questo segue e alla fine va a capo");
		System.out.println("Ora sono a capo");
		
		System.out.print("A capo manualmente \n");
		System.out.println("Test");
		
		System.out.println("""
				Questo è un testo
				scritto su piu righe
				disponibile da Java 15
				""");
		
		
		
		
		
		
// BOOLEANI: boolean
		
		boolean b = true;	//dichiarazione e inizializzazione della variabile b
		boolean b1;			//solo dichiarazione di b1
		b1 = false;			//solo inizializzazione di b1 ( per farla deve essere già stata dichiarata)
		
		System.out.println("valore di b: " + b);
		
// CHAR:	char
		char chr = 65;		//codici ASCII
		System.out.println(chr);
		
		char chr1 = 'b';	//i singoli caratteri si indicano tra ' ' apici singoli
		System.out.println(chr1);
		
		char chu = '\u0040';	//codici per caratteri UNICODE
		
		char ch = 'a';
		System.out.println(ch);	//stampa 'a'
		
		//voglio estrarre il numero ascii corrispondente
		int ch_int = (int)ch;	//si chiama CAST: conversione forzata di un tipo primitivo in un altro tipo primitivo
		System.out.println(ch_int);
		
		ch = (char) ((char)((int)ch) -32);
		int chNum = (int)ch-32;
		ch = (char)chNum;
		
//BYTE:		byte	da -128 a 127
		byte by = 10;
		//by = 200; non funziona sono oltre il range
		by = (byte)200;
		System.out.println(by);
		
//SHORT:	short
		short srt = 15432;
		srt = (short)1200000;
		
//INT		int è il tipo predefinito oer i valori "litheral" (a destra dell'uguale)
		int i = 20_000_000;	//posso usare _ come separatore delle migliaia
		//system out print f stampa in esadecimale
		
//LONG:		long
		long lng = 1000;
		long lng1 = 23_000_000_000L;	//23 miliardi è maggiore del limite del litheral int, per convenzione su usa sempre la L maiuscola alla fine del long
		long ml = Long.MAX_VALUE;
		System.out.println(ml); //stampa il valore massimo di long
		
//FLOAT		float
		float fl = 1.23F;	//il litheral in virgola mobile di default è 'double' a 64 bit e quindi non ci sta il un float a 32bit
							//di conseguenza utilizzare la F maiuscola alla fine del dato float
		float fl1 = (float) 1.23;	//cast di float per ottenere lo stesso risultato della F del dato
		
//DOUBLE	double è il tipo di dato litheral predefenito per numeri in virgola mobile
		double db = 2.33; 
		double md = Double.MAX_VALUE;
		System.out.println(md);
		
//==================================================================================================
		
//BIGINTEGER
		
		BigInteger big1 = new BigInteger ("123456789");
		BigInteger big2 = new BigInteger ("122");
		
		BigInteger somma = big1.add(big2);
		System.out.println(somma);

		BigInteger moltiplica = big1.multiply(big2);
		System.out.println(moltiplica);
	}

}
