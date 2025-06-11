package it.akt;

public class Program {

	public static void main(String[] args) {
		
/*
 * INTRODUZIONE A JAVADOC
 * =======================
 * 
 * JavaDoc è uno strumento incluso nel JDK che consente di generare automaticamente 
 * la documentazione del nostro codice Java in formato HTML. I commenti JavaDoc sono 
 * speciali commenti in stile /** ... * / (senza lo spazio), scritti direttamente 
 * nel codice sorgente sopra classi, metodi, costruttori, campi e interfacce.
 * 
 * Quando esportiamo la documentazione (anche tramite Eclipse: Project > Generate Javadoc...),
 * otteniamo un sito HTML con una struttura simile a quella della documentazione ufficiale di Java.
 * 
 * È importante rispettare alcune regole per l’utilizzo dei tag JavaDoc, così da ottenere
 * una documentazione coerente e priva di errori.
 * 
 * Ecco una panoramica dei principali tag:
 * 
 * ORDINE DEI TAG (raccomandato)
 * -----------------------------
 * 
 *  @author      (solo per classi e interfacce)
 *  @version     (solo per classi e interfacce)
 *  @param       (per metodi e costruttori con parametri)
 *  @return      (per metodi che restituiscono un valore)
 *  @throws      (o @exception, per eccezioni sollevate)
 *  @see         (per collegamenti ad altre classi o metodi)
 *  @since       (versione dalla quale è disponibile)
 *  @deprecated  (per indicare API deprecate)
 *  @serial, @serialField, @serialData (per classi serializzabili)
 * 
 * REGOLE E CONVENZIONI UTILI
 * --------------------------
 * 
 * 1. Più tag @author devono essere in ordine cronologico.
 * 2. I tag @param devono seguire l’ordine dei parametri nel metodo.
 * 3. I tag @throws/@exception devono essere elencati in ordine alfabetico.
 * 
 * TAG OBBLIGATORI PER I METODI (per convenzione):
 * ----------------------------------------------
 * - @param: per ogni parametro, anche se la descrizione è ovvia.
 * - @return: per ogni metodo che non restituisce void.
 * 
 * CONSULTA: PDF di riferimento o documentazione ufficiale su:
 * https://docs.oracle.com/en/java/javase/17/docs/specs/javadoc/doc-comment-spec.html
 * 
 * ESEMPIO PRATICO
 * ---------------
 * La classe "Prodotto" qui sotto è stata completamente documentata con JavaDoc.
 */

		String str = "mele";

		Prodotto p = new Prodotto(str, 1.23, 10);

		System.out.println(p.calcolaTotale(5));
	}
}
