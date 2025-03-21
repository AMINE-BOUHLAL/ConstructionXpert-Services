package Model;

import java.time.LocalDate;

public class Projet {
    private int idProjet;
    private String nomProjet;
    private String description;
    private  String dateDebut;
    private  String dateFin;
    private float budget;

    public Projet() {
    }
    public Projet(int idProjet, String nomProjet, String description, String dateDebut, String dateFin, float budget) {
        this.idProjet = idProjet;
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }
    public Projet(String nomProjet, String description, String dateDebut, String dateFin, float budget) {
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }


    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }
}