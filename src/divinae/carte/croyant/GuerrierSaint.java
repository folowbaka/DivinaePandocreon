package divinae.carte.croyant;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class GuerrierSaint extends Croyant {

    public GuerrierSaint(Dogme[] dogme) {
        super(Origine.JOUR,dogme);
        this.setDescription("Sacrifice :\nUn Guide Spirituel revient\n" +
                "dans la main de sa Divinité.\n" +
                "Ses Croyants reviennent au\n" +
                "centre de la table.");
        this.setNom("Guerrier Saint");
        this.setNbCroyant(4);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        int choixGuide = InterfaceCommand.choixGuide(choixJoueur, p);
        choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).libCroyant(choixJoueur,p);
        choixJoueur.getMain().add(choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide));
    }

}
