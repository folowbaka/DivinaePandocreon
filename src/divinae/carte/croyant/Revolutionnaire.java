package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Revolutionnaire extends Croyant {

    public Revolutionnaire(Dogme[] dogme) {
        super(Origine.NEANT,dogme);
        this.setDescription("Sacrifice :\nImposez le sacrifice d'une\n" +
                "carte de Croyants à autant de\n" +
                "Divinités que vous le voulez.\n" +
                "Chaque Divinité choisit la\n" +
                "carte à sacrifier. Les capacités\n" +
                "spéciales sont jouées.");
        this.setNom("Revolutionnaire");
        this.setNbCroyant(2);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
