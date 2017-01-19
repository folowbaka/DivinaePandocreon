package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte deusEx InfluenceNulle.
 * Sa capacite est defini dans la methode capacite.
 */
public class InfluenceNulle extends DeusEx {

    public InfluenceNulle(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une autre carte d'Action.\n");
        this.setNom("Influence Nulle");
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
