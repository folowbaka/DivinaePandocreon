package divinae.carte;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Carte;
import divinae.enumeration.Origine;

public class Apocalypse extends Carte {

    public Apocalypse(Origine origine) {
        super(origine);
        this.setNom("Apocalypse");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
