package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Demon extends Croyant {
    public Demon(Dogme[] dogme) {

        super(Origine.NUIT,dogme);
        this.setDescription("Sacrifice :\nDonne un point d'Action\n" +
                "d'Origine Nuit.\n");
        this.setNom("Demon");
        this.setNbCroyant(2);
    }
    public void capacite() {

    }
}
