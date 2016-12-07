package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public abstract class Divinite extends CarteDogme {
    private String descriptionDivinite;

    public Divinite(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
    }

    public void setDescriptionDivinite(String descriptionDivinite) {
        this.descriptionDivinite = descriptionDivinite;
    }

    public String toString() {
        return "Divinite{" +
                "descriptionDivinite='" + descriptionDivinite + '\'' +
                '}';
    }
}
