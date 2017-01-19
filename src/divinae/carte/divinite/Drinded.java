package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte Divinite Drinded.
 * Sa capacite est defini dans la methode capacite.
 */
public class Drinded extends Divinite {
    public Drinded(String cheminCarte) {
        super(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN,Dogme.SYMBOLE},cheminCarte);
        this.setDescriptionDivinite("Défenseur des hommes, quelles que soient leurs croyances, Drinded protège les chefs religieux");
        this.setDescription("Peut empêcher le sacrifice d'un des Guides Spirituels de n'importe quel joueur.\n");
        this.setNom("Drinded");
    }
    /**
     *Capacite de la carte Divinite concernee.
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
