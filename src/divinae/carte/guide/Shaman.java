package divinae.carte.guide;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Shaman extends GuideSpirituel {
    public Shaman(Origine origine, Dogme[] dogme,int nbMaxCroyant,Image imgCarte) {
        super(origine,dogme,nbMaxCroyant,imgCarte);
        this.setDescription("Sacrifice :\nSacrifie tous les Croyants\n" +
                "d'Origine Néant d'une\n" +
                "Divinité ayant le Dogme\n" +
                "Humain. Les capacités\n" +
                "spécials sont jouées\n" +
                "normalement.\n");
        this.setNom("Shaman");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur;
        boolean boolDogme=true;
        do{
            choixJoueur = InterfaceCommand.choixJoueur(p);
            for (int t=0;t<choixJoueur.getDivinite().getDogme().length;t++){
                if (choixJoueur.getDivinite().getDogme()[t]==Dogme.HUMAIN){
                    boolDogme=false;
                }
            }

            if(boolDogme){
                System.out.println("La divinité est de mauvais dogme ou de mauvaise origine.");
            }
        }while(boolDogme);
        for(int i=0;i<choixJoueur.getDivinite().getGuideDivinite().size();i++)
        {

            for (int j2=0;j2< choixJoueur.getDivinite().getGuideDivinite().get(i).getCroyantRattache().length;j2++){
                if (choixJoueur.getDivinite().getGuideDivinite().get(i).getCroyantRattache()[j2].getOrigine()==Origine.NEANT){
                    choixJoueur.sacrifierCroyant(i,j2,p);
                }
            }
        }
    }
}
