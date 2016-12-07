package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Martyr extends GuideSpirituel {
    public Martyr(Origine origine, Dogme[] dogme) {
        super(origine, dogme);
        this.setDescription("Sacrifice :\nEquivalent à la pose d'une\n" +
                "carte Apocalypse.\n");
    }
    public void capacite() {

    }
}
