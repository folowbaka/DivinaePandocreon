package divinae;

import java.util.Scanner;

/**
 * Created by david on 21/11/2016.
 */
public class DivinaePandocreon {

    public static void main(String[] args) {
        boolean creerpartie = false;
        Scanner choixUtilisateur = new Scanner(System.in);
        int choix;
        do {
            System.out.println("----------DIVINAE PANDOCREON----------\n----------1-Créer Partie\n----------0-Exit");
            choix = choixUtilisateur.nextInt();
        } while (choix > 1 || choix < 0);

        switch(choix)
        {
            case 1:
                Partie partie = Partie.getInstance();
                break;
            default:
                System.out.println("A la prochaine");
                return;

        }
        return;
    }
}
