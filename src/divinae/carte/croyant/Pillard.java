package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Pillard extends Croyant {
    public Pillard(Dogme[] dogme, Image imgCarte) {
        super(Origine.NUIT,dogme,imgCarte);
        this.setDescription("Sacrifice :\nRécupérez les points d'Action\n" +
                "d'une Divinité n'ayant pas\n" +
                "encore joué durant ce tour.\n" +
                "Les points d'Action gardent\n" +
                "leur Origine. La Divinité\n" +
                "perd ses points.\n");
        this.setNom("Pillard");
        this.setNbCroyant(4);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        
    }
}
