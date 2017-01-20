package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte Divinite Gwenghelen.
 * Sa capacite est defini dans la methode capacite.
 */
public class Gwenghelen extends Divinite {

    public Gwenghelen(String cheminCarte) {
        super(Origine.AUBE,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE,Dogme.SYMBOLE},cheminCarte);
        this.setDescriptionDivinite("Première Divinité à recevoir l'influence du Néant, Gwenghelen est celle qui en a reçu le plus de puissance");
        this.setDescription("Récupère autant de points d'Action supplémentaires d'Origine Néant que le nombre de Guides Spirituels que la Divinité possède.\n");
        this.setNom("Gwenghelen");
    }
    /**
     *Capacite de la carte Divinite concernee, recupere des points neants supplementaires en fonctions des guides.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        j.ajoutPoints(this.getGuideDivinite().size(),"NEANT");
    }
}
