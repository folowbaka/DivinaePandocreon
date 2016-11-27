package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Revolutionnaire extends Croyant {
    public Revolutionnaire(Origine origine, String nom, Dogme dogme) {
        super(origine,nom, dogme);
        this.setDescription("Sacrifice :\nImposez le sacrifice d'une\n" +
                "carte de Croyants à autant de\n" +
                "Divinités que vous le voulez.\n" +
                "Chaque Divinité choisit la\n" +
                "carte à sacrifier. Les capacités\n" +
                "spéciales sont jouées.");
    }
    public void capacite() {

    }
}
