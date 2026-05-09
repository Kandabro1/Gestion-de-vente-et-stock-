import java.util.ArrayList;
import java.util.Scanner;

public class Produit {

    private String id;
    private String nom;
    private double prix;
    private int quantite;

    static ArrayList<Produit> produits = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Produit(String id, String nom, double prix, int quantite) {
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

    public static void ajouterProduit() {

        System.out.println("\n=== AJOUTER UN PRODUIT ===");

        System.out.print("ID du produit : ");
        String id = scanner.nextLine();

        for (Produit p : produits) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("Erreur : ID déjà existant.");
                return;
            }
        }

        System.out.print("Nom du produit : ");
        String nom = scanner.nextLine();

        System.out.print("Prix : ");
        double prix = scanner.nextDouble();

        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();

        Produit produit = new Produit(id, nom, prix, quantite);

        produits.add(produit);

        System.out.println("Produit ajouté avec succès.");
    }

    public static void modifierProduit() {

        System.out.println("\n=== MODIFIER UN PRODUIT ===");

        System.out.print("ID du produit : ");
        String id = scanner.nextLine();

        Produit produit = rechercherProduit(id);

        if (produit == null) {
            System.out.println("Produit introuvable.");
            return;
        }

        System.out.print("Nouveau nom : ");
        String nom = scanner.nextLine();

        System.out.print("Nouveau prix : ");
        double prix = scanner.nextDouble();

        System.out.print("Nouvelle quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();

        produit.setNom(nom);
        produit.setPrix(prix);
        produit.setQuantite(quantite);

        System.out.println("Produit modifié avec succès.");
    }

    public static void supprimerProduit() {

        System.out.println("\n=== SUPPRIMER UN PRODUIT ===");

        System.out.print("ID du produit : ");
        String id = scanner.nextLine();

        Produit produit = rechercherProduit(id);

        if (produit == null) {
            System.out.println("Produit introuvable.");
            return;
        }

        produits.remove(produit);

        System.out.println("Produit supprimé avec succès.");
    }

    public static void afficherProduits() {

        System.out.println("\n=== LISTE DES PRODUITS ===");

        if (produits.isEmpty()) {
            System.out.println("Aucun produit enregistré.");
            return;
        }

        for (Produit produit : produits) {
            System.out.println(produit);
        }
    }

    public static Produit rechercherProduit(String id) {

        for (Produit produit : produits) {
            if (produit.getId().equalsIgnoreCase(id)) {
                return produit;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "ID : " + id +
                " | Nom : " + nom +
                " | Prix : " + prix + " FCFA" +
                " | Quantité : " + quantite;
    }
}