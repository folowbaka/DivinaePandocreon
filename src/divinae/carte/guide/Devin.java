package divinae.carte.guide;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Devin extends GuideSpirituel{

    public Devin(Origine origine, Dogme[] dogme,int nbMaxCroyant,String cheminCarte) {
        super(origine, dogme,nbMaxCroyant,cheminCarte);
        this.setDescription("Sacrifice :\nOblige une Divinité ayant le\n" +
                "Dogme Nature ou Mystique\n" +
                "à sacrifier l'un de ses Guides\n" +
                "Spirituels.\n");
        this.setNom("Devin");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        boolean boolDogme=true;
        Joueur choixJoueur;
        do{
            choixJoueur = InterfaceCommand.choixJoueur(p);
            for (int t=0;t<choixJoueur.getDivinite().getDogme().length;t++){
                if (choixJoueur.getDivinite().getDogme()[t]==Dogme.NATURE ||choixJoueur.getDivinite().getDogme()[t]==Dogme.MYSTIQUE){
                    boolDogme=false;
                }
            }

            if(boolDogme){
                System.out.println("La divinité est de mauvais dogme.");
            }
        }while(boolDogme);
        int choixGuide = InterfaceCommand.choixGuide(choixJoueur,p);
        choixJoueur.sacrifierGuide(choixGuide,p);
    }
}
