package com.example.dao;

import com.example.models.Autore;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutoreDAO implements GenericDAO<Autore> {

    private final Connection connection;

    public AutoreDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Autore> getById(int id) throws SQLException {
        String sql = "SELECT id_autore, nome, cognome FROM Autori WHERE id_autore = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Autore(
                        rs.getInt("id_autore"),
                        rs.getString("nome"),
                        rs.getString("cognome")
                ));
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Autore> getAll() throws SQLException {
        List<Autore> autori = new ArrayList<>();
        String sql = "SELECT id_autore, nome, cognome FROM Autori";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                autori.add(new Autore(
                        rs.getInt("id_autore"),
                        rs.getString("nome"),
                        rs.getString("cognome")
                ));
            }
        }
        return autori;
    }

    @Override
    public boolean create(Autore autore) throws SQLException {
        String sql = "INSERT INTO Autori (nome, cognome) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, autore.getNome());
            pstmt.setString(2, autore.getCognome());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Autore autore) throws SQLException {
        String sql = "UPDATE Autori SET nome = ?, cognome = ? WHERE id_autore = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, autore.getNome());
            pstmt.setString(2, autore.getCognome());
            pstmt.setInt(3, autore.getIdAutore());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Autori WHERE id_autore = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
}

