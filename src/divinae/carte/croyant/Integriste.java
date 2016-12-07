package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Integriste extends Croyant {
    public Integriste(Dogme[] dogme) {
        super(Origine.JOUR,dogme);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un Guide\n" +
                "Spirituel d'un autre joueur,\n" +
                "qui choisit la carte. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.\n");
        this.setNom("Integriste");
        this.setNbCroyant(1);
    }
    public void capacite() {

    }
}
