package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class OrdreCeleste extends DeusEx {

    public OrdreCeleste(Origine origine,Image imgCarte)
    {
        super(origine,imgCarte);
        this.setDescription("Vous récupérez un des\n" +
                "Guides Spirituels posés\n" +
                "devant une autre Divinité et\n" +
                "le placez devant vous avec\n" +
                "les Croyants qui y sont\n" +
                "attachés.\n");
        this.setNom("Ordre Céleste");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
