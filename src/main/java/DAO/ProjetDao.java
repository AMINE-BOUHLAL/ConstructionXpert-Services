package DAO;

import Config.DbConfig;
import Model.Projet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDao {

    private Connection connection;

    public ProjetDao() throws SQLException {
        connection = DbConfig.getConnection();
        createProjetTable();
    }

    private void createProjetTable() {
        String createProjetTable = "CREATE TABLE IF NOT EXISTS projet (" +
                "idProjet INT AUTO_INCREMENT PRIMARY KEY," +
                "nomProjet VARCHAR(100) NOT NULL, " +
                "description VARCHAR(100) NOT NULL, " +
                "dateDebut VARCHAR(100) , " +
                "dateFin VARCHAR(100) , " +
                "budget FLOAT NOT NULL " +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createProjetTable);
            System.out.println("Table 'projet' créée avec succès (si elle n'existait pas).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertProjet(Projet projet) {
        String insertUserQuery = "INSERT INTO projet (nomProjet, description, dateDebut, datefin, budget) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
            preparedStatement.setString(1, projet.getNomProjet());
            preparedStatement.setString(2, projet.getDescription());
            preparedStatement.setString(3, projet.getDateDebut());
            preparedStatement.setString(4, projet.getDateFin());
            preparedStatement.setFloat(5, projet.getBudget());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Projet getProjet(int idProjet) {
        Projet projet = null;
        String select = "SELECT * FROM projet WHERE idProjet = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setInt(1, idProjet);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                projet = new Projet(
                        resultSet.getInt("idProjet"),
                        resultSet.getString("nomProjet"),
                        resultSet.getString("description"),
                        resultSet.getString("dateDebut"),
                        resultSet.getString("dateFin"),
                        resultSet.getFloat("budget")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération du projet", e);
        }
        return projet;
    }

    public List<Projet> getAllProjets() {
        List<Projet> projets = new ArrayList<>();
        String select = "SELECT * FROM projet";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Projet projet = new Projet(
                        resultSet.getInt("idProjet"),
                        resultSet.getString("nomProjet"),
                        resultSet.getString("description"),
                        resultSet.getString("dateDebut"),
                        resultSet.getString("dateFin"),
                        resultSet.getFloat("budget")
                );
                projets.add(projet);
            }
            System.out.println("Nombre de projets récupérés : " + projets.size());
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des projets", e);
        }
        return projets;
    }

    public void deleteProjet(int idProjet) {
        String delete = "DELETE FROM projet WHERE idProjet = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, idProjet);
            preparedStatement.executeUpdate();
            System.out.println("Projet supprimé");
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression du projet", e);
        }
    }

    public void updateProjet(Projet projet) {
        String query = "UPDATE projet SET nomProjet = ?, description = ?, dateDebut = ?, dateFin = ?, budget = ? WHERE idProjet = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, projet.getNomProjet());
            stmt.setString(2, projet.getDescription());
            stmt.setString(3, projet.getDateDebut());
            stmt.setString(4, projet.getDateFin());
            stmt.setFloat(5, projet.getBudget());
            stmt.setInt(6, projet.getIdProjet());
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Projet mis à jour avec succès ! " + rowsAffected + " ligne(s) affectée(s).");
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la mise à jour du projet", e);
        }
    }
}