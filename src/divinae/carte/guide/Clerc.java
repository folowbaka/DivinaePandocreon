package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Clerc extends GuideSpirituel {
    public Clerc(Origine origine, Dogme[] dogme,int nbMaxCroyant) {
        super(origine,dogme,nbMaxCroyant);
        this.setDescription("Sacrifice :\n" +
                "Fait gagner un nombre de\n" +
                "points d'Action égal au\n" +
                "nombre de cartes de Croyants\n" +
                "rattachées. L'Origine des\n" +
                "points d'Action est au choix\n" +
                "du joueur.\n");
        this.setNom("Clerc");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
