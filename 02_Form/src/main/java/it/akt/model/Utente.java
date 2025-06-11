package it.akt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Utente {

	//campi
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private LocalDateTime dataOraRegistrazione;
	private double peso;
	private double altezza;
	private boolean automunito;
	private List<Interessi> listaInteressi = new ArrayList<>();

	//costruttori
	public Utente () {}
	
	public Utente(String nome, String cognome, LocalDate dataNascita, LocalDateTime dataOraRegistrazione, double peso,
			double altezza, boolean automunito, List<Interessi> listaInteressi) {
		setNome(nome);
		setCognome(cognome);
		setDataNascita(dataNascita);
		setDataOraRegistrazione(dataOraRegistrazione);
		setPeso(peso);
		setAltezza(altezza);
		setAutomunito(automunito);
		setListaInteressi(listaInteressi);
	}

	
	//getters e setters
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public LocalDateTime getDataOraRegistrazione() {
		return dataOraRegistrazione;
	}

	public void setDataOraRegistrazione(LocalDateTime dataOraRegistrazione) {
		this.dataOraRegistrazione = dataOraRegistrazione;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public boolean isAutomunito() {
		return automunito;
	}

	public void setAutomunito(boolean automunito) {
		this.automunito = automunito;
	}

	public List<Interessi> getListaInteressi() {
		return listaInteressi;
	}

	public void setListaInteressi(List<Interessi> listaInteressi) {
		this.listaInteressi = listaInteressi;
	}


	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", dataOraRegistrazione=" + dataOraRegistrazione + ", peso=" + peso + ", altezza=" + altezza
				+ ", automunito=" + automunito + ", listaInteressi=" + listaInteressi + "]";
	}

	
	
}
