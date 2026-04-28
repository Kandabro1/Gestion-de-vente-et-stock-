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
}