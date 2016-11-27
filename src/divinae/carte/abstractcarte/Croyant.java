package divinae.carte.abstractcarte;

import divinae.Joueur;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public abstract class Croyant extends CarteDogme{
    public Croyant(Origine origine,String nom, Dogme dogme) {
        super(origine,nom, dogme);
    }
}
