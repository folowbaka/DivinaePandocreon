package divinae.carte.croyant;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;
/**
 * Represente une carte croyant Integriste.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Integriste extends Croyant {
    public Integriste(Dogme[] dogme, String cheminCarte) {
        super(Origine.JOUR,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un Guide\n" +
                "Spirituel d'un autre joueur,\n" +
                "qui choisit la carte. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.\n");
        this.setNom("Integriste");
        this.setNbCroyant(1);
    }
    /**
     *Capacite de la carte croyant concernee.
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
        InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
        System.out.println("Entrez le guide à sacrifier");
        choixSacrificeGuide=sc.nextInt()-1;
        choixJoueur.sacrifierGuide(choixSacrificeGuide,p);
    }
}
