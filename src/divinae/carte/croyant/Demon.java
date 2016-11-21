package divinae.carte.croyant;

import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Demon extends Croyant {
    public Demon(Origine origine, String description, String nom, Dogme dogme) {
        super(origine, description, nom, dogme);
    }
}
