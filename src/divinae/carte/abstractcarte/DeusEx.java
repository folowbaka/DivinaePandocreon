package divinae.carte.abstractcarte;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;


/**
 * Represente une carte DeusEx.
 */
public abstract class DeusEx extends Carte{

    /**
     * Constructeur de DeusEx
     * @param origine
     * @param cheminCarte
     */
    public DeusEx(Origine origine, String cheminCarte) {
        super(origine,cheminCarte);
    }
}
