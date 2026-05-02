import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FichierUtil {
    
    private static final String FICHIER_VENTES = "ventes.txt";
    
    /**
     * Enregistre une vente dans le fichier ventes.txt
     * Cette méthode est appelée depuis Vente.effectuerVente()
     * 
     * @param clientNom    Nom du client
     * @param clientTel    Téléphone du client
     * @param produitId    ID du produit (String)
     * @param produitNom   Nom du produit
     * @param quantite     Quantité achetée
     * @param prix         Prix unitaire
     * @param total        Total de la vente
     */
    public static void enregistrerVente(String clientNom, String clientTel, String produitId, 
                                         String produitNom, int quantite, double prix, double total) {
        try (FileWriter writer = new FileWriter(FICHIER_VENTES, true)) {
            // Date et heure actuelles pour tracer la vente
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dateTime = LocalDateTime.now().format(formatter);
            
            // Format de la ligne sauvegardée dans le fichier
            String ligne = String.format("[%s] Client: %s | Tél: %s | ID: %s | %s | Qté: %d | Prix: %.0f FCFA | Total: %.0f FCFA%n",
                dateTime, clientNom, clientTel, produitId, produitNom, quantite, prix, total
            );
            
            writer.write(ligne);
            System.out.println("💾 Vente enregistrée dans " + FICHIER_VENTES);
            
        } catch (IOException e) {
            System.err.println("❌ Erreur lors de l'enregistrement de la vente: " + e.getMessage());
        }
    }
    
    /**
     * Affiche tout l'historique des ventes à partir du fichier ventes.txt
     */
    public static void afficherHistorique() {
        System.out.println("\n========== HISTORIQUE DES VENTES ==========");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_VENTES))) {
            String ligne;
            boolean aDesVentes = false;
            
            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);
                aDesVentes = true;
            }
            
            if (!aDesVentes) {
                System.out.println("Aucune vente enregistrée pour le moment.");
            }
            
            System.out.println("=============================================");
            
        } catch (FileNotFoundException e) {
            System.out.println("Aucune vente enregistrée pour le moment.");
        } catch (IOException e) {
            System.err.println("❌ Erreur lors de la lecture de l'historique: " + e.getMessage());
        }
    }
}