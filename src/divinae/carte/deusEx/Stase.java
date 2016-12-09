package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Stase extends DeusEx {

    public Stase(Origine origine)
    {
        super(origine);
        this.setDescription("Protège un Guide Spirituel et\n" +
                "ses Croyants jusqu'à ce que\n" +
                "cette carte soit annulée ou\n" +
                "jusqu'à la prochaine tentative\n" +
                "d'Apocalypse.\n");
        this.setNom("Stase");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
