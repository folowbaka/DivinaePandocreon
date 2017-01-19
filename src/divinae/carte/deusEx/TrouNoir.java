package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte deusEx TrouNoir.
 * Sa capacite est defini dans la methode capacite.
 */
public class TrouNoir extends DeusEx {

    public TrouNoir(Origine origine,String cheminCarte) {
        super(origine,cheminCarte);
        this.setDescription("Aucun autre joueur ne gagne\n" +
                "de points d'Action durant ce\n" +
                "tour.");
        this.setNom("Trou Noir");
    }
    /**
     *Capacite de la carte deusEx concernee.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        for (int i = 0; i<p.getJoueur().size();i++){
            p.getJoueur().get(i).setPeutRecevoirPoint(false);
        }
    }
}
