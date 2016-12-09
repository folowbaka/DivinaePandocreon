package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Ascete extends GuideSpirituel{
    public Ascete(Origine origine,Dogme[] dogme) {
        super(origine,dogme);
        this.setDescription("Sacrifice :\nSacrifie 2 cartes Croyants\n" +
                "d'une Divinité ayant le\n" +
                "Dogme Humain ou Symboles.\n" +
                "Les capacités spéciales sont\n" +
                "jouées normalement.\n");
        this.setNom("Ascete");
        this.setNbMaxCroyant(1);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
