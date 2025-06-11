package it.akt;
 
/**
 * Questa classe rappresenta un semplice prodotto con nome, prezzo e quantità.
 *
 * @author Guido Cavallini 
 * @version 1.0
 * @since 2024-04-11
 */
public class Prodotto {

    /**
     * Nome del prodotto.
     */
    private String nome;

    /**
     * Prezzo del prodotto.
     */
    private double prezzo;

    /**
     * Quantità disponibile del prodotto.
     */
    private int quantita;

    /**
     * Costruttore per creare un nuovo prodotto.
     *
     * @param nome Il nome del prodotto.
     * @param prezzo Il prezzo del prodotto.
     * @param quantita La quantità disponibile del prodotto.
     */
    public Prodotto(String nome, double prezzo, int quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    /**
     * Restituisce il nome del prodotto.
     *
     * @return Il nome del prodotto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del prodotto.
     *
     * @param nome Il nuovo nome del prodotto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il prezzo del prodotto.
     *
     * @return Il prezzo del prodotto.
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il prezzo del prodotto.
     *
     * @param prezzo Il nuovo prezzo del prodotto.
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Restituisce la quantità disponibile del prodotto.
     *
     * @return La quantità disponibile del prodotto.
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * Imposta la quantità disponibile del prodotto.
     *
     * @param quantita La nuova quantità disponibile del prodotto.
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     * Calcola il totale da pagare per l'acquisto di una certa quantità di prodotti.
     *
     * @param quantitaAcquistata La quantità di prodotti acquistati.
     * @return Il totale da pagare.
     * @throws IllegalArgumentException se la quantità è minore o uguale a zero,
     *                                  oppure se supera la quantità disponibile.
     */
    public double calcolaTotale(int quantitaAcquistata) {
        if (quantitaAcquistata <= 0) {
            throw new IllegalArgumentException("La quantità acquistata deve essere maggiore di zero.");
        }

        if (quantitaAcquistata > quantita) {
            throw new IllegalArgumentException("La quantità acquistata non può superare la quantità disponibile.");
        }

        double totale = quantitaAcquistata * prezzo;
        return totale;
    }
}