package com.example.dto;

import com.example.models.Autore;
import com.example.models.Editore;

import java.util.List;

public class LibroCompletoDTO {
    private int idLibro;
    private String titolo;
    private int anno;
    private Editore editore;
    private List<Autore> autori;

    public LibroCompletoDTO() {
    }

    public LibroCompletoDTO(int idLibro, String titolo, int anno, Editore editore, List<Autore> autori) {
        this.idLibro = idLibro;
        this.titolo = titolo;
        this.anno = anno;
        this.editore = editore;
        this.autori = autori;
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

    public Editore getEditore() {
        return editore;
    }

    public void setEditore(Editore editore) {
        this.editore = editore;
    }

    public List<Autore> getAutori() {
        return autori;
    }

    public void setAutori(List<Autore> autori) {
        this.autori = autori;
    }

	@Override
	public String toString() {
		return "LibroCompletoDTO [idLibro=" + idLibro + ", titolo=" + titolo + ", anno=" + anno + ", editore=" + editore
				+ ", autori=" + autori + "]";
	}


}