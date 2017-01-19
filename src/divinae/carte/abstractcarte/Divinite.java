package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Represente une divinite.
 */
public abstract class Divinite extends CarteDogme {
    private String descriptionDivinite;
    private ArrayList<GuideSpirituel> guideDivinite;

    /**
     * Constructeur de Divinite.
     * @param origine
     * @param dogme
     * @param cheminCarte
     */
    public Divinite(Origine origine, Dogme[] dogme,String cheminCarte) {
        super(origine,dogme,cheminCarte);
    }

    /**
     * Modifie la description de la divinite.
     * @param descriptionDivinite
     */
    public void setDescriptionDivinite(String descriptionDivinite) {
        this.descriptionDivinite = descriptionDivinite;
        this.guideDivinite=new ArrayList<GuideSpirituel>();
    }

    /**
     * Retourne la liste de guides associe a la divinite.
     * @return une liste de guides spirituels
     * @see GuideSpirituel
     */
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
