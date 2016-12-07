package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Romtec extends Divinite {

    public Romtec() {
        super(Origine.CREPUSCULE,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN,Dogme.CHAOS});
        this.setDescriptionDivinite("Romtec est une Divinité individualiste, pour qui chaque être vivant doit garder son libre arbitre.\n");
        this.setDescription("Peut empêcher un jour de créer un Guide Spirituel. La carte est défaussée.");
        this.setNom("Romtec");
    }

    @Override
    public void capacite() {

    }
}
