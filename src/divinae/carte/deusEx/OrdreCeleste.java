package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class OrdreCeleste extends DeusEx {

    public OrdreCeleste(Origine origine, String nom)
    {
        super(origine, nom);
        this.setDescription("Vous récupérez un des\n" +
                "Guides Spirituels posés\n" +
                "devant une autre Divinité et\n" +
                "le placez devant vous avec\n" +
                "les Croyants qui y sont\n" +
                "attachés.\n");
    }

    @Override
    public void capacite() {

    }
}
