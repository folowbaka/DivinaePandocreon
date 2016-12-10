package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Paladin extends GuideSpirituel{
    public Paladin(Origine origine, Dogme[] dogme,int nbMaxCroyant) {
        super(origine,dogme,nbMaxCroyant);
        this.setDescription("Sacrifice :\nTous les Croyants, d'Origine\n" +
                "Nuit ou Néant et ayant le\n" +
                "Dogme Nature, actuellement\n" +
                "sur la table sont défaussés.\n" +
                "Les capacités spéciales ne sont\n" +
                "pas jouées.");
        this.setNom("Paladin");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
