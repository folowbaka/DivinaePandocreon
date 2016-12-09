package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Messie  extends GuideSpirituel{
    public Messie(Origine origine, Dogme[] dogme) {
        super(origine, dogme);
        this.setDescription("Sacrifice :\nLe joueur pose le dé de\n" +
                "Cosmogonie sur la face qu'il\n" +
                "désire et commence un\n" +
                "nouveau tour de jeu.\n");
        this.setNom("Messie");
        this.setNbMaxCroyant(3);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}