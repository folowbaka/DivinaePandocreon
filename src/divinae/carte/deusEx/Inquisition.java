package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Inquisition extends DeusEx {

    public Inquisition(Origine origine,Image imgCarte)
    {
        super(origine,imgCarte);
        this.setDescription("Choisissez un des Guides\n" +
                "Spirituels d'un autre joueur,\n" +
                "et l'un des votres. Lancez le\n" +
                "dé de Cosmogonie. Sur Jour, le\n" +
                "Guide adverse est sacrifié, sur\n" +
                "Nuit le votre est sacrifié, sur\n" +
                "Néant rien ne se passe. Les capacités spéciales sont jouées." +
                " La partie continue avec la nouvelle Cosmogonie");
        this.setNom("Inquisition");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
