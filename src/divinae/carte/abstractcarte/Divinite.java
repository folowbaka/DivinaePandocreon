package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public abstract class Divinite extends CarteDogme {

    public Divinite(Origine origine, String description, String nom, Dogme dogme) {
        super(origine, description, nom, dogme);
    }
}
