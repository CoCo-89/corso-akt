package com.example.model;

import jakarta.persistence.*; // Importa tutte le annotazioni JPA necessarie
import java.time.LocalDate;
import java.util.Objects;    

@Entity 					// Indica che questa classe è un'entità JPA e mapperà a una tabella del database
@Table(name = "Contatti") 	// Specifica il nome della tabella nel database, se diverso dal nome della classe
public class Contatto {

    @Id 							// Indica che questo campo è la chiave primaria dell'entità
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che il valore della chiave primaria è generato 
    													//automaticamente dal database (AUTO_INCREMENT)    
    @Column(name = "id_contatto") 	// Specifica il nome della colonna nel database, se diverso dal nome del campo
    private Integer idContatto;

    // nullable=true è il default, superfluo ma possiamo esplicitarlo per chiarezza 
    @Column(name = "nome", length = 100, nullable = true) 
    private String nome;

    @Column(name = "cognome", length = 100, nullable = true)
    private String cognome;

    @Column(name = "tel", length = 50, nullable = false) // nullable=false indica che la colonna NON può essere NULL
    private String tel;

    @Column(name = "mail", length = 255, nullable = true)
    private String mail;

    @Column(name = "dataNascita", nullable = true)
    private LocalDate dataNascita;

    // ATTENZIONE: Il vincolo CHECK (nome IS NOT NULL OR cognome IS NOT NULL)
    // non può essere mappato direttamente da JPA/Hibernate con un'annotazione standard.
    // Questo vincolo deve essere applicato direttamente a livello di DDL (SQL) sul database,
    // come hai già fatto nella tua query CREATE TABLE.
    // Hibernate si preoccuperà di far fallire l'operazione di INSERT/UPDATE se il DB
    // rifiuta il dato a causa di questo CHECK constraint.

    // --- Costruttori ---
    // Costruttore di default (richiesto da JPA)
    public Contatto() {
    }

    // Costruttore con tutti i campi (utile per creare oggetti Contatto più facilmente)
    public Contatto(String nome, String cognome, String tel, String mail, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.tel = tel;
        this.mail = mail;
        this.dataNascita = dataNascita;
    }

    // Getter e Setter 
    public Integer getIdContatto() {
        return idContatto;
    }

    public void setIdContatto(Integer idContatto) {
        this.idContatto = idContatto;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    // --- Metodi toString, equals e hashCode (opzionali ma consigliati per debugging e collezioni) ---
	@Override
	public String toString() {
		return "Contatto [idContatto=" + idContatto + ", nome=" + nome + ", cognome=" + cognome + ", tel=" + tel
				+ ", mail=" + mail + ", dataNascita=" + dataNascita + "]";
		
	}

	/*@Override
	public int hashCode() {
		return Objects.hash(cognome, dataNascita, idContatto, mail, nome, tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatto other = (Contatto) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(dataNascita, other.dataNascita)
				&& Objects.equals(idContatto, other.idContatto) && Objects.equals(mail, other.mail)
				&& Objects.equals(nome, other.nome) && Objects.equals(tel, other.tel);*/
	}


