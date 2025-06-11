package com.example.dao;

import com.example.models.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroDAO implements GenericDAO<Libro> {

    private final Connection connection;

    public LibroDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Libro> getById(int id) throws SQLException {
        String sql = "SELECT id_libro, titolo, anno, id_editore FROM Libri WHERE id_libro = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            
        	pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return Optional.of(new Libro( //Metodo statico .of() usato al posto del costruttore
                        rs.getInt("id_libro"),
                        rs.getString("titolo"),
                        rs.getInt("anno"),
                        rs.getInt("id_editore")
                ));
            }
        }
        return Optional.empty(); 
        //restituisce un'istanza di Optional che non contiene alcun valore.
        //E' un modo più sicuro ed esplicito rispetto a restituire null. 
        //Restituire null può portare a NullPointerException
    }

    @Override
    public List<Libro> getAll() throws SQLException {
        List<Libro> libri = new ArrayList<>();
        String sql = "SELECT id_libro, titolo, anno, id_editore FROM Libri";
        try (	Statement stmt = connection.createStatement();
        		ResultSet rs = stmt.executeQuery(sql)) {
            
        	while (rs.next()) {
                libri.add(new Libro(
                        rs.getInt("id_libro"),
                        rs.getString("titolo"),
                        rs.getInt("anno"),
                        rs.getInt("id_editore")
                ));
            }
        }
        return libri;
    }

    @Override
    public boolean create(Libro libro) throws SQLException {
        String sql = "INSERT INTO Libri (titolo, anno, id_editore) VALUES (?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
           
        	pst.setString(1, libro.getTitolo());
            pst.setInt(2, libro.getAnno());
            pst.setInt(3, libro.getIdEditore());
            return pst.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Libro libro) throws SQLException {
        String sql = "UPDATE Libri SET titolo = ?, anno = ?, id_editore = ? WHERE id_libro = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            
        	pst.setString(1, libro.getTitolo());
            pst.setInt(2, libro.getAnno());
            pst.setInt(3, libro.getIdEditore());
            pst.setInt(4, libro.getIdLibro());
            return pst.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Libri WHERE id_libro = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        }
    }
}