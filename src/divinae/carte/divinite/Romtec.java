package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte Divinite Romtec.
 * Sa capacite est defini dans la methode capacite.
 */
public class Romtec extends Divinite {

    public Romtec(String cheminCarte) {
        super(Origine.CREPUSCULE,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN,Dogme.CHAOS},cheminCarte);
        this.setDescriptionDivinite("Romtec est une Divinité individualiste, pour qui chaque être vivant doit garder son libre arbitre.\n");
        this.setDescription("Peut empêcher un joueur de créer un Guide Spirituel. La carte est défaussée.");
        this.setNom("Romtec");
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
