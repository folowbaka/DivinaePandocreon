package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Ascete extends GuideSpirituel{
    public Ascete(Origine origine, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nSacrifie 2 cartes Croyants\n" +
                "d'une Divinité ayant le\n" +
                "Dogme Humain ou Symboles.\n" +
                "Les capacités spéciales sont\n" +
                "jouées normalement.\n");
    }

    @Override
    public void capacite() {

    }
}
