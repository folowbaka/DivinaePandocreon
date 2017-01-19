package divinae.carte.deusEx;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
/**
 * Represente une carte deusEx Inquisition.
 * Sa capacite est defini dans la methode capacite.
 */
public class Inquisition extends DeusEx {

    public Inquisition(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Choisissez un des Guides\n" +
                "Spirituels d'un autre joueur,\n" +
                "et l'un des votres. Lancez le\n" +
                "dé de Cosmogonie. Sur Jour, le\n" +
                "Guide adverse est sacrifié, sur\n" +
                "Nuit le votre est sacrifié, sur\n" +
                "Néant rien ne se passe. Les capacités spéciales sont jouées." +
                " La partie continue avec la nouvelle Cosmogonie");
        this.setNom("Inquisition");
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
        int choixGuide = InterfaceCommand.choixGuide(choixJoueur,p);
        int choixGuide2 = InterfaceCommand.choixGuide(j,p);
        Origine origineTour=p.lancerDes();
        System.out.println(origineTour);

        switch(origineTour){
            case JOUR:
                choixJoueur.sacrifierGuide(choixGuide,p);
                break;
            case NUIT:
                j.sacrifierGuide(choixGuide2,p);
                break;
            case NEANT:
                choixJoueur.getDivinite().getGuideDivinite().get(choixGuide2).capacite(j,p);
                j.getDivinite().getGuideDivinite().get(choixGuide2).capacite(j,p);
        }

        p.setInfluenceTour(origineTour);
    }
}
