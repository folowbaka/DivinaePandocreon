package divinae.carte.croyant;

import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Illusionniste extends Croyant {
    public Illusionniste(Origine origine, String description, String nom, Dogme dogme) {
        super(origine, description, nom, dogme);
    }
}
