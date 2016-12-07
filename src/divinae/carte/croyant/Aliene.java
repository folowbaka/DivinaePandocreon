package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Aliene extends Croyant {
    public Aliene(Origine origine,Dogme[] dogme) {
        super(origine,dogme);
        this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                "possédant le Dogme Nature\n" +
                "ou Mystique de sacrifier une\n" +
                "de ses cartes de Croyants\n" +
                "durant ce tour de jeu.");
    }
    public void capacite() {

    }
}
