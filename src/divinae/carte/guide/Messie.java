package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Messie  extends GuideSpirituel{
    public Messie(Origine origine, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nLe joueur pose le dé de\n" +
                "Cosmogonie sur la face qu'il\n" +
                "désire et commence un\n" +
                "nouveau tour de jeu.\n");
    }

    @Override
    public void capacite() {

    }
}