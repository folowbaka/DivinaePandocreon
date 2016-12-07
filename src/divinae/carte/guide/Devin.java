package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Devin extends GuideSpirituel{

    public Devin(Origine origine, Dogme[] dogme) {
        super(origine, dogme);
        this.setDescription("Sacrifice :\nOblige une Divinité ayant le\n" +
                "Dogme Nature ou Mystique\n" +
                "à sacrifier l'un de ses Guides\n" +
                "Spirituels.\n");
        this.setNom("Devin");
        this.setNbMaxCroyant(1);
    }

    @Override
    public void capacite() {

    }
}
