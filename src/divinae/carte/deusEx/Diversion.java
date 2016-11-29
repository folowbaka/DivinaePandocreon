package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Diversion extends DeusEx {

    public Diversion(Origine origine, String nom)
    {
        super(origine,nom);
        this.setDescription("Prenez 3 cartes dans la main\n" +
                "d'un autre joueur et\n" +
                "incluez-les à votre main.");
    }

    @Override
    public void capacite() {

    }
}
