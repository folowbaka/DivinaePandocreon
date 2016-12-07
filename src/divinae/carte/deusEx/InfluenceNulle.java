package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class InfluenceNulle extends DeusEx {

    public InfluenceNulle(Origine origine)
    {
        super(origine);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une autre carte d'Action.\n");
    }

    @Override
    public void capacite() {

    }
}
