package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte deusEx Bouleversement.
 * Sa capacite est defini dans la methode capacite.
 */
public class Bouleversement extends DeusEx {

    public Bouleversement(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Relancez le dé de Cosmogonie.\n" +
                "Le tour de jeu se terminera\n" +
                "normalement, mais sous la\n" +
                "nouvelle influence.");
        this.setNom("Bouleversement");
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
        Origine origineTour=p.lancerDes();
        System.out.println(origineTour);
        p.setInfluenceTour(origineTour);
    }
}
