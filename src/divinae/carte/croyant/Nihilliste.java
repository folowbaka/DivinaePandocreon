package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Nihilliste extends Croyant {

    public Nihilliste(Dogme[] dogme, Image imgCarte) {
        super(Origine.NEANT,dogme,imgCarte);
        this.setDescription("Sacrifice :\nJusqu'à la fin du tour, plus\n" +
                "aucune Divinité ne reçoit de\n" +
                "points d'Action.\n");
        this.setNom("Nihilliste");
        this.setNbCroyant(4);
    }

    public void capacite(Joueur j, Partie p) {
        for (int i = 0; i<p.getJoueur().size();i++){
            p.getJoueur().get(i).setPeutRecevoirPoint(false);
        }
    }
}
