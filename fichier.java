import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fichier {

    private static final String NOM_FICHIER = "ventes.txt";

    public static void enregistrerVente(
            String date,
            String nom,
            String telephone,
            String id,
            String produit,
            int quantite,
            double prix) {

        double total = quantite * prix;

        try {
            FileWriter writer = new FileWriter(NOM_FICHIER, true);

            writer.write("=====================================\n");
            writer.write("Date : " + date + "\n");
            writer.write("Client : " + nom + "\n");
            writer.write("Téléphone : " + telephone + "\n");
            writer.write("ID Produit : " + id + "\n");
            writer.write("Produit : " + produit + "\n");
            writer.write("Quantité : " + quantite + "\n");
            writer.write("Prix Unitaire : " + prix + " FCFA\n");
            writer.write("Total : " + total + " FCFA\n");
            writer.write("=====================================\n\n");

            writer.close();

            System.out.println("Vente enregistrée dans ventes.txt avec succès.");

        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }

    public static void afficherHistorique() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(NOM_FICHIER));

            String ligne;

            System.out.println("\n========== HISTORIQUE DES VENTES ==========\n");

            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}