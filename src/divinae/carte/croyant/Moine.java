package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Moine extends Croyant {
    public Moine(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
        this.setDescription("Sacrifice :\nDonne un point d'Action d'Origine Jour");
        this.setNbCroyant(2);
    }
    public void capacite() {
        /*if (joueur.peutSacrifier){
            joueur.pointJour++;
        }*/
    }
}
