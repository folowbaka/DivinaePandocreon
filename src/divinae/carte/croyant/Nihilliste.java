package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte croyant Nihiliste.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Nihilliste extends Croyant {

    public Nihilliste(Dogme[] dogme,String cheminCarte) {
        super(Origine.NEANT,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nJusqu'à la fin du tour, plus\n" +
                "aucune Divinité ne reçoit de\n" +
                "points d'Action.\n");
        this.setNom("Nihilliste");
        this.setNbCroyant(4);
    }
    /**
     *Capacite de la carte croyant concernee.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    public void capacite(Joueur j, Partie p) {
        for (int i = 0; i<p.getJoueur().size();i++){
            p.getJoueur().get(i).setPeutRecevoirPoint(false);
        }
    }
}
