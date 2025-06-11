package com.example.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "videogiochi")
public class Videogioco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVideogioco;

    @Column(nullable = false, length = 255)
    private String titolo;

    @Column(name = "anno_rilascio")
    private Integer annoRilascio;


/* 	**** Relazione N-1 con Produttore (lato Many) ****
    @ManyToOne indica la relazione N-1
    @JoinColumn indica la colonna della chiave esterna in questa tabella (videogiochi)
*/    
    @ManyToOne(fetch = FetchType.LAZY) 					// LAZY loading è la best practice per ManyToOne
    @JoinColumn(name = "id_produttore", nullable = true)// prevedo che il Produttore possa essere null anche per rimozione
    private Produttore produttore;

    
    
/*   **** Relazione N-M con Sviluppatori ****
     @ManyToMany indica la relazione N-M
     @JoinTable specifica la tabella di congiunzione
     name: nome della tabella di congiunzione ("sviluppatori_videogiochi")
     joinColumns: colonna di questa tabella (Videogioco) nella tabella di congiunzione
     inverseJoinColumns: colonna dell'altra tabella (Sviluppatore) nella tabella di congiunzione
*/
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 
    @JoinTable(
        name = "sviluppatori_videogiochi", //definisco nome tabella
        joinColumns = @JoinColumn(name = "id_videogioco"), //nome colonna e campo fk
        inverseJoinColumns = @JoinColumn(name = "id_sviluppatore")	//colonna inversa
    )
    private Set<Sviluppatore> sviluppatori = new HashSet<>();

    // Costruttori
    public Videogioco() {
    }

    public Videogioco(String titolo, Integer annoRilascio) {
        this.titolo = titolo;
        this.annoRilascio = annoRilascio;
    }

    // Getter e Setter
    public Long getIdVideogioco() {
        return idVideogioco;
    }

    public void setIdVideogioco(Long idVideogioco) {
        this.idVideogioco = idVideogioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoRilascio() {
        return annoRilascio;
    }

    public void setAnnoRilascio(Integer annoRilascio) {
        this.annoRilascio = annoRilascio;
    }

    public Produttore getProduttore() {
        return produttore;
    }

    public void setProduttore(Produttore produttore) {
        this.produttore = produttore;
    }

    public Set<Sviluppatore> getSviluppatori() {
        return sviluppatori;
    }

    public void setSviluppatori(Set<Sviluppatore> sviluppatori) {
        this.sviluppatori = sviluppatori;
    }

// ATTENZIONE: **** Metodi ausiliari per gestire la relazione N-M ****
    public void addSviluppatore(Sviluppatore sviluppatore) {
        this.sviluppatori.add(sviluppatore);
        sviluppatore.getVideogiochi().add(this);
    }

    public void removeSviluppatore(Sviluppatore sviluppatore) {
        this.sviluppatori.remove(sviluppatore);
        sviluppatore.getVideogiochi().remove(this);
    }

    @Override
    public String toString() {
        return "Videogioco{" +
               "idVideogioco=" + idVideogioco +
               ", titolo='" + titolo + '\'' +
               ", annoRilascio=" + annoRilascio +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videogioco that = (Videogioco) o;
        return idVideogioco != null && idVideogioco.equals(that.idVideogioco);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}