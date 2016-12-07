package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Esprit extends Croyant {
    public Esprit(Origine origine, Dogme[] dogme) {
        super(origine, dogme);
        this.setDescription("Sacrifice :\nDonne un point d'Action\n" +
                "d'Origine Néant.");
    }
    public void capacite() {

    }
}
