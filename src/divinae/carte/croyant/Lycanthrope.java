package divinae.carte.croyant;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

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

    @Override
    public void capacite(Joueur joueur, Partie partie) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(partie);
        Integer choixGuide = InterfaceCommand.choixGuide(choixJoueur,partie);
        choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).libCroyant(partie);
        partie.getDefausse().add(choixJoueur.getDivinite().getGuideDivinite().get(choixGuide));
        choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide);
    }
}
