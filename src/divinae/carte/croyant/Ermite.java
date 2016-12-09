package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Ermite extends Croyant {
    public Ermite( Dogme[] dogme) {
        super(Origine.JOUR, dogme);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un\n" +
                "Croyant d'un autre joueur,\n" +
                "qui choisit la carte. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.");
        this.setNom("Ermite");
        this.setNbCroyant(1);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
