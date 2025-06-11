package com.example.models;

public class Autore {
    private int idAutore;
    private String nome;
    private String cognome;

    public Autore() {
    }

    public Autore(int idAutore, String nome, String cognome) {
    	setIdAutore(idAutore);
    	setNome(nome);
    	setCognome(cognome);
    }

    // Getter e Setter per tutti gli attributi
    public int getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

	@Override
	public String toString() {
		return "Autore [idAutore=" + idAutore + ", nome=" + nome + ", cognome=" + cognome + "]";
	}


}