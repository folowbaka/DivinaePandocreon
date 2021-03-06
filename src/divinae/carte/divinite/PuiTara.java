package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte Divinite PuiTara.
 * Sa capacite est defini dans la methode capacite.
 */
public class PuiTara extends Divinite {

    public PuiTara(String cheminCarte) {
        super(Origine.NUIT, new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE,Dogme.SYMBOLE},cheminCarte);
        this.setDescriptionDivinite("Pui-Tara est la Divinité sur laquelle l'influence de la Nuit s'est faite la plus forte.");
        this.setDescription("Peut détruire toutes les cartes de Croyants au centre de la table d'Origine Jour.");
        this.setNom("Pui-Tara");
    }
    /**
     *Capacite de la carte Divinite concernee, detruit les croyants au centre.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        for (int i =0; i<p.getCentreTable().size();i++){
            if (p.getCentreTable().get(i) instanceof Croyant && p.getCentreTable().get(i).getOrigine()==Origine.JOUR){
                p.getDefausse().add(p.getCentreTable().remove(i));
            }
        }
    }
}
