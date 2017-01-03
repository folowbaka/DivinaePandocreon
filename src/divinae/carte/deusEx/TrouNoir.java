package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class TrouNoir extends DeusEx {

    public TrouNoir(Origine origine,Image imgCarte) {
        super(origine,imgCarte);
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
