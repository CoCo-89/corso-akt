package com.example.models;

public class Editore {
    private int idEditore;
    private String nomeEditore;
    private String sede;

    public Editore() {
    }

    public Editore(int idEditore, String nomeEditore, String sede) {
    	setIdEditore(idEditore);
    	setNomeEditore(nomeEditore);
    	setSede(sede);
    }

    // Getter e Setter per tutti gli attributi
    public int getIdEditore() {
        return idEditore;
    }

    public void setIdEditore(int idEditore) {
        this.idEditore = idEditore;
    }

    public String getNomeEditore() {
        return nomeEditore;
    }

    public void setNomeEditore(String nomeEditore) {
        this.nomeEditore = nomeEditore;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

	@Override
	public String toString() {
		return "Editore [idEditore=" + idEditore + ", nomeEditore=" + nomeEditore + ", sede=" + sede + "]";
	}


}