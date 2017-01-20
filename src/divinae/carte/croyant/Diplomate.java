package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
/**
 * Represente une carte croyant Diplomate.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Diplomate extends Croyant {

    public Diplomate( Dogme[] dogme, String cheminCarte) {
        super(Origine.JOUR,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nRelancez le dé de Cosmogonie.\n" +
                "Le tour se finit normalement\n" +
                "sous la nouvelle influence.\n");
        this.setNom("Diplomate");
        this.setNbCroyant(4);
    }
    /**
     *Capacite de la carte croyant concernee, relance le dé et change l'origine du tour.
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
