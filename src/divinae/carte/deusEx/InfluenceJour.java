package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class InfluenceJour extends DeusEx {

    public InfluenceJour(Origine origine, String nom)
    {
        super(origine, nom);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une carte d'Action d'Origine\n" +
                "Nuit ou Néant.\n");
    }

    @Override
    public void capacite() {

    }
}
