package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.ArrayList;

public abstract class Divinite extends CarteDogme {
    private String descriptionDivinite;
    private ArrayList<GuideSpirituel> guideDivinite;

    public Divinite(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
    }

    public void setDescriptionDivinite(String descriptionDivinite) {
        this.descriptionDivinite = descriptionDivinite;
        this.guideDivinite=new ArrayList<GuideSpirituel>();
    }

    public ArrayList<GuideSpirituel> getGuideDivinite()
    {
        return this.guideDivinite;
    }
    public String toString() {
        return "Divinite{" +
                "descriptionDivinite='" + descriptionDivinite + '\'' +
                '}';
    }
}
