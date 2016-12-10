package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Anarchiste extends GuideSpirituel {
    public Anarchiste(Origine origine, Dogme[] dogme,int nbMaxCroyant) {
        super(origine, dogme,nbMaxCroyant);
        this.setDescription("Sacrifice : \nSacrifie un Guide Spirituel, si\n" +
                "lui ou sa Divinité ne croit pas\n" +
                "au Dogme Chaos. Les\n" +
                "capacités spéciales sont jouées\n" +
                "normalement.\n");
        this.setNom("Anarchiste");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
