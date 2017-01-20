package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte deusEx InfluenceNeant.
 * Sa capacite est defini dans la methode capacite.
 */
public class InfluenceNeant extends DeusEx {

    public InfluenceNeant(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Annule la capacité spéciale\n" +
                "d'une carte d'Action d'Origine\n" +
                "Jour ou Nuit.");
        this.setNom("Influence Néant");
    }
    /**
     *NON IMPLEMENTE
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
