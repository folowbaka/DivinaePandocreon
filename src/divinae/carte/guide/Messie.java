package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

import java.util.Scanner;

public class Messie  extends GuideSpirituel{
    public Messie(Origine origine, Dogme[] dogme,int nbMaxCroyant,Image imgCarte) {
        super(origine, dogme,nbMaxCroyant,imgCarte);
        this.setDescription("Sacrifice :\nLe joueur pose le dé de\n" +
                "Cosmogonie sur la face qu'il\n" +
                "désire et commence un\n" +
                "nouveau tour de jeu.\n");
        this.setNom("Messie");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        System.out.println("Choisissez une origine.\n1 - Jour\n2 - Nuit\n3 - Néant");
        Scanner sc = new Scanner(System.in);
        int choix;
        choix = sc.nextInt();
        switch (choix){
            case 1:
                p.setInfluenceTour(Origine.JOUR);
                break;
            case 2:
                p.setInfluenceTour(Origine.NUIT);
                break;
            case 3:
                p.setInfluenceTour(Origine.NEANT);
                break;
        }
    }
}