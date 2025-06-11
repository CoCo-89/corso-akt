package com.example.dto;

import com.example.models.Autore;
import com.example.models.Libro;

import java.util.List;

public class AutoreConLibriDTO {
    private Autore autore;
    private List<Libro> libri;

    public AutoreConLibriDTO(Autore autore, List<Libro> libri) {
        this.autore = autore;
        this.libri = libri;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }
}