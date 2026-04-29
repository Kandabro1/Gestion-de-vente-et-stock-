import java.util.ArrayList;
import java.util.Scanner;
public class Produit {

    private String id;
    private String nom;
    private double prix;
    private int quantite;


    public Produit( String id, String nom, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    @Override
    public String toString() {
        return "ID : " + id +
                " | Nom : " + nom +
                " | Prix : " + prix + " FCFA" +
                " | Quantité : " + quantite;
    }

    //Methodes

    static ArrayList<Produit> produits = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void ajouterProduit() {
    }

    public static void modifierProduit() {
    }

    public static void supprimerProduit() {
    }

    public static void afficherProduits() {
    }

    public static Produit rechercherProduit(int id) {
        return null;
    }
}