package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Shaman extends GuideSpirituel {
    public Shaman(Origine origine, Dogme[] dogme,int nbMaxCroyant,Image imgCarte) {
        super(origine,dogme,nbMaxCroyant,imgCarte);
        this.setDescription("Sacrifice :\nSacrifie tous les Croyants\n" +
                "d'Origine Néant d'une\n" +
                "Divinité ayant le Dogme\n" +
                "Humain. Les capacités\n" +
                "spécials sont jouées\n" +
                "normalement.\n");
        this.setNom("Shaman");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
