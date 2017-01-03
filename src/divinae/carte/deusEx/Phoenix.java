package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Phoenix extends DeusEx {

    public Phoenix(Origine origine,Image imgCarte) {
        super(origine,imgCarte);
        this.setDescription("Permet de bénéficier de la\n" +
                "capacité spéciale de l'un de\n" +
                "vos Croyants ou Guides\n" +
                "Spirituels sans sacrifier la\n" +
                "carte.\n");
        this.setNom("Phoenix");
    }

    @Override
    public void capacite(Joueur j, Partie p) {


    }
}
