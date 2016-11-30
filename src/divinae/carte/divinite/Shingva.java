package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Shingva extends Divinite {

    public Shingva(Origine origine, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescriptionDivinite("Perverse et retorse, Shingva est une Divinité que toutes les autres détestent.\n");
        this.setDescription("Peut imposer le sacrifice d'un Guide Spirituel ayant le Dogme Symboles ou Nature.");
    }

    @Override
    public void capacite() {

    }
}
