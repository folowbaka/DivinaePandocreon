package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public abstract class GuideSpirituel extends CarteDogme {
    public GuideSpirituel(Origine origine, String nom, Dogme dogme) {
        super(origine,nom, dogme);
    }
}
