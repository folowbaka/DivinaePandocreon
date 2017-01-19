package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte deusEx Miroir.
 * Sa capacite est defini dans la methode capacite.
 */
public class Miroir extends DeusEx {

    public Miroir(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Retourne les effets d'une carte\n" +
                "d'Action sur la Divinité qui\n" +
                "l'a posée");
        this.setNom("Miroir");
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
