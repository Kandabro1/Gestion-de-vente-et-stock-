import java.util.ArrayList;
import java.util.Scanner;

public class StockService {

    static Scanner scanner = new Scanner(System.in);

    // Option 5 : Entrée en stock
    public static void entreeStock() {

        System.out.print("ID du produit : ");
        String id = scanner.nextLine();

        Produit p = Produit.rechercherProduit(id);

        if (p == null) {
            System.out.println("Erreur : Produit introuvable !");
            return;
        }

        System.out.print("Quantité à ajouter : ");
        int qte = scanner.nextInt();
        scanner.nextLine();

        if (qte <= 0) {
            System.out.println("Erreur : La quantité doit être positive !");
            return;
        }

        p.setQuantite(p.getQuantite() + qte);

        System.out.println("Entrée en stock effectuée.");
        System.out.println("Nouveau stock de " + p.getNom() + " : " + p.getQuantite());
    }

    // Option 6 : Sortie de stock
    public static void sortieStock() {

        System.out.print("ID du produit : ");
        String id = scanner.nextLine();

        Produit p = Produit.rechercherProduit(id);

        if (p == null) {
            System.out.println("Erreur : Produit introuvable !");
            return;
        }

        System.out.print("Quantité à retirer : ");
        int qte = scanner.nextInt();
        scanner.nextLine();

        if (qte <= 0) {
            System.out.println("Erreur : La quantité doit être positive !");
            return;
        }

        if (p.getQuantite() < qte) {
            System.out.println("Erreur : Stock insuffisant !");
            System.out.println("Stock actuel : " + p.getQuantite());
            return;
        }

        p.setQuantite(p.getQuantite() - qte);

        System.out.println("Sortie de stock effectuée.");
        System.out.println("Nouveau stock de " + p.getNom() + " : " + p.getQuantite());
    }

    // Option 7 : Vérifier le stock
    public static void verifierStock() {

        System.out.print("ID du produit : ");
        String id = scanner.nextLine();

        Produit p = Produit.rechercherProduit(id);

        if (p == null) {
            System.out.println("Erreur : Produit introuvable !");
            return;
        }

        System.out.println("Produit : " + p.getNom());
        System.out.println("Stock disponible : " + p.getQuantite());
    }

    // Option 8 : Produits en stock faible
    public static void stockFaible() {

        System.out.print("Seuil de stock : ");
        int seuil = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Produit> produits = Produit.produits;

        boolean trouve = false;

        System.out.println("\n=== PRODUITS EN STOCK FAIBLE ===");

        for (Produit p : produits) {

            if (p.getQuantite() < seuil) {

                System.out.println(
                    "ID : " + p.getId() +
                    " | Nom : " + p.getNom() +
                    " | Stock : " + p.getQuantite()
                );

                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("Aucun produit sous le seuil.");
        }
    }
}