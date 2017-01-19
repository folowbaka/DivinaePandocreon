package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

import java.util.Scanner;
/**
 * Represente une carte Divinite Gorpa.
 * Sa capacite est defini dans la methode capacite.
 */
public class Gorpa extends Divinite {
    public Gorpa(String cheminCarte) {
        super(Origine.CREPUSCULE,new Dogme[]{Dogme.HUMAIN,Dogme.SYMBOLE,Dogme.CHAOS},cheminCarte);
        this.setDescriptionDivinite("Divinité joueuse et espiègle, Gorpa aime gêner ses consœurs dans leur recherche de puissance.");
        this.setDescription("Peut récupérer les points d'Action d'une autre Divinité en plus des siens. L'autre Divinité ne reçoit aucun point d'Action ce tour-ci.");
        this.setNom("Gorpa");
    }

    /**
     *Capacite de la carte Divinite concernee.
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

        choixJoueurVol.setPeutRecevoirPoint(false);
    }
}
