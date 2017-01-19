package divinae.carte.abstractcarte;

import divinae.enumeration.*;
import javafx.scene.image.Image;

import java.util.Arrays;

/**
 * Représente une carte munie de dogmes, un tableau de dogmes.
 */
public abstract class CarteDogme  extends Carte{
    private Dogme[] dogme;

    /**
     * Constructeur d'une CarteDogme
     * @param origine
     * @param dogme
     * @param cheminCarte
     */
    public CarteDogme(Origine origine,Dogme[] dogme, String cheminCarte)
    {
        super(origine,cheminCarte);
        this.dogme=dogme;
    }

    /**
     * Retourne le dogme de la carte.
     * @return le dogme en question.
     */
    public Dogme[] getDogme() {
        return dogme;
    }

    /**
     * Affiche la carteDogme.
     * @return Les attributs de la carte en texte.
     */
    @Override
    public String toString() {
        return "CarteDogme{" +
                "dogme=" + Arrays.toString(dogme) +
                '}';
    }
}
