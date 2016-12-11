package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Bouleversement extends DeusEx {

    public Bouleversement(Origine origine)
    {
        super(origine);
        this.setDescription("Relancez le dé de Cosmogonie.\n" +
                "Le tour de jeu se terminera\n" +
                "normalement, mais sous la\n" +
                "nouvelle influence.");
        this.setNom("Bouleversement");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Origine origineTour=p.lancerDes();
        System.out.println(origineTour);
        p.setInfluenceTour(origineTour);
    }
}
