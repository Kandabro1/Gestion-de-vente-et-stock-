import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vente {

    private Client client;
    private Produit produit;
    private int quantite;
    private double total;
    private String dateVente;

    public Vente(Client client, Produit produit, int quantite) {
        this.client = client;
        this.produit = produit;
        this.quantite = quantite;
        this.total = produit.getPrix() * quantite;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dateVente = LocalDateTime.now().format(format);
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

    public String getDateVente() {
        return dateVente;
    }

    static ArrayList<Vente> ventes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void effectuerVente() {

        System.out.println("\n=== EFFECTUER UNE VENTE ===");

        System.out.print("Nom du client : ");
        String nom = scanner.nextLine();

        System.out.print("Téléphone du client : ");
        String telephone = scanner.nextLine();

        Client client = new Client(nom, telephone);

        System.out.print("ID du produit : ");
        String id = scanner.nextLine();

        Produit produit = Produit.rechercherProduit(id);

        if (produit == null) {
            System.out.println("Erreur : Produit introuvable !");
            return;
        }

        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();

        if (quantite <= 0) {
            System.out.println("Erreur : Quantité invalide !");
            return;
        }

        if (produit.getQuantite() < quantite) {
            System.out.println("Erreur : Stock insuffisant !");
            return;
        }

        produit.setQuantite(produit.getQuantite() - quantite);

        Vente vente = new Vente(client, produit, quantite);

        ventes.add(vente);

        fichier.enregistrerVente(
                vente.getDateVente(),
                vente.getClient().getNom(),
                vente.getClient().getTelephone(),
                vente.getProduit().getId(),
                vente.getProduit().getNom(),
                vente.getQuantite(),
                vente.getProduit().getPrix()
        );

        genererFacture(vente);
    }

    public static void genererFacture(Vente vente) {

        System.out.println("\n=== FACTURE ===");
        System.out.println("Date : " + vente.getDateVente());
        System.out.println("Client : " + vente.getClient().getNom());
        System.out.println("Téléphone : " + vente.getClient().getTelephone());
        System.out.println("Produit : " + vente.getProduit().getNom());
        System.out.println("ID Produit : " + vente.getProduit().getId());
        System.out.println("Quantité : " + vente.getQuantite());
        System.out.println("Prix unitaire : " + vente.getProduit().getPrix() + " FCFA");
        System.out.println("Total : " + vente.getTotal() + " FCFA");
        System.out.println("Merci !\n");
    }
}