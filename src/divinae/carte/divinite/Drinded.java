package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Drinded extends Divinite {
    public Drinded(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
        this.setDescriptionDivinite("Défenseur des hommes, quelles que soient leurs croyances, Drinded protège les chefs religieux");
        this.setDescription("Peut empêcher le sacrifice d'un des Guides Spirituels de n'importe quel joueur.\n");
    }

    @Override
    public void capacite() {

    }
}
