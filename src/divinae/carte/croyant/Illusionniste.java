package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Illusionniste extends Croyant {
    public Illusionniste(Origine origine,String nom, Dogme dogme) {
        super(origine, nom, dogme);
        this.setDescription("Sacrifice :\nVous bénéficiez de la capacité\n" +
                "spéciale de sacrifice d'une\n" +
                "carte de Croyants\n" +
                "appartenant à une autre\n" +
                "Divinité. La carte en question\n" +
                "reste en jeu.\n");
    }
    public void capacite() {

    }
}
