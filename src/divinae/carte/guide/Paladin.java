package divinae.carte.guide;

import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Paladin extends GuideSpirituel{
    public Paladin(Origine origine, String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nTous les Croyants, d'Origine\n" +
                "Nuit ou Néant et ayant le\n" +
                "Dogme Nature, actuellement\n" +
                "sur la table sont défaussés.\n" +
                "Les capacités spéciales ne sont\n" +
                "pas jouées.");
    }

    @Override
    public void capacite() {

    }
}
