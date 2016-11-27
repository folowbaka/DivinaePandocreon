package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Moine extends Croyant {
    public Moine(Origine origine, String description, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nDonne un point d'Action d'Origine Jour");
    }

    public void capacite() {
        /*if (joueur.peutSacrifier){
            joueur.pointJour++;
        }*/
    }
}
