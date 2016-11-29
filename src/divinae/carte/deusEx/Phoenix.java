package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Phoenix extends DeusEx {

    public Phoenix(Origine origine, String nom) {
        super(origine, nom);
        this.setDescription("Permet de bénéficier de la\n" +
                "capacité spéciale de l'un de\n" +
                "vos Croyants ou Guides\n" +
                "Spirituels sans sacrifier la\n" +
                "carte.\n");
    }

    @Override
    public void capacite() {

    }
}
