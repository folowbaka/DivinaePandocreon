package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Miroir extends DeusEx {

    public Miroir(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Retourne les effets d'une carte\n" +
                "d'Action sur la Divinité qui\n" +
                "l'a posée");
        this.setNom("Miroir");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
