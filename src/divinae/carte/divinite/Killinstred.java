package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Killinstred extends Divinite {

    public Killinstred() {
        super(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE,Dogme.CHAOS});
        this.setDescriptionDivinite("Divinité machiavélique et manipulatrice, Killinstred cherche à influencer et contrôler ses ennemis.");
        this.setDescription("Peut obliger un joueur à poser une carte Apocalypse s'il en possède une.");
        this.setNom("Killinstred");
    }

    @Override
    public void capacite() {

    }
}
