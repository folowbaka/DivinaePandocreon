package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Lycanthrope extends Croyant {
    public Lycanthrope(Origine origine, Dogme[] dogme) {
        super(origine, dogme);
        this.setDescription("Sacrifice :\nRetirez tous les Croyants\n" +
                "attachés à l'un des Guides\n" +
                "Spirituels d'une autre\n" +
                "Divinité. Les Croyants\n" +
                "reviennent au milieu de la\n" +
                "table, le Guide Spirituel est\n" +
                "défaussé.");
    }
    public void capacite() {

    }
}
