package divinae.carte.croyant;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;
/**
 * Represente une carte croyant Revolutionnaire.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Revolutionnaire extends Croyant {

    public Revolutionnaire(Dogme[] dogme, String cheminCarte) {
        super(Origine.NEANT,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nImposez le sacrifice d'une\n" +
                "carte de Croyants à autant de\n" +
                "Divinités que vous le voulez.\n" +
                "Chaque Divinité choisit la\n" +
                "carte à sacrifier. Les capacités\n" +
                "spéciales sont jouées.");
        this.setNom("Revolutionnaire");
        this.setNbCroyant(2);
    }
    /**
     *Capacite de la carte croyant concernee, impose le sacrifice d'un croyant à autant de joueurs que l'on souhaite.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        Scanner sc=new Scanner(System.in);
        int nbJoueursSacrifice;
        System.out.println("A combien de joueurs voulez-vous faire sacrifier un croyant?");
        do{
            nbJoueursSacrifice = sc.nextInt();
            if (nbJoueursSacrifice<1 || nbJoueursSacrifice>p.getJoueur().size()){
                System.out.println("Nombre incorrect.");
            }
        }while(nbJoueursSacrifice<1 || nbJoueursSacrifice>p.getJoueur().size());

        for (int i =0; i<nbJoueursSacrifice; i++){
            Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
            int choixSacrificeGuide;
            int choixSacrificeCroyant;
            InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
            System.out.println("Entrez le croyant à sacrifier");
            choixSacrificeGuide=sc.nextInt()-1;
            choixSacrificeCroyant=sc.nextInt()-1;
            choixJoueur.sacrifierCroyant(choixSacrificeGuide,choixSacrificeCroyant,p);
        }

    }
}
