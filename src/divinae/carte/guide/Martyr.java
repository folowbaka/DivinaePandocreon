package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Martyr extends GuideSpirituel {
    public Martyr(Origine origine, Dogme[] dogme,int nbMaxCroyant) {
        super(origine, dogme,nbMaxCroyant);
        this.setDescription("Sacrifice :\nEquivalent à la pose d'une\n" +
                "carte Apocalypse.\n");
        this.setNom("Martyr");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
