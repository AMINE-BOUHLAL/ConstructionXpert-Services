package Model;

import java.util.Date;

public class Projet {
    private int id_projet;
    private String nom;
    private String description;
    private String date_debut;
    private String date_fint;
    private float budget;


    public Projet(int id_projet, String nom, String description, String date_debut, String date_fint, float budget) {
        this.id_projet = id_projet;
        this.nom = nom;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fint = date_fint;
        this.budget = budget;
    }

    public Projet() {
    }

    public Projet(String nom, String description, String date_debut, String date_fint, float budget) {
        this.nom = nom;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fint = date_fint;
        this.budget = budget;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getDate_fint() {
        return date_fint;
    }

    public void setDate_fint(String date_fin) {
        this.date_fint = date_fint;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "budget=" + budget +
                ", id_projet=" + id_projet +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date_debut='" + date_debut + '\'' +
                ", date_fin='" + date_fint + '\'' +
                '}';
    }
}