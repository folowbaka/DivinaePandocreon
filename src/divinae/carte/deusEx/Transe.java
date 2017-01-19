package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte deusEx Transe.
 * Sa capacite est defini dans la methode capacite.
 */
public class Transe extends DeusEx {

    public Transe(Origine origine,String cheminCarte) {
        super(origine,cheminCarte);
        this.setDescription("Permet de récupérer les effets\n" +
                "bénéfiques d'une carte\n" +
                "d'Action posée par une autre\n" +
                "Divinité. S'il s'agit d'une carte\n" +
                "Croyants ou Guide Spirituel,\n" +
                "vous posez la carte devant\n" +
                "vous.");
        this.setNom("Transe");
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

    }
}
