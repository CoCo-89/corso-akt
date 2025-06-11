// RIFERIMENTO: Java - Maggi ed. 2024 - pag. 82
package it.akt;

public class Program {

    public static void main(String[] args) {

        /*
         * Ogni classe Java che vogliamo eseguire direttamente
         * deve avere un metodo main con questa firma esatta:
         * 
         *     public static void main(String[] args)
         * 
         * Senza questo metodo, la classe **non può essere avviata**
         * con il comando `java NomeClasse`.
         * 
         * Il parametro `args` è un array di stringhe che contiene
         * gli eventuali argomenti passati da riga di comando.
         * 
         * Se non vengono passati argomenti, l'array esiste comunque
         * ma ha lunghezza zero (args.length == 0).
         * 
         * NOTA: È anche possibile usare la sintassi con varargs:
         *     public static void main(String... args)
         * che ha lo stesso significato (args è sempre un array di String).
         */

        System.out.println("Numero di argomenti del main: " + args.length);

        for (String str : args)
            System.out.println(str);
        
        int somma = 0;
        try {
        	for(String str : args) {
        		somma += Integer.parseInt(str);
        	}
        	System.out.println((double)somma/args.length);
        } catch (Exception e) {
        	System.out.println("Oops.. qualcosa è andato storto!");
        	System.out.println(e.getMessage());
        	
        }

        /*
         * Per testare il passaggio di argomenti, apri un terminale
         * nella cartella /bin del progetto e scrivi:
         * 
         *     java it.akt.Program
         * --> Output: Numero di argomenti del main: 0
         * 
         *     java it.akt.Program buona serata
         * --> Output:
         *     Numero di argomenti del main: 2
         *     buona
         *     serata
         * 
         * In Java è possibile avere più classi con un metodo main,
         * ad esempio una classe Somma con un main che esegue
         * la somma degli argomenti numerici passati.
         */
    }
}


/*
				ATTENZIONE!!! NOVITA':
				
NUOVA DEFINIZIONE RIDOTTA DEL MAIN A PARTIRE DA JAVA 23 O SUPERIORE
Richiede Java 23 o superiore

Con Java 23 è stata resa stabile la funzionalità chiamata "Unnamed Classes and Instance main Methods", 
che consente di scrivere programmi Java come se fosse uno script, senza dover definire:
	• una classe
	• il modificatore public
	• il modificatore static
	• e nemmeno il void main(String[] args) classico
Il compilatore crea automaticamente una classe implicita (anonima) e inserisce il metodo main 
dentro un contesto valido.

package it.akt;

void main(String[] args) {
 System.out.println("Numero di argomenti del main: " + args.length);

 for (String str : args)
     System.out.println(str);
}

*/



