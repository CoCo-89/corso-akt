package it.akt.model;

import java.time.LocalDate;

public class Spesa {
	
	private LocalDate dataSpesa;
	private String descrizione;
	private double importo;
	private Categoria categoria;

	public Spesa() {}

	public Spesa(LocalDate dataSpesa, String descrizione, double importo, Categoria categoria) {
		this.setDataSpesa(dataSpesa);
		this.setDescrizione(descrizione);
		this.setImporto(importo);
		this.setCategoria(categoria);
	}

	public LocalDate getDataSpesa() {
		return dataSpesa;
	}

	public void setDataSpesa(LocalDate dataSpesa) {
		this.dataSpesa = dataSpesa;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Spesa [dataSpesa=" + dataSpesa + ", descrizione=" + descrizione + ", importo=" + importo
				+ ", categoria=" + categoria + "]";
	}
	
	
	
	
	
}
