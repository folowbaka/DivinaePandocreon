package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte croyant Moine.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Moine extends Croyant {
    public Moine(Dogme[] dogme, String cheminCarte) {
        super(Origine.JOUR,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nDonne un point d'Action d'Origine Jour");
        this.setNom("Moine");
        this.setNbCroyant(2);
    }
    /**
     *Capacite de la carte croyant concernee.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    public void capacite(Joueur joueur, Partie p) {
        joueur.ajoutPoints(1, "JOUR");
    }

}
