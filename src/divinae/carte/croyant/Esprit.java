package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Esprit extends Croyant {
    public Esprit(Dogme[] dogme, Image imgCarte) {
        super(Origine.NEANT, dogme,imgCarte);
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
