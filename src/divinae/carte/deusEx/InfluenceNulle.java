package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class InfluenceNulle extends DeusEx {

    public InfluenceNulle(Origine origine,Image imgCarte)
    {
        super(origine,imgCarte);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une autre carte d'Action.\n");
        this.setNom("Influence Nulle");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
