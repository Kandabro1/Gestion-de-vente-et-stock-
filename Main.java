import java.util.Scanner;

public class Main {

    // Scanner global pour tout le programme
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choix;

        do {
            afficherMenu();

            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // vider le buffer

            switch (choix) {

                //PRODUITS
                case 1:
                    ajouterProduit();
                    break;

                case 2:
                    modifierProduit();
                    break;

                case 3:
                    supprimerProduit();
                    break;

                case 4:
                    afficherProduits();
                    break;

                //STOCK
                case 5:
                    entreeStock();
                    break;

                case 6:
                    sortieStock();
                    break;

                case 7:
                    verifierStock();
                    break;

                case 8:
                    stockFaible();
                    break;

                //VENTE
                case 11:
                    effectuerVente();
                    break;

                //QUITTER
                case 0:
                    System.out.println("Fermeture du programme...");
                    break;

                //ERREUR
                default:
                    System.out.println("Option invalide ! Veuillez réessayer.");
            }

        } while (choix != 0);

        scanner.close();
    }

    // MENU PRINCIPAL
    public static void afficherMenu() {

        System.out.println("\n========================================");
        System.out.println("   SYSTÈME DE GESTION DE VENTE & STOCK");
        System.out.println("========================================");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Voir la liste des produits");
        System.out.println("----------------------------------------");
        System.out.println("5. Enregistrer une entrée en stock");
        System.out.println("6. Enregistrer une sortie en stock");
        System.out.println("7. Vérifier le stock disponible");
        System.out.println("8. Produits en rupture / stock faible");
        System.out.println("----------------------------------------");
        System.out.println("11. Effectuer une vente");
        System.out.println("----------------------------------------");
        System.out.println("0. Quitter");
        System.out.println("========================================");
    }

    // PRODUITS

    // Option 1
    public static void ajouterProduit() {
        ProduitService.ajouterProduit();
    }

    // Option 2
    public static void modifierProduit() {
        ProduitService.modifierProduit();
    }

    // Option 3
    public static void supprimerProduit() {
        ProduitService.supprimerProduit();
    }

    // Option 4
    public static void afficherProduits() {
        ProduitService.afficherProduits();
    }

    // STOCK

    // Option 5
    public static void entreeStock() {
        StockService.entreeStock();
    }

    // Option 6
    public static void sortieStock() {
        StockService.sortieStock();
    }

    // Option 7
    public static void verifierStock() {
        StockService.verifierStock();
    }

    // Option 8
    public static void stockFaible() {
        StockService.stockFaible();
    }

    // VENTE

    // Option 11
    public static void effectuerVente() {
        VenteService.effectuerVente();
    }
}