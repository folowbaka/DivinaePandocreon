package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class GuerrierSaint extends Croyant {
    public GuerrierSaint(Origine origine,Dogme[] dogme) {
        super(origine,dogme);
        this.setDescription("Sacrifice :\nUn Guide Spirituel revient\n" +
                "dans la main de sa Divinité.\n" +
                "Ses Croyants reviennent au\n" +
                "centre de la table.");
    }

    public void capacite() {

    }
}
