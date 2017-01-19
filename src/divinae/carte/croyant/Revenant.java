package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte croyant Revenant.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Revenant extends Croyant {

    public Revenant(Dogme[] dogme,String cheminCarte) {
        super(Origine.NEANT,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nLancez le dé de Cosmogonie.\n" +
                "Le tour se fini normalement,\n" +
                "mais sous cette nouvelle\n" +
                "influence.");
        this.setNom("Revenant");
        this.setNbCroyant(1);
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
        Origine origineTour=p.lancerDes();
        System.out.println(origineTour);
        p.setInfluenceTour(origineTour);
        j.ajoutPoints(origineTour);
    }
}
