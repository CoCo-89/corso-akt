package com.example.models;

public class Libro {
    private int idLibro;
    private String titolo;
    private int anno;
    private int idEditore; // Chiave esterna per l'editore

    public Libro() {
    }

    public Libro(int idLibro, String titolo, int anno, int idEditore) {
    	setIdLibro(idLibro);
    	setTitolo(titolo);
    	setAnno(anno);
        setIdEditore(idEditore);
    }

    // Getter e Setter per tutti gli attributi
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getIdEditore() {
        return idEditore;
    }

    public void setIdEditore(int idEditore) {
        this.idEditore = idEditore;
    }

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titolo=" + titolo + ", anno=" + anno + ", idEditore=" + idEditore + "]";
	}


}