package Model;

public class Tache {
    private int id_tache;
    private String nom;
    private String date_debut;
    private String date_fin;
    private String discription;
    private int id_projet;
    private String nomProjet;


    public Tache(int id_tache, String nom, String date_debut, String date_fin, String discription, int id_projet, String nomProjet) {
        this.id_tache = id_tache;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.discription = discription;
        this.id_projet = id_projet;
        this.nomProjet = nomProjet;
    }

    public Tache(String nom, String date_debut, String date_fin, String discription, int id_projet, String nomProjet) {
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.discription = discription;
        this.id_projet = id_projet;
        this.nomProjet = nomProjet;
    }

}