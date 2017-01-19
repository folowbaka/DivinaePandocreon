package divinae;

import Vue.InterfaceCommand;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * L'application en affiche commande.
 */
public class DivinaePandocreonCommande {

    /**
     * Ensemble de partie en commande.
     */
    public  DivinaePandocreonCommande() {
        boolean creerpartie = false;
        Scanner choixUtilisateur = new Scanner(System.in);
        int choix = -1;
        do {
            System.out.println("----------DIVINAE PANDOCREON----------\n----------1-Créer Partie\n----------0-Exit");
            try {
                choix = choixUtilisateur.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erreur de saisie,Veuillez réessayer");
                choixUtilisateur.next();

            }
        } while (choix > 1 || choix < 0);

        switch (choix) {
            case 1:

                Partie partie = Partie.getInstance(InterfaceCommand.choisirJoueur());
                partie.commencerPartie();
                break;
            default:
                System.out.println("A la prochaine");
                return;

        }
        return;
    }

}