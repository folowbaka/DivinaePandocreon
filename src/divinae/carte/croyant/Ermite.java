package divinae.carte.croyant;

import divinae.Joueur;
import Vue.InterfaceCommand;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;
/**
 * Represente une carte croyant Ermite.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Ermite extends Croyant {
    public Ermite( Dogme[] dogme, String  cheminCarte) {
        super(Origine.JOUR, dogme,cheminCarte);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un\n" +
                "Croyant d'un autre joueur,\n" +
                "qui choisit la carte. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.");
        this.setNom("Ermite");
        this.setNbCroyant(1);
    }
    /**
     *Capacite de la carte croyant concernee, impose le sacrifice d'un autre joueur.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        Scanner sc=new Scanner(System.in);
        int choixSacrificeGuide;
        int choixSacrificeCroyant;
        InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
        System.out.println("Entrez le croyant à sacrifier");
        choixSacrificeGuide=sc.nextInt()-1;
        choixSacrificeCroyant=sc.nextInt()-1;
        choixJoueur.sacrifierCroyant(choixSacrificeGuide,choixSacrificeCroyant,p);
    }
}
