package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Llewella extends Divinite {

    public Llewella(Origine origine, String nom, Dogme dogme) {
        super(origine,nom, dogme);
        this.setDescriptionDivinite("Divinité machiavélique et manipulatrice, Killinstred cherche à influencer et contrôler ses ennemis.\n");
        this.setDescription("Peut obliger un joueur à poser une carte Apocalypse s'il en possède une.");
    }

    @Override
    public void capacite() {

    }
}
