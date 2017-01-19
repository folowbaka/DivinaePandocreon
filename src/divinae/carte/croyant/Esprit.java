package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte croyant Esprit.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Esprit extends Croyant {
    public Esprit(Dogme[] dogme, String cheminCarte) {
        super(Origine.NEANT, dogme,cheminCarte);
        this.setDescription("Sacrifice :\nDonne un point d'Action\n" +
                "d'Origine Néant.");
        this.setNom("Esprit");
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
    @Override
    public void capacite(Joueur j, Partie p) {
        j.ajoutPoints(1, "NEANT");
    }
}
