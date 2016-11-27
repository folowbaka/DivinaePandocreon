package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Moine extends Croyant {
    public Moine(Origine origine, String description, String nom, Dogme dogme) {
        super(origine, description, nom, dogme);
    }

    @java.lang.Override
    public void sacrifice(Joueur joueur) {
        if (joueur.peutSacrifier){
            joueur.pointJour++;
        }
    }
}
