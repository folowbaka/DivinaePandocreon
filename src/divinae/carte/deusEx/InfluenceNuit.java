package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class InfluenceNuit extends DeusEx {

    public InfluenceNuit(Origine origine)
    {
        super(origine);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une carte d'Action d'Origine\n" +
                "Jour ou Néant.\n");
        this.setNom("Influence Nuit");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
