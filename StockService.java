import java.util.ArrayList;
import java.util.Scanner;

public class StockService {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Option 5 : Entree en stock
     */
    public static void entreeStock() {
        System.out.print("ID du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produit p = ProduitService.rechercherProduit(id);

        if (p == null) {
            System.out.println("Erreur : Produit introuvable !");
            return;
        }

        System.out.print("Quantite a ajouter : ");
        int qte = scanner.nextInt();
        scanner.nextLine();

        if (qte <= 0) {
            System.out.println("Erreur : La quantite doit etre positive !");
            return;
        }

        p.setQuantite(p.getQuantite() + qte);
        System.out.println("Entree en stock effectuee. Nouveau stock : " + p.getQuantite());
    }

    /**
     * Option 6 : Sortie de stock
     */
    public static void sortieStock() {
        System.out.print("ID du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produit p = ProduitService.rechercherProduit(id);

        if (p == null) {
            System.out.println("Erreur : Produit introuvable !");
            return;
        }

        System.out.print("Quantite a retirer : ");
        int qte = scanner.nextInt();
        scanner.nextLine();

        if (qte <= 0) {
            System.out.println("Erreur : La quantite doit etre positive !");
            return;
        }

        if (p.getQuantite() >= qte) {
            p.setQuantite(p.getQuantite() - qte);
            System.out.println("Sortie de stock effectuee. Nouveau stock : " + p.getQuantite());
        } else {
            System.out.println("Erreur : Stock insuffisant ! Stock actuel : " + p.getQuantite());
        }
    }

    /**
     * Option 7 : Verifier le stock d'un produit
     */
    public static void verifierStock() {
        System.out.print("ID du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produit p = ProduitService.rechercherProduit(id);

        if (p == null) {
            System.out.println("Erreur : Produit introuvable !");
        } else {
            System.out.println("Stock de " + p.getNom() + " : " + p.getQuantite() + " unites");
        }
    }

    /**
     * Option 8 : Produits en stock faible
     */
    public static void stockFaible() {
        System.out.print("Seuil de stock (exemple : 5) : ");
        int seuil = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Produit> produits = ProduitService.produits;

        System.out.println("\nProduits avec stock < " + seuil + " :");
        System.out.println("----------------------------------------");
        boolean trouve = false;

        for (Produit p : produits) {
            if (p.getQuantite() < seuil) {
                System.out.println("   - " + p.getNom() + " (stock : " + p.getQuantite() + ")");
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("Aucun produit sous le seuil");
        }
        System.out.println("----------------------------------------");
    }
}
