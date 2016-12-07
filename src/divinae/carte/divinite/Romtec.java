package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Romtec extends Divinite {

    public Romtec(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
        this.setDescriptionDivinite("Romtec est une Divinité individualiste, pour qui chaque être vivant doit garder son libre arbitre.\n");
        this.setDescription("Peut empêcher un jour de créer un Guide Spirituel. La carte est défaussée.");
    }

    @Override
    public void capacite() {

    }
}
