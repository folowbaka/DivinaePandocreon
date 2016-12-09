package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Sorcier extends GuideSpirituel{
    public Sorcier(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
        this.setDescription("Sacrifice :\nEchangez l'un de vos Guides\n" +
                "Spirituels avec un d'une autre\n" +
                "Divinité. Vous choisissez les\n" +
                "deux guides Spirituels en\n" +
                "question. Les Croyants\n" +
                "restent attachés aux mêmes\n" +
                "cartes.\n");
        this.setNom("Sorcier");
        this.setNbMaxCroyant(3);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
