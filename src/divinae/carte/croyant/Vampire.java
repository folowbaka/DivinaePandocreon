package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Vampire extends Croyant {
    public Vampire(Origine origine,String nom, Dogme dogme) {
        super(origine,nom, dogme);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un\n" +
                "Croyant d'un autre joueur.\n" +
                "Celui-ci choisit le sacrifié. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.\n");
    }
    public void capacite() {

    }
}
