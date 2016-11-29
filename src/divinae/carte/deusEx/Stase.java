package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Stase extends DeusEx {

    public Stase(Origine origine, String nom)
    {
        super(origine, nom);
        this.setDescription("Protège un Guide Spirituel et\n" +
                "ses Croyants jusqu'à ce que\n" +
                "cette carte soit annulée ou\n" +
                "jusqu'à la prochaine tentative\n" +
                "d'Apocalypse.\n");
    }

    @Override
    public void capacite() {

    }
}
