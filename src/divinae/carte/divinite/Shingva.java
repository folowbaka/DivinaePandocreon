package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Shingva extends Divinite {

    public Shingva() {
        super(Origine.AUBE,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE,Dogme.CHAOS});
        this.setDescriptionDivinite("Perverse et retorse, Shingva est une Divinité que toutes les autres détestent.\n");
        this.setDescription("Peut imposer le sacrifice d'un Guide Spirituel ayant le Dogme Symboles ou Nature.");
        this.setNom("Shingva");
    }

    @Override
    public void capacite() {

    }
}
