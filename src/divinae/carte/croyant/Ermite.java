package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Ermite extends Croyant {
    public Ermite(Origine origine, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un\n" +
                "Croyant d'un autre joueur,\n" +
                "qui choisit la carte. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.");
    }
    public void capacite() {

    }
}
