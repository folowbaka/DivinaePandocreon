package divinae.carte.deusEx;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
/**
 * Represente une carte deusEx OrdreCeleste.
 * Sa capacite est defini dans la methode capacite.
 */
public class OrdreCeleste extends DeusEx {

    public OrdreCeleste(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Vous récupérez un des\n" +
                "Guides Spirituels posés\n" +
                "devant une autre Divinité et\n" +
                "le placez devant vous avec\n" +
                "les Croyants qui y sont\n" +
                "attachés.\n");
        this.setNom("Ordre Céleste");
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
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        int choixGuide = InterfaceCommand.choixGuide(choixJoueur, p);
        choixJoueur.getDivinite().getGuideDivinite().add(choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide));
    }
}
