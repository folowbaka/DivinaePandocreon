package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Illusionniste extends Croyant {
    public Illusionniste(Dogme[] dogme) {
        super(Origine.NUIT,dogme);
        this.setDescription("Sacrifice :\nVous bénéficiez de la capacité\n" +
                "spéciale de sacrifice d'une\n" +
                "carte de Croyants\n" +
                "appartenant à une autre\n" +
                "Divinité. La carte en question\n" +
                "reste en jeu.\n");
        this.setNom("Illusionniste");
        this.setNbCroyant(4);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
