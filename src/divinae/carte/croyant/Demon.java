package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Demon extends Croyant {
    public Demon(Origine origine,String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nDonne un point d'Action\n" +
                "d'Origine Nuit.\n");
    }
    public void capacite() {

    }
}
