import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FichierUtil {

    private static final String FICHIER_VENTES = "ventes.txt";

    /**
     * Enregistre les informations d'une vente dans le fichier ventes.txt
     */
    public static void enregistrerVente(String clientNom, String clientTel, int produitId,
                                        String produitNom, int quantite, double prix, double total) {
        try (FileWriter writer = new FileWriter(FICHIER_VENTES, true)) {

            // Date et heure de la vente
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dateTime = LocalDateTime.now().format(formatter);

            // Ligne formatée
            String ligne = String.format(
                    "[%s] %s | Tél: %s | ID: %d | %s | Qté: %d | Prix: %.2f XAF | Total: %.2f EUR%n",
                    dateTime, clientNom, clientTel, produitId, produitNom, quantite, prix, total
            );

            writer.write(ligne);
            System.out.println("💾 Vente enregistrée dans " + FICHIER_VENTES);

        } catch (IOException e) {
            System.err.println("❌ Erreur lors de l'enregistrement: " + e.getMessage());
        }
    }

    /**
     * Affiche l'historique des ventes
     */
    public static void afficherHistorique() {
        System.out.println("\n--- HISTORIQUE DES VENTES ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_VENTES))) {

            String ligne;
            boolean aDesVentes = false;

            System.out.println("\n" + "=".repeat(80));

            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);
                aDesVentes = true;
            }

            System.out.println("=".repeat(80));

            if (!aDesVentes) {
                System.out.println("📋 Aucune vente enregistrée pour le moment.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("📋 Aucune vente enregistrée pour le moment.");
        } catch (IOException e) {
            System.err.println("❌ Erreur lors de la lecture: " + e.getMessage());
        }
    }
}