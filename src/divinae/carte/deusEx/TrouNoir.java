package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class TrouNoir extends DeusEx {

    public TrouNoir(Origine origine) {
        super(origine);
        this.setDescription("Aucun autre joueur ne gagne\n" +
                "de points d'Action durant ce\n" +
                "tour.");
    }

    @Override
    public void capacite() {

    }
}
