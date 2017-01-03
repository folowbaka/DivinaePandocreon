package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Devin extends GuideSpirituel{

    public Devin(Origine origine, Dogme[] dogme,int nbMaxCroyant,Image imgCarte) {
        super(origine, dogme,nbMaxCroyant,imgCarte);
        this.setDescription("Sacrifice :\nOblige une Divinité ayant le\n" +
                "Dogme Nature ou Mystique\n" +
                "à sacrifier l'un de ses Guides\n" +
                "Spirituels.\n");
        this.setNom("Devin");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
