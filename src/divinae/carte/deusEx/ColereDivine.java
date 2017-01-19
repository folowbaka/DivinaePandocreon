package divinae.carte.deusEx;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
/**
 * Represente une carte deusEx Colere Divine.
 * Sa capacite est defini dans la methode capacite.
 */
public class ColereDivine extends DeusEx {

    public ColereDivine(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
        this.setDescription("Détruit une carte Guide\n" +
                "Spirituel d'Origine Nuit ou\n" +
                "Néant, dont la capacité\n" +
                "spéciale n'a pas effet. Les\n" +
                "Croyants attachés reviennent\n" +
                "au centre de la table.");
        this.setNom("Colère Divine");
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
    public void capacite(Joueur joueur, Partie partie) {
        Joueur choixJoueur;
        int choixGuide;
        do{
            choixJoueur = InterfaceCommand.choixJoueur(partie);
            choixGuide = InterfaceCommand.choixGuide(choixJoueur, partie);
            if (choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getOrigine() != Origine.NUIT ||choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getOrigine() != Origine.NEANT){
                System.out.println("Origine du guide invalide.");
            }
        }while(choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getOrigine() != Origine.NUIT ||choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getOrigine() != Origine.NEANT);
        choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).libCroyant(partie);
        choixJoueur.getMain().add(choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide));
    }
}
