package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class InfluenceNuit extends DeusEx {

    public InfluenceNuit(Origine origine)
    {
        super(origine);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une carte d'Action d'Origine\n" +
                "Jour ou Néant.\n");
    }

    @Override
    public void capacite() {

    }
}
