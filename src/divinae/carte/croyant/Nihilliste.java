package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Nihilliste extends Croyant {

    public Nihilliste(Dogme[] dogme) {
        super(Origine.NEANT,dogme);
        this.setDescription("Sacrifice :\nJusqu'à la fin du tour, plus\n" +
                "aucune Divinité ne reçoit de\n" +
                "points d'Action.\n");
        this.setNom("Nihilliste");
        this.setNbCroyant(4);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
