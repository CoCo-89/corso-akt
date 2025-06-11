package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentService {

	private static final String URL = "jdbc:mysql://localhost:3306/universita";
	private static final String USER = "root"; // Sostituisci
	private static final String PASSWORD = "1234"; // Sostituisci

	//Inserisce uno studente nel DB
	public int creaStudente(String nome, String cognome) {
		String sql = "INSERT INTO studenti (nome, cognome) VALUES (?, ?)";
		
		try (	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			if (conn != null ) System.out.println("Connessione stabilita col DB!");
			
			pstmt.setString(1, nome);
			pstmt.setString(2, cognome);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						return generatedKeys.getInt(1);
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("Errore durante la creazione dello studente: " + e.getMessage());
			e.printStackTrace();
		}
		return -1;
	}

	//Recupera uno studente nel DB per Id
	public void leggiStudente(int id) {
		String sql = "SELECT id, nome, cognome FROM studenti WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("ID: " + rs.getInt("id") +
									   ", Nome: " + rs.getString("nome") +
									   ", Cognome: " + rs.getString("cognome"));
				} else {
					System.out.println("Nessuno studente trovato con ID: " + id);
				}
			}
		} catch (SQLException e) {
			System.err.println("Errore durante la lettura dello studente: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Legge e stampa a console
	public void leggiStampaStudenti() {
		String sql = "SELECT id, nome, cognome FROM studenti";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") +
								   ", Nome: " + rs.getString("nome") +
								   ", Cognome: " + rs.getString("cognome"));
			}
		} catch (SQLException e) {
			System.err.println("Errore durante la lettura di tutti gli studenti: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//Legge e ritorna una Collection di Studenti (Richiede una classe Studente)
	public List<Studente> leggiRitornaStudenti() {
		List<Studente> studenti = new ArrayList<>();
		String sql = "SELECT id, nome, cognome FROM studenti";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				Studente studente = new Studente(id, nome, cognome);
				studenti.add(studente);
			}
		} catch (SQLException e) {
			System.err.println("Errore durante la lettura di tutti gli studenti: " + e.getMessage());
			e.printStackTrace();
		}
		return studenti;
	}





	public void aggiornaStudente(int id, String nome, String cognome) {
		String sql = "UPDATE studenti SET nome = ?, cognome = ? WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nome);
			pstmt.setString(2, cognome);
			pstmt.setInt(3, id);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("Studente con ID " + id + " aggiornato con successo.");
			} else {
				System.out.println("Nessuno studente trovato con ID: " + id + " per l'aggiornamento.");
			}
		} catch (SQLException e) {
			System.err.println("Errore durante l'aggiornamento dello studente: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void eliminaStudente(int id) {
		String sql = "DELETE FROM studenti WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("Studente con ID " + id + " eliminato con successo.");
			} else {
				System.out.println("Nessuno studente trovato con ID: " + id + " per l'eliminazione.");
			}
		} catch (SQLException e) {
			System.err.println("Errore durante l'eliminazione dello studente: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
