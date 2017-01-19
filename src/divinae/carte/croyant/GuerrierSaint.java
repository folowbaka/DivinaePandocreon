package divinae.carte.croyant;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
/**
 * Represente une carte croyant GuerrierSaint.
 * Son sacrifice est defini dans la methode capacite.
 */
public class GuerrierSaint extends Croyant {

    public GuerrierSaint(Dogme[] dogme, String cheminCarte) {
        super(Origine.JOUR,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nUn Guide Spirituel revient\n" +
                "dans la main de sa Divinité.\n" +
                "Ses Croyants reviennent au\n" +
                "centre de la table.");
        this.setNom("Guerrier Saint");
        this.setNbCroyant(4);
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
    public void capacite(Joueur joueur, Partie partie) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(partie);
        int choixGuide = InterfaceCommand.choixGuide(choixJoueur, partie);
        choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).libCroyant(partie);
        choixJoueur.getMain().add(choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide));
    }

}
