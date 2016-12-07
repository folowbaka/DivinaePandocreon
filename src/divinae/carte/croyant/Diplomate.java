package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Diplomate extends Croyant {
    public Diplomate(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
        this.setDescription("Sacrifice :\nRelancez le dé de Cosmogonie.\n" +
                "Le tour se finit normalement\n" +
                "sous la nouvelle influence.\n");
    }
    public void capacite() {

    }
}
