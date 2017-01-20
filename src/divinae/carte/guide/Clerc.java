package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import Vue.InterfaceCommand;
/**
 * Represente une carte Guide Spirituel Anarchiste.
 * Sa capacite est defini dans la methode capacite.
 */
public class Clerc extends GuideSpirituel {
    public Clerc(Origine origine, Dogme[] dogme,int nbMaxCroyant,String cheminCarte) {
        super(origine,dogme,nbMaxCroyant,cheminCarte);
        this.setDescription("Sacrifice :\n" +
                "Fait gagner un nombre de\n" +
                "points d'Action égal au\n" +
                "nombre de cartes de Croyants\n" +
                "rattachées. L'Origine des\n" +
                "points d'Action est au choix\n" +
                "du joueur.\n");
        this.setNom("Clerc");
    }
    /**
     *Capacite de la carte GuideSpirituel concernee, fait gagner autant de points que de croyants rattachés.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        int compteur = 0;
        for (int i = 0; i< this.getCroyantRattache().length; i++){
            if (this.getCroyantRattache()[i] != null){
                compteur++;
            }
        }
        String choixOrigine = InterfaceCommand.choixOriginePoints(p);
        j.ajoutPoints(compteur, choixOrigine);

    }
}
