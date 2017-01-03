package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Exorciste extends GuideSpirituel{
    public Exorciste(Origine origine, Dogme[] dogme,int nbMaxCroyant,Image imgCarte) {
        super(origine, dogme,nbMaxCroyant,imgCarte);
        this.setDescription("Sacrifice :\nUne Divinité d'Origine Nuit\n" +
                "ou ayant les Dogmes\n" +
                "Mystique et Chaos reprend\n" +
                "dans sa main l'un de ses\n" +
                "Guides Spirituels. Les\n" +
                "Croyants qui y étaient\n" +
                "attachés sont défaussés.");
        this.setNom("Exorciste");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
