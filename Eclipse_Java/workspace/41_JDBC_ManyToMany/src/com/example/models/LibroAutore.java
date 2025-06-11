package com.example.models;

public class LibroAutore {
    private int idLibro;
    private int idAutore;

    public LibroAutore() {
    }

    public LibroAutore(int idLibro, int idAutore) {
    	setIdLibro(idLibro);
    	setIdAutore(idAutore);
    }

    // Getter e Setter per gli attributi
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

	//Abbastanza inutile se non per avere un controllo visivo degli insert
    @Override
	public String toString() {
		return "LibroAutore [idLibro=" + idLibro + ", idAutore=" + idAutore + "]";
	}


}