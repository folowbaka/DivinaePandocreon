package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Paladin extends GuideSpirituel{
    public Paladin(Origine origine, Dogme[] dogme,int nbMaxCroyant,Image imgCarte) {
        super(origine,dogme,nbMaxCroyant,imgCarte);
        this.setDescription("Sacrifice :\nTous les Croyants, d'Origine\n" +
                "Nuit ou Néant et ayant le\n" +
                "Dogme Nature, actuellement\n" +
                "sur la table sont défaussés.\n" +
                "Les capacités spéciales ne sont\n" +
                "pas jouées.");
        this.setNom("Paladin");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        for (int i =0; i<p.getCentreTable().size();i++){
            boolean boolDogme = false;
            for (int t=0; t<p.getCentreTable().get(i).getDogme().length;t++){
                if (p.getCentreTable().get(i).getDogme()[t]==Dogme.NATURE){
                    boolDogme = true;
                }
            }
            if (p.getCentreTable().get(i) instanceof Croyant && (p.getCentreTable().get(i).getOrigine()==Origine.NUIT || p.getCentreTable().get(i).getOrigine()==Origine.NEANT) && boolDogme){
                p.getDefausse().add(p.getCentreTable().remove(i));
            }
        }
    }
}
