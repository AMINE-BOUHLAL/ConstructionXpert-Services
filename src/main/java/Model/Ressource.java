package Model;



public class Ressource {
    private int id_ressource;
    private String nom;
    private String type;
    private int quantite;
    private String fournisseur;

    public Ressource(int id_ressource, String nom, String type, int quantite, String fournisseur) {
        this.id_ressource = id_ressource;
        this.nom = nom;
        this.type = type;
        this.quantite = quantite;
        this.fournisseur = fournisseur;
    }

    public Ressource() {

    }

    public int getId_ressource() {
        return id_ressource;
    }

    public void setId_ressource(int id_ressource) {
        this.id_ressource = id_ressource;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "Ressource{" +
                "id_ressource=" + id_ressource +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", quantite=" + quantite +
                ", fournisseur='" + fournisseur + '\'' +
                '}';
    }


}