package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class ColereDivine extends DeusEx {

    public ColereDivine(Origine origine)
    {
        super(origine);
        this.setDescription("Détruit une carte Guide\n" +
                "Spirituel d'Origine Nuit ou\n" +
                "Néant, dont la capacité\n" +
                "spéciale n'a pas effet. Les\n" +
                "Croyants attachés reviennent\n" +
                "au centre de la table.");
        this.setNom("Colère Divine");
    }

    @Override
    public void capacite() {

    }
}
