package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Concentration extends DeusEx {

    public Concentration(Origine origine)
    {
        super(origine);
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
