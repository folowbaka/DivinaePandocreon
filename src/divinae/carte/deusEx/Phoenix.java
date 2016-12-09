package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Phoenix extends DeusEx {

    public Phoenix(Origine origine) {
        super(origine);
        this.setDescription("Permet de bénéficier de la\n" +
                "capacité spéciale de l'un de\n" +
                "vos Croyants ou Guides\n" +
                "Spirituels sans sacrifier la\n" +
                "carte.\n");
        this.setNom("Phoenix");
    }

    @Override
    public void capacite(Joueur j, Partie p) {


    }
}
