package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Stase extends DeusEx {

    public Stase(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Protège un Guide Spirituel et\n" +
                "ses Croyants jusqu'à ce que\n" +
                "cette carte soit annulée ou\n" +
                "jusqu'à la prochaine tentative\n" +
                "d'Apocalypse.\n");
        this.setNom("Stase");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
