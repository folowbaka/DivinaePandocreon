package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Bouleversement extends DeusEx {

    public Bouleversement(Origine origine,String nom)
    {
        super(origine, nom);
        this.setDescription("Relancez le dé de Cosmogonie.\n" +
                "Le tour de jeu se terminera\n" +
                "normalement, mais sous la\n" +
                "nouvelle influence.");
    }

    @Override
    public void capacite() {

    }
}
