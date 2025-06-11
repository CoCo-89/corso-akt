package it.akt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UtenteEsercizio {
	
	//campi
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private int eta;
	private LocalDate dataNascita;
	private LocalDateTime dataOraRegistrazione;
	private String lavoro;
	private String titoloStudio;
	private double altezza;
	private double peso;
	
	public UtenteEsercizio() {
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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
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

	public String getLavoro() {
		return lavoro;
	}

	public void setLavoro(String lavoro) {
		this.lavoro = lavoro;
	}

	public String getTitoloStudio() {
		return titoloStudio;
	}

	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UtenteEsercizio [username=" + username + ", password=" + password + "]";
	}
	
	

}
