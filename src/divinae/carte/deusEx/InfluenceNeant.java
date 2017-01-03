package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class InfluenceNeant extends DeusEx {

    public InfluenceNeant(Origine origine,Image imgCarte)
    {
        super(origine,imgCarte);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une carte d'Action d'Origine\n" +
                "Jour ou Nuit.");
        this.setNom("Influence Néant");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }

}
