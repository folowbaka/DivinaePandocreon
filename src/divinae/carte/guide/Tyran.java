package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Tyran extends GuideSpirituel {
    public Tyran(Origine origine, Dogme[] dogme) {
        super(origine, dogme);
        this.setDescription("Sacrifice :\nDéfausse tous les Croyants\n" +
                "ayant le Dogme Mystique\n" +
                "actuellement au centre de la\n" +
                "table.\n");
        this.setNom("Tyran");
        this.setNbMaxCroyant(3);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
