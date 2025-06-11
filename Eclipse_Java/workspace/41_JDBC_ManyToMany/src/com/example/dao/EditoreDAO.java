package com.example.dao;

import com.example.models.Editore;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EditoreDAO implements GenericDAO<Editore> {

    private final Connection connection;

    public EditoreDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Editore> getById(int id) throws SQLException {
        String sql = "SELECT id_editore, nome_editore, sede FROM Editori WHERE id_editore = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Editore(
                        rs.getInt("id_editore"),
                        rs.getString("nome_editore"),
                        rs.getString("sede")
                ));
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Editore> getAll() throws SQLException {
        List<Editore> editori = new ArrayList<>();
        String sql = "SELECT id_editore, nome_editore, sede FROM Editori";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                editori.add(new Editore(
                        rs.getInt("id_editore"),
                        rs.getString("nome_editore"),
                        rs.getString("sede")
                ));
            }
        }
        return editori;
    }

    @Override
    public boolean create(Editore editore) throws SQLException {
        String sql = "INSERT INTO Editori (nome_editore, sede) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, editore.getNomeEditore());
            pstmt.setString(2, editore.getSede());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Editore editore) throws SQLException {
        String sql = "UPDATE Editori SET nome_editore = ?, sede = ? WHERE id_editore = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, editore.getNomeEditore());
            pstmt.setString(2, editore.getSede());
            pstmt.setInt(3, editore.getIdEditore());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Editori WHERE id_editore = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
}