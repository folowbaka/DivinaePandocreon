package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Sorcier extends GuideSpirituel{
    public Sorcier(Origine origine, Dogme[] dogme,int nbMaxCroyant,Image imgCarte) {
        super(origine,dogme,nbMaxCroyant,imgCarte);
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

    }
}
