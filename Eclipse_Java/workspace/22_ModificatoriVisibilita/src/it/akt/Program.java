
/* MODIFICATORI DI VISIBILITA'
Struttura del progetto
		src/
		├── it/
		│   ├── esempio1/
		│   │   └── ClasseA.java
		│   └── esempio2/
		│       └── ClasseB.java

I modificatori di visibilit in Java sono 4 applicabili a campi e metodi e 2 applicabili alle classi


CAMPI E METODI:
+---------------+----------------------+-----------------------+--------------------------+----------+
| Modificatore  | Nella stessa classe  | Nello stesso package  | Nelle sottoclassi        | Ovunque  |
|               |                      |                       | (anche in altri package) |          |
+---------------+----------------------+-----------------------+--------------------------+----------+
| private       | SÌ                   | NO                    | NO                       | NO       |
| (nessuno)     | SÌ                   | SÌ                    | NO                       | NO       |
| protected     | SÌ                   | SÌ                    | SÌ                       | NO       |
| public        | SÌ                   | SÌ                    | SÌ                       | SÌ       |
+---------------+----------------------+-----------------------+--------------------------+----------+


TRA CLASSI:
+-------------------------+-----------------------------+
| Modificatore            | Visibilità della classe     |
+-------------------------+-----------------------------+
| public                  | Visibile da qualsiasi file  |
| (nessuno - default)     | Visibile solo nel package   |
+-------------------------+-----------------------------+




*/
package it.akt;

import it.akt.esempio1.ClasseA;

public class Program {

	public static void main(String[] args) {
		
		
		ClasseA clA = new ClasseA();
		
		
		//Un metodo public mi permette di accedere a tutti i campi interni della classe
		clA.stampa();
		
		System.out.println(clA.pubblico); //il campo public è l'unico visibile in modo diretto
		
	}
}
