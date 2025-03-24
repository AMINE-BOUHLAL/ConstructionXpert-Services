package DAO;


import Config.DbConfig;
import Model.Ressource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RessourceDAO {
    private Connection connection;

    public RessourceDAO() throws SQLException {
        connection = DbConfig.getConnection();
}
public void createRessource(Ressource ressource) {
        String sql="INSERT INTO ressource (nom, , type, quantite, fournisseur,  ) VALUES (?, ?, ?, ?,)";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ressource.getNom());
            ps.setString(2, ressource.getType());
            ps.setInt(3, ressource.getQuantite());
            ps.setString(4, ressource.getFournisseur());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
}

public Ressource getRessource(int id_ressource) {
    Ressource ressource = null;
    String select = "SELECT * FROM ressource WHERE id_ressource = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
        preparedStatement.setInt(1, id_ressource);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            ressource = new Ressource(
                    resultSet.getInt("id_ressource"),
                    resultSet.getString("nom"),
                    resultSet.getString("type"),
                    resultSet.getInt("quantite"),
                    resultSet.getString("fournisseur")
            );
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return ressource;
}

public List<Ressource> getAllRessources() {
        List<Ressource> ressources = new ArrayList<>();
        String select = "SELECT * FROM ressource";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ressource ressource = new Ressource(
                        resultSet.getInt("id_ressource"),
                        resultSet.getString("nom"),
                        resultSet.getString("type"),
                        resultSet.getInt("quantite"),
                        resultSet.getString("fournisseur")
                );
                ressources.add(ressource);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    return ressources;
}
public void updateRessource(Ressource ressource) {
    String sql = "UPDATE ressource SET nom = ?, type = ?, quantite = ?, fournisseur = ? WHERE id_ressource = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, ressource.getNom());
        ps.setString(2, ressource.getType());
        ps.setInt(3, ressource.getQuantite());
        ps.setString(4, ressource.getFournisseur());
        ps.setInt(5, ressource.getId_ressource());
        ps.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

public void deleteRessource(int id_ressource) {
    String delete = "DELETE FROM ressource WHERE id_ressource = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
        preparedStatement.setInt(1, id_ressource);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}}