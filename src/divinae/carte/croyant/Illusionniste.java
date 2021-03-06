package divinae.carte.croyant;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;
/**
 * Represente une carte croyant Illusioniste.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Illusionniste extends Croyant {
    public Illusionniste(Dogme[] dogme, String cheminCarte) {
        super(Origine.NUIT,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nVous bénéficiez de la capacité\n" +
                "spéciale de sacrifice d'une\n" +
                "carte de Croyants\n" +
                "appartenant à une autre\n" +
                "Divinité. La carte en question\n" +
                "reste en jeu.\n");
        this.setNom("Illusionniste");
        this.setNbCroyant(4);
    }
    /**
     *Capacite de la carte croyant concernee, vole la capacite d'un autre croyant.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
        int choixSacrificeGuide;
        int choixSacrificeCroyant;
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le guide possédant le croyant à utiliser.");
        choixSacrificeGuide = sc.nextInt()-1;
        System.out.println("Entrez le croyant à utiliser.");
        choixSacrificeCroyant = sc.nextInt() - 1;
        choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getCroyantRattache()[choixSacrificeCroyant].capacite(j,p);

    }
}
