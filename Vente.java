import java.util.ArrayList;
import java.util.Scanner;

public class Vente {

    private Client client;
    private Produit produit;
    private int quantite;
    private double total;

    public Vente(Client client, Produit produit, int quantite) {
        this.client = client;
        this.produit = produit;
        this.quantite = quantite;
        this.total = produit.getPrix() * quantite;
    }

    public Client getClient() {
        return client;
    }

    public Produit getProduit() {
        return produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getTotal() {
        return total;
    }

    static ArrayList<Vente> ventes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void effectuerVente() {
        System.out.println("\n=== EFFECTUER UNE VENTE ===");

        System.out.print("Nom du client : ");
        String nomClient = scanner.nextLine();
        Client client = new Client(nomClient, "");

        System.out.print("ID du produit : ");
        int idProduit = scanner.nextInt();

        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();

        Produit produit = Produit.rechercherProduit(idProduit);
        if (produit == null) {
            System.out.println("Erreur : Produit introuvable !");
            return;
        }

        if (produit.getQuantite() < quantite) {
            System.out.println("Erreur : Stock insuffisant !");
            return;
        }

        produit.setQuantite(produit.getQuantite() - quantite);

        Vente vente = new Vente(client, produit, quantite);
        ventes.add(vente);
        genererFacture(vente);
    }

    public static void genererFacture(Vente vente) {
        System.out.println("\n=== FACTURE ===");
        System.out.println("Client : " + vente.getClient().getNom());
        System.out.println("Produit : " + vente.getProduit().getNom());
        System.out.println("Quantité : " + vente.getQuantite());
        System.out.println("Prix unitaire : " + vente.getProduit().getPrix());
        System.out.println("Total : " + vente.getTotal());
        System.out.println("Merci !\n");
    }
}