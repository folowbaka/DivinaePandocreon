package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte croyant Demon.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Demon extends Croyant {
    public Demon(Dogme[] dogme, String cheminCarte) {

        super(Origine.NUIT,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nDonne un point d'Action\n" +
                "d'Origine Nuit.\n");
        this.setNom("Demon");
        this.setNbCroyant(2);
    }
    /**
     *Capacite de la carte croyant concernee, ajoute un point nuit.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        j.ajoutPoints(1, "NUIT");

    }
}
