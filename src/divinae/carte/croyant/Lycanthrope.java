package divinae.carte.croyant;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Lycanthrope extends Croyant {

    public Lycanthrope( Dogme[] dogme, Image imgCarte) {
        super(Origine.NUIT, dogme,imgCarte);
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
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        Integer choixGuide = InterfaceCommand.choixGuide(choixJoueur,p);
        choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).libCroyant(choixJoueur,p);
        p.getDefausse().add(choixJoueur.getDivinite().getGuideDivinite().get(choixGuide));
        choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide);
    }
}
