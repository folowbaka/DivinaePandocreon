package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Devin extends GuideSpirituel{

    public Devin(Origine origine, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nOblige une Divinité ayant le\n" +
                "Dogme Nature ou Mystique\n" +
                "à sacrifier l'un de ses Guides\n" +
                "Spirituels.\n");
    }

    @Override
    public void capacite() {

    }
}
