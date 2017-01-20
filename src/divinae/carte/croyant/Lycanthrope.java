package divinae.carte.croyant;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
/**
 * Represente une carte croyant Lycanthrope.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Lycanthrope extends Croyant {

    public Lycanthrope( Dogme[] dogme, String cheminCarte) {
        super(Origine.NUIT, dogme,cheminCarte);
        this.setDescription("Sacrifice :\nRetirez tous les Croyants\n" +
                "attachés à l'un des Guides\n" +
                "Spirituels d'une autre\n" +
                "Divinité. Les Croyants\n" +
                "reviennent au milieu de la\n" +
                "table, le Guide Spirituel est\n" +
                "défaussé.");
        this.setNom("lycanthrope");
        this.setNbCroyant(4);
    }
    /**
     *Capacite de la carte croyant concernee, enleve les croyants d'un guide. Ceux-ci reviennent au centre.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur joueur, Partie partie) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(partie);
        Integer choixGuide = InterfaceCommand.choixGuide(choixJoueur,partie);
        choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).libCroyant(partie);
        partie.getDefausse().add(choixJoueur.getDivinite().getGuideDivinite().get(choixGuide));
        choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide);
    }
}
