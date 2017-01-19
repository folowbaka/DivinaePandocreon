package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte Divinite Yarstur.
 * Sa capacite est defini dans la methode capacite.
 */
public class Yarstur extends Divinite {

    public Yarstur(String cheminCarte) {
        super(Origine.JOUR,new Dogme[]{Dogme.CHAOS,Dogme.SYMBOLE,Dogme.MYSTIQUE},cheminCarte);
        this.setDescriptionDivinite("Dernier pur du jour, Yarstur combat le Néant sous toutes ses formes");
        this.setDescription("Peut détruire toutes les cartes de Croyants au centre de la table d'Origine Néant.");
        this.setNom("Yartsur");
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
        for (int i =0; i<p.getCentreTable().size();i++){

            if (p.getCentreTable().get(i) instanceof Croyant && p.getCentreTable().get(i).getOrigine()==Origine.NEANT){
                p.getDefausse().add(p.getCentreTable().remove(i));
            }
        }
    }
}
