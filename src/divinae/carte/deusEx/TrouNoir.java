package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class TrouNoir extends DeusEx {

    public TrouNoir(Origine origine) {
        super(origine);
        this.setDescription("Aucun autre joueur ne gagne\n" +
                "de points d'Action durant ce\n" +
                "tour.");
        this.setNom("Trou Noir");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        for (int i = 0; i<p.getJoueur().size();i++){
            p.getJoueur().get(i).setPeutRecevoirPoint(false);
        }
    }
}
