package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Moine extends Croyant {
    public Moine(Dogme[] dogme, String cheminCarte) {
        super(Origine.JOUR,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nDonne un point d'Action d'Origine Jour");
        this.setNom("Moine");
        this.setNbCroyant(2);
    }
    public void capacite(Joueur joueur, Partie p) {
        joueur.ajoutPoints(1, "JOUR");
    }

}
