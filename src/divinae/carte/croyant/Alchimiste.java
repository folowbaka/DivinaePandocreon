package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Alchimiste extends Croyant {
    public Alchimiste(Origine origine,String nom, Dogme dogme) {
        super(origine,nom, dogme);
        this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                "possédant le Dogme Humain\n" +
                "ou Mystique de sacrifier une\n" +
                "de ses cartes de Croyants\n" +
                "durant ce tour de jeu.");
    }
    public void capacite() {

    }
}
