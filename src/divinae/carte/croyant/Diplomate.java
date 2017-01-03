package divinae.carte.croyant;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Diplomate extends Croyant {

    public Diplomate( Dogme[] dogme, Image imgCarte) {
        super(Origine.JOUR,dogme,imgCarte);
        this.setDescription("Sacrifice :\nRelancez le dé de Cosmogonie.\n" +
                "Le tour se finit normalement\n" +
                "sous la nouvelle influence.\n");
        this.setNom("Diplomate");
        this.setNbCroyant(4);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Origine origineTour=p.lancerDes();
        System.out.println(origineTour);
        p.setInfluenceTour(origineTour);
        j.ajoutPoints(origineTour);
    }
}
