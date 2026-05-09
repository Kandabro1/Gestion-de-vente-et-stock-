import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choix;

        do {
            afficherMenu();

            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {

                case 1:
                    Produit.ajouterProduit();
                    break;

                case 2:
                    Produit.modifierProduit();
                    break;

                case 3:
                    Produit.supprimerProduit();
                    break;

                case 4:
                    Produit.afficherProduits();
                    break;

                case 5:
                    StockService.entreeStock();
                    break;

                case 6:
                    StockService.sortieStock();
                    break;

                case 7:
                    StockService.verifierStock();
                    break;

                case 8:
                    StockService.stockFaible();
                    break;

                case 9:
                    Vente.effectuerVente();
                    break;

                case 0:
                    System.out.println("Fermeture du programme...");
                    break;

                default:
                    System.out.println("Option invalide !");
            }

        } while (choix != 0);

        scanner.close();
    }

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
        System.out.println("9. Effectuer une vente");
        System.out.println("----------------------------------------");
        System.out.println("0. Quitter");
        System.out.println("========================================");
    }
}