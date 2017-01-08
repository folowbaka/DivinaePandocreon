package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Tyran extends GuideSpirituel {
    public Tyran(Origine origine, Dogme[] dogme,int nbMaxCroyant,Image imgCarte) {
        super(origine, dogme,nbMaxCroyant,imgCarte);
        this.setDescription("Sacrifice :\nDéfausse tous les Croyants\n" +
                "ayant le Dogme Mystique\n" +
                "actuellement au centre de la\n" +
                "table.\n");
        this.setNom("Tyran");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        for (int i =0; i<p.getCentreTable().size();i++){
            boolean boolDogme = false;
            for (int t=0; t<p.getCentreTable().get(i).getDogme().length;t++){
                if (p.getCentreTable().get(i).getDogme()[t]==Dogme.MYSTIQUE){
                    boolDogme = true;
                }
            }
            if (p.getCentreTable().get(i) instanceof Croyant && boolDogme){
                p.getDefausse().add(p.getCentreTable().remove(i));
            }
        }
    }
}
