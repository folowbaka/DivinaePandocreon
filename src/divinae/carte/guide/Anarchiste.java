package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Anarchiste extends GuideSpirituel {
    public Anarchiste(Origine origine, Dogme[] dogme) {
        super(origine, dogme);
        this.setDescription("Sacrifice : \nSacrifie un Guide Spirituel, si\n" +
                "lui ou sa Divinité ne croit pas\n" +
                "au Dogme Chaos. Les\n" +
                "capacités spéciales sont jouées\n" +
                "normalement.\n");
        this.setNom("Anarchiste");
        this.setNbMaxCroyant(3);
    }

    @Override
    public void capacite() {

    }
}
