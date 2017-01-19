package divinae.carte.deusEx;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
/**
 * Represente une carte deusEx Diversion.
 * Sa capacite est defini dans la methode capacite.
 */
public class Diversion extends DeusEx {

    public Diversion(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Prenez 3 cartes dans la main\n" +
                "d'un autre joueur et\n" +
                "incluez-les à votre main.");
        this.setNom("Diversion");
    }
    /**
     *Capacite de la carte deusEx concernee.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        j.volerCarte(choixJoueur);
        j.volerCarte(choixJoueur);
        j.volerCarte(choixJoueur);
    }


}
