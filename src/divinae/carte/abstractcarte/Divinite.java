package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public abstract class Divinite extends CarteDogme {
    private String descriptionDivinite;

    public Divinite(Origine origine,String nom, Dogme dogme) {
        super(origine, nom, dogme);
    }

    public void setDescriptionDivinite(String descriptionDivinite) {
        this.descriptionDivinite = descriptionDivinite;
    }
}
