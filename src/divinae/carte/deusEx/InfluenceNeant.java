package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class InfluenceNeant extends DeusEx {

    public InfluenceNeant(Origine origine,String nom)
    {
        super(origine, nom);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une carte d'Action d'Origine\n" +
                "Jour ou Nuit.");
    }

    @Override
    public void capacite() {

    }
}
