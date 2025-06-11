package com.example.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sviluppatori")
public class Sviluppatore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSviluppatore;

    @Column(name = "nome_sviluppatore", nullable = false, unique = true, length = 100)
    private String nomeSviluppatore;

// Relazione N-M con Videogiochi
// mappedBy="sviluppatori" indica che la relazione è mappata dal campo 'sviluppatori' nella classe Videogioco
    @ManyToMany(mappedBy = "sviluppatori")
    private Set<Videogioco> videogiochi = new HashSet<>();

    // Costruttori
    public Sviluppatore() {
    }

    public Sviluppatore(String nomeSviluppatore) {
        this.nomeSviluppatore = nomeSviluppatore;
    }

    // Getter e Setter
    public Long getIdSviluppatore() {
        return idSviluppatore;
    }

    public void setIdSviluppatore(Long idSviluppatore) {
        this.idSviluppatore = idSviluppatore;
    }

    public String getNomeSviluppatore() {
        return nomeSviluppatore;
    }

    public void setNomeSviluppatore(String nomeSviluppatore) {
        this.nomeSviluppatore = nomeSviluppatore;
    }

    public Set<Videogioco> getVideogiochi() {
        return videogiochi;
    }

    public void setVideogiochi(Set<Videogioco> videogiochi) {
        this.videogiochi = videogiochi;
    }

    @Override
    public String toString() {
        return "Sviluppatore{" +
               "idSviluppatore=" + idSviluppatore +
               ", nomeSviluppatore='" + nomeSviluppatore + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sviluppatore that = (Sviluppatore) o;
        return idSviluppatore != null && idSviluppatore.equals(that.idSviluppatore);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}