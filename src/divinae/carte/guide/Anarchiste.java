package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Anarchiste extends GuideSpirituel {
    public Anarchiste(Origine origine, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice : \nSacrifie un Guide Spirituel, si\n" +
                "lui ou sa Divinité ne croit pas\n" +
                "au Dogme Chaos. Les\n" +
                "capacités spéciales sont jouées\n" +
                "normalement.\n");
    }

    @Override
    public void capacite() {

    }
}
