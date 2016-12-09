package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Alchimiste extends Croyant {

    public Alchimiste(Dogme[] dogme) {
        super(Origine.NUIT, dogme);
        this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                "possédant le Dogme Humain\n" +
                "ou Mystique de sacrifier une\n" +
                "de ses cartes de Croyants\n" +
                "durant ce tour de jeu.");
        this.setNom("Alchimiste");
        this.setNbCroyant(2);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
