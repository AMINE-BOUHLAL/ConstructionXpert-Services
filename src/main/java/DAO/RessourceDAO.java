package DAO;


import Model.Ressource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RessourceDAO {
    private Connection connection;

    public RessourceDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/construction", "root", ""); // Ajustez selon votre base de données

            System.out.println("Connected to database");

            String createTableSQL = "CREATE TABLE IF NOT EXISTS ressource ("
                    + "id_ressource INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nom VARCHAR(100) NOT NULL, "
                    + "type VARCHAR(50) NOT NULL, "
                    + "quantite INT NOT NULL, "
                    + "fournisseur VARCHAR(100) NOT NULL "
                    + ")";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Table 'ressource' is ready.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Add new resource
    public void addRessource(Ressource ressource) {
        String query = "INSERT INTO ressource (nom, type, quantite, fournisseur) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ressource.getNom());
            preparedStatement.setString(2, ressource.getType());
            preparedStatement.setInt(3, ressource.getQuantite());
            preparedStatement.setString(4, ressource.getFournisseur());
            preparedStatement.executeUpdate();
            System.out.println("Ressource ajoutée avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la ressource: " + e.getMessage());
        }
    }

    // Get resource by ID
    public Ressource getRessourceById(int id) {
        Ressource ressource = null;
        String query = "SELECT * FROM ressource WHERE id_ressource = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ressource = new Ressource(
                            rs.getInt("id_ressource"),
                            rs.getString("nom"),
                            rs.getString("type"),
                            rs.getInt("quantite"),
                            rs.getString("fournisseur")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la ressource: " + e.getMessage());
        }
        return ressource;
    }

    // Get all resources
    public List<Ressource> getAllRessources() {
        List<Ressource> listRessources = new ArrayList<>();
        String query = "SELECT * FROM ressource";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Ressource ressource = new Ressource(
                        rs.getInt("id_ressource"),
                        rs.getString("nom"),
                        rs.getString("type"),
                        rs.getInt("quantite"),
                        rs.getString("fournisseur")
                );
                listRessources.add(ressource);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des ressources: " + e.getMessage());
        }
        return listRessources;
    }

    // Update resource
    public void updateRessource(Ressource ressource) {
        String query = "UPDATE ressource SET nom = ?, type = ?, quantite = ?, fournisseur = ? WHERE id_ressource = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ressource.getNom());
            stmt.setString(2, ressource.getType());
            stmt.setInt(3, ressource.getQuantite());
            stmt.setString(4, ressource.getFournisseur());
            stmt.setInt(5, ressource.getId_ressource());
            stmt.executeUpdate();
            System.out.println("Ressource mise à jour avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de la ressource: " + e.getMessage());
        }
    }

    // Delete resource
    public void deleteRessource(int id) {
        String query = "DELETE FROM ressource WHERE id_ressource = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Ressource supprimée avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la ressource: " + e.getMessage());
        }
    }
}