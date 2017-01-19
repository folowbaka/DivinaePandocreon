package divinae.carte.croyant;

import divinae.Joueur;
import java.util.*;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;
/**
 * Represente une carte croyant Pillard.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Pillard extends Croyant {
    public Pillard(Dogme[] dogme, String cheminCarte) {
        super(Origine.NUIT,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nRécupérez les points d'Action\n" +
                "d'une Divinité n'ayant pas\n" +
                "encore joué durant ce tour.\n" +
                "Les points d'Action gardent\n" +
                "leur Origine. La Divinité\n" +
                "perd ses points.\n");
        this.setNom("Pillard");
        this.setNbCroyant(4);
    }
    /**
     *Capacite de la carte croyant concernee.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        int index = p.getJoueur().indexOf(j);
        for (int i =index+1; i<p.getJoueur().size(); i++){
            System.out.println("Joueur "+(i+1)+" : "+p.getJoueur().get(i).getNom());
        }
        Scanner sc=new Scanner(System.in);
        int choixJoueur;
        do {
            System.out.println("A quel joueur voulez-vous voler des points?");
            choixJoueur=sc.nextInt();
            if(choixJoueur>p.getJoueur().size() || choixJoueur<0)
                System.out.println("Choix invalide");
        }while (choixJoueur>p.getJoueur().size() || choixJoueur<0);
        Joueur choixJoueurVol =  p.getJoueur().get(choixJoueur-1);


        j.ajoutPoints(choixJoueurVol.getPointsAction().get("JOUR"), "JOUR");
        j.ajoutPoints(choixJoueurVol.getPointsAction().get("NUIT"), "NUIT");
        j.ajoutPoints(choixJoueurVol.getPointsAction().get("NEANT"), "NEANT");
        choixJoueurVol.ajoutPoints(- choixJoueurVol.getPointsAction().get("JOUR"), "JOUR");
        choixJoueurVol.ajoutPoints(- choixJoueurVol.getPointsAction().get("NUIT"), "NUIT");
        choixJoueurVol.ajoutPoints(- choixJoueurVol.getPointsAction().get("NEANT"), "NEANT");

    }
}
