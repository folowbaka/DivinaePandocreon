package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Tyran extends GuideSpirituel {
    public Tyran(Origine origine, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nDéfausse tous les Croyants\n" +
                "ayant le Dogme Mystique\n" +
                "actuellement au centre de la\n" +
                "table.\n");
    }

    @Override
    public void capacite() {

    }
}
