package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Vampire extends Croyant {
    public Vampire( Dogme[] dogme) {
        super(Origine.NUIT,dogme);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un\n" +
                "Croyant d'un autre joueur.\n" +
                "Celui-ci choisit le sacrifié. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.\n");
        this.setNom("Vampire");
        this.setNbCroyant(1);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
