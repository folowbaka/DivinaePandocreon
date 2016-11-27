package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Pillar extends Croyant {
    public Pillar(Origine origine,String nom, Dogme dogme) {
        super(origine,nom, dogme);
        this.setDescription("Sacrifice :\nRécupérez les points d'Action\n" +
                "d'une Divinité n'ayant pas\n" +
                "encore joué durant ce tour.\n" +
                "Les points d'Action gardent\n" +
                "leur Origine. La Divinité\n" +
                "perd ses points.\n");
    }
    public void capacite() {

    }
}
