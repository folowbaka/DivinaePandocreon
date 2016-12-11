package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Esprit extends Croyant {
    public Esprit(Dogme[] dogme) {
        super(Origine.NEANT, dogme);
        this.setDescription("Sacrifice :\nDonne un point d'Action\n" +
                "d'Origine Néant.");
        this.setNom("Esprit");
        this.setNbCroyant(2);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        j.ajoutPoints(1, "NEANT");
    }
}
