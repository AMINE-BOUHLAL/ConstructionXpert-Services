package DAO;

import Config.DbConfig;
import Model.Projet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDAO{

    public int Ajouter(Projet projet) throws SQLException {  // projet object pour stock les paramaetres de moudel
        Connection con = null;
        try {
            con = DbConfig.getConnection();

            String sql = "INSERT INTO projet (nom, description, date_debut, date_fint, budget.) VALUES (?, ?, ?, ?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, projet.getNom());
                stmt.setString(2, projet.getDescription());
                stmt.setString(3,  projet.getDate_debut());
                stmt.setString(4, projet.getDate_fint());
                stmt.setFloat(5, projet.getBudget());
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Projet>Afficher() throws SQLException {
        List<Projet> projets = new ArrayList<Projet>();
        try (Connection con = DbConfig.getConnection()) {
            if (con != null) {
                String query = "SELECT * FROM projet";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Projet projet = new Projet();
                    projet.setNom(rs.getString("nom"));
                    projet.setDescription(rs.getString("description"));
                    projet.setDate_debut(rs.getString("date_debut"));
                    projet.setDate_fint(rs.getString("date_fin"));
                    projet.setBudget(rs.getFloat("budget"));
                    projets.add(projet);


                }

            }
            return projets;
        }
    }


    public void Modifier (Projet projet) throws SQLException {
        String query = "UPDATE projet SET nom = ?, description = ?, date_debut = ?, date_fin = ?, budget = ? WHERE id = ?";
        try {
            PreparedStatement stmt = DbConfig.getConnection().prepareStatement(query);
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setString(3, projet.getDate_debut());
            stmt.setString(4, projet.getDate_fint());
            stmt.setFloat(5, projet.getBudget());
            stmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void Supprimer (int id) throws SQLException {
        String query = "DELETE FROM projet WHERE id = ?";
        try {
            PreparedStatement stmt = DbConfig.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    // Get course by ID
    public static Projet getProjetById(int id){
        Projet projet = null;
        String query = "SELECT * FROM projet WHERE id = ?";

        try (PreparedStatement stmt = DbConfig.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    projet = new Projet(
                           rs.getInt("id_projet"),
                            rs.getString("nom"),
                            rs.getString("description"),
                            rs.getString("date_debut"),
                            rs.getString("date_fin"),
                            rs.getFloat("budget")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du cours: " + e.getMessage());
        }
        return projet;
    }




    }


