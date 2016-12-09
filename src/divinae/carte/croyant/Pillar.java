package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Pillar extends Croyant {
    public Pillar(Dogme[] dogme) {
        super(Origine.NUIT,dogme);
        this.setDescription("Sacrifice :\nRécupérez les points d'Action\n" +
                "d'une Divinité n'ayant pas\n" +
                "encore joué durant ce tour.\n" +
                "Les points d'Action gardent\n" +
                "leur Origine. La Divinité\n" +
                "perd ses points.\n");
        this.setNom("Pillard");
        this.setNbCroyant(4);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
