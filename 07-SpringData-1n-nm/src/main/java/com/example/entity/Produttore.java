package com.example.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produttori") 
public class Produttore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idProduttore; // Utilizzo di Long per gli ID, buona pratica

    @Column(name = "nome_produttore", nullable = false, unique = true, length = 100)
    private String nomeProduttore;
    
    
/*
     **** Relazione 1-N con Videogiochi ****
     mappedBy="produttore" indica che la relazione è mappata dal campo 'produttore' nella classe Videogioco.
     CascadeType.ALL significa che le operazioni (persist, remove, merge, refresh, detach) si propagheranno
     alle entità correlate. ATTENZIONE al REMOVE in produzione!
     orphanRemoval=true significa che se un Videogioco viene rimosso dalla collezione di un Produttore,
     sarà rimosso anche dal database.
     
     			  ┌──Videog1 (Pr - Fk)
     			  ├──Videog2 (Pr - Fk)	
     1 Pr (Pk=)	──┼──Videog3 (Pr - Fk)	
     			  ├──Videog4 (Pr - Fk)	
     			  └──Videog5 (Pr - Fk)	
     			  
	Questo fa sì che se se elimino il produttore la FK in videogioco venga impostata a Null
    @OneToMany(mappedBy = "produttore", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) MERGE ricollega elementi orfani

    In questo caso invece, se rimuovo un produttore, a cascata verranno eliminati completamente
    anche i Videogiochi 			  
    @OneToMany(mappedBy = "produttore", cascade = CascadeType.ALL, orphanRemoval = true)
 			  
     			  
*/     
    @OneToMany(mappedBy = "produttore", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Videogioco> videogiochi = new HashSet<>();
    


    // Costruttori
    public Produttore() {
    }

    public Produttore(String nomeProduttore) {
        this.nomeProduttore = nomeProduttore;
    }

    // Getter e Setter
    public Long getIdProduttore() {
        return idProduttore;
    }

    public void setIdProduttore(Long idProduttore) {
        this.idProduttore = idProduttore;
    }

    public String getNomeProduttore() {
        return nomeProduttore;
    }

    public void setNomeProduttore(String nomeProduttore) {
        this.nomeProduttore = nomeProduttore;
    }

    public Set<Videogioco> getVideogiochi() {
        return videogiochi;
    }

    public void setVideogiochi(Set<Videogioco> videogiochi) {
        this.videogiochi = videogiochi;
    }

//ATTENZIONE: **** Metodi aggiuntivi per aggiungere/rimuovere videogiochi dalla collezione ****
    public void addVideogioco(Videogioco videogioco) {
        this.videogiochi.add(videogioco);
        videogioco.setProduttore(this);
    }

    public void removeVideogioco(Videogioco videogioco) {
        this.videogiochi.remove(videogioco);
        videogioco.setProduttore(null); // Importante per rompere la relazione
    }

    @Override
    public String toString() {
        return "Produttore{" +
               "idProduttore=" + idProduttore +
               ", nomeProduttore='" + nomeProduttore + '\'' +
               '}';
    }

    // Optional: hashCode e equals per lavorare correttamente con Set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produttore that = (Produttore) o;
        return idProduttore != null && idProduttore.equals(that.idProduttore);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}