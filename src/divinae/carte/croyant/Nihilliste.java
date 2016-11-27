package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Nihilliste extends Croyant {
    public Nihilliste(Origine origine,String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nJusqu'à la fin du tour, plus\n" +
                "aucune Divinité ne reçoit de\n" +
                "points d'Action.\n");
    }
    public void capacite() {

    }
}
