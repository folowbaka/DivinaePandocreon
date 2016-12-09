package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class InfluenceJour extends DeusEx {

    public InfluenceJour(Origine origine)
    {
        super(origine);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une carte d'Action d'Origine\n" +
                "Nuit ou Néant.\n");
        this.setNom("Influence Jour");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
