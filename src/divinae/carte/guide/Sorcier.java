package divinae.carte.guide;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Sorcier extends GuideSpirituel{
    public Sorcier(Origine origine, Dogme[] dogme,int nbMaxCroyant,String cheminCarte) {
        super(origine,dogme,nbMaxCroyant,cheminCarte);
        this.setDescription("Sacrifice :\nEchangez l'un de vos Guides\n" +
                "Spirituels avec un d'une autre\n" +
                "Divinité. Vous choisissez les\n" +
                "deux guides Spirituels en\n" +
                "question. Les Croyants\n" +
                "restent attachés aux mêmes\n" +
                "cartes.\n");
        this.setNom("Sorcier");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        int choixGuide = InterfaceCommand.choixGuide(choixJoueur,p);
        int choixGuide2 = InterfaceCommand.choixGuide(j,p);
        choixJoueur.getDivinite().getGuideDivinite().add(j.getDivinite().getGuideDivinite().get(choixGuide2));
        j.getDivinite().getGuideDivinite().add(choixJoueur.getDivinite().getGuideDivinite().get(choixGuide));

        choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide);
        j.getDivinite().getGuideDivinite().remove(choixGuide2);
    }
}
