package divinae.carte.deusEx;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

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

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur;
        int choixGuide;
        do{
            choixJoueur = InterfaceCommand.choixJoueur(p);
            choixGuide = InterfaceCommand.choixGuide(choixJoueur, p);
            if (choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getOrigine() != Origine.NUIT ||choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getOrigine() != Origine.NEANT){
                System.out.println("Origine du guide invalide.");
            }
        }while(choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getOrigine() != Origine.NUIT ||choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getOrigine() != Origine.NEANT);
        choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).libCroyant(choixJoueur,p);
        choixJoueur.getMain().add(choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide));
    }
}
