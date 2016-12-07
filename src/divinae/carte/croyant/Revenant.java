package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Revenant extends Croyant {

    public Revenant(Dogme[] dogme) {
        super(Origine.NEANT,dogme);
        this.setDescription("Sacrifice :\nLancez le dé de Cosmogonie.\n" +
                "Le tour se fini normalement,\n" +
                "mais sous cette nouvelle\n" +
                "influence.");
        this.setNom("Revenant");
        this.setNbCroyant(1);
    }
    public void capacite() {

    }
}
