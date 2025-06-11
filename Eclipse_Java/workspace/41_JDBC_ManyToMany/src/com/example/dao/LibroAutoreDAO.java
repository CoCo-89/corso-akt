package com.example.dao;

import com.example.models.LibroAutore;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroAutoreDAO {

    private final Connection connection;

    public LibroAutoreDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Integer> getAutoriIdsByLibroId(int libroId) throws SQLException {
        List<Integer> autoriIds = new ArrayList<>();
        String sql = "SELECT id_autore FROM Libro_Autore WHERE id_libro = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, libroId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                autoriIds.add(rs.getInt("id_autore"));
            }
        }
        return autoriIds;
    }

    public boolean create(LibroAutore libroAutore) throws SQLException {
        String sql = "INSERT INTO Libro_Autore (id_libro, id_autore) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, libroAutore.getIdLibro());
            pstmt.setInt(2, libroAutore.getIdAutore());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean deleteByLibroId(int libroId) throws SQLException {
        String sql = "DELETE FROM Libro_Autore WHERE id_libro = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, libroId);
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean deleteByAutoreId(int autoreId) throws SQLException {
        String sql = "DELETE FROM Libro_Autore WHERE id_autore = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, autoreId);
            return pstmt.executeUpdate() > 0;
        }
    }
}