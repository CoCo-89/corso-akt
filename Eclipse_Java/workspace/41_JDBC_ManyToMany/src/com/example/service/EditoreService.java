package com.example.service;

import com.example.dao.EditoreDAO;
import com.example.models.Editore;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EditoreService {

    private final EditoreDAO editoreDAO;
    private final Connection connection;

    public EditoreService(Connection connection) {
        this.connection = connection;
        this.editoreDAO = new EditoreDAO(connection);
    }

    public Optional<Editore> getEditoreById(int id) throws SQLException {
        return editoreDAO.getById(id);
    }

    public List<Editore> getAllEditori() throws SQLException {
        return editoreDAO.getAll();
    }

    public boolean createEditore(Editore editore) throws SQLException {
        return editoreDAO.create(editore);
    }

    public boolean updateEditore(Editore editore) throws SQLException {
        return editoreDAO.update(editore);
    }

    public boolean deleteEditore(int id) throws SQLException {
        // Potrebbe essere necessario gestire i libri associati a questo editore
        // (es. impedirne l'eliminazione se ci sono libri collegati o impostare l'id_editore a NULL).
        // Questa logica dipende dai requisiti dell'applicazione.
        return editoreDAO.delete(id);
    }
}