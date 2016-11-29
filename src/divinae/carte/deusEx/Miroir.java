package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Miroir extends DeusEx {

    public Miroir(Origine origine,String nom)
    {
        super(origine, nom);
        this.setDescription("Retourne les effets d'une carte\n" +
                "d'Action sur la Divinité qui\n" +
                "l'a posée");
    }

    @Override
    public void capacite() {

    }
}
