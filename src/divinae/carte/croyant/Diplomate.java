package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Diplomate extends Croyant {

    public Diplomate( Dogme[] dogme) {
        super(Origine.JOUR,dogme);
        this.setDescription("Sacrifice :\nRelancez le dé de Cosmogonie.\n" +
                "Le tour se finit normalement\n" +
                "sous la nouvelle influence.\n");
        this.setNom("Diplomate");
        this.setNbCroyant(4);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
