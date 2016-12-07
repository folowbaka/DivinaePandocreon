package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Shaman extends GuideSpirituel {
    public Shaman(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
        this.setDescription("Sacrifice :\nSacrifie tous les Croyants\n" +
                "d'Origine Néant d'une\n" +
                "Divinité ayant le Dogme\n" +
                "Humain. Les capacités\n" +
                "spécials sont jouées\n" +
                "normalement.\n");
        this.setNom("Shaman");
        this.setNbMaxCroyant(3);
    }

    public void capacite() {

    }
}
