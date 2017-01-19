package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class InfluenceNuit extends DeusEx {

    public InfluenceNuit(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une carte d'Action d'Origine\n" +
                "Jour ou Néant.\n");
        this.setNom("Influence Nuit");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
