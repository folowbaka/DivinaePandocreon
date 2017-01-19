package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Demon extends Croyant {
    public Demon(Dogme[] dogme, String cheminCarte) {

        super(Origine.NUIT,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nDonne un point d'Action\n" +
                "d'Origine Nuit.\n");
        this.setNom("Demon");
        this.setNbCroyant(2);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        j.ajoutPoints(1, "NUIT");

    }
}
