package it.akt.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "Fumetti")
public class Fumetto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fumetto")
	private Integer idFumetto;
	
	@Column(name = "titolo", length = 100, nullable=true)
	private String titolo;
	
	@Column(name = "autore", length = 00, nullable=true)
	private String autore;
	
	@Column(name = "anno", length = 50, nullable=true)
	private String anno;
	
	public Fumetto() {
	}
	
	public Fumetto(String titolo, String autore, String anno) {
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
	}

	public Integer getIdFumetto() {
		return idFumetto;
	}

	public void setIdFumetto(Integer idFumetto) {
		this.idFumetto = idFumetto;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	@Override
	public String toString() {
		return "Fumetto [idFumetto=" + idFumetto + ", titolo=" + titolo + ", autore=" + autore + ", anno=" + anno + "]";
	}
	
	

	

}
