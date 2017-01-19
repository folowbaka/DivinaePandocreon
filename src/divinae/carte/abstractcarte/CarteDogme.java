package divinae.carte.abstractcarte;

import divinae.enumeration.*;
import javafx.scene.image.Image;

import java.util.Arrays;

public abstract class CarteDogme  extends Carte{
    private Dogme[] dogme;
    public CarteDogme(Origine origine,Dogme[] dogme, String cheminCarte)
    {
        super(origine,cheminCarte);
        this.dogme=dogme;
    }

    public Dogme[] getDogme() {
        return dogme;
    }

    @Override
    public String toString() {
        return "CarteDogme{" +
                "dogme=" + Arrays.toString(dogme) +
                '}';
    }
}
