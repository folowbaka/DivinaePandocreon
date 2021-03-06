package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.Apocalypse;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

import java.util.Scanner;
/**
 * Represente une carte Divinite Llewella.
 * Sa capacite est defini dans la methode capacite.
 */
public class Llewella extends Divinite {

    public Llewella(String cheminCarte) {
        super(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE,Dogme.CHAOS},cheminCarte);
        this.setDescriptionDivinite("Divinité machiavélique et manipulatrice, Killinstred cherche à influencer et contrôler ses ennemis.\n");
        this.setDescription("Peut obliger un joueur à poser une carte Apocalypse s'il en possède une.");
        this.setNom("Llewella");
    }
    /**
     *Capacite de la carte Divinite concernee, oblige un joueur a jouer une carte apocalypse.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        Scanner sc=new Scanner(System.in);
        int choixJoueur;
        do {
            for(int i=0;i<p.getJoueur().size();i++)
            {
                Boolean possedeApo= false;

                for (int j2=0; j2<p.getJoueur().get(i).getMain().size();j2++){
                    if (p.getJoueur().get(i).getMain().get(j2) instanceof Apocalypse){
                        possedeApo=true;
                    }
                }
                if(possedeApo){
                    System.out.println("Joueur "+(i+1)+" : "+p.getJoueur().get(i).getNom());
                }
            }
            System.out.println("A quel joueur voulez-vous faire jouer une carte Apocalypse?");
            choixJoueur=sc.nextInt();
            if(choixJoueur>p.getJoueur().size() || choixJoueur<0)
                System.out.println("Choix invalide");
        }while (choixJoueur>p.getJoueur().size() || choixJoueur<0);
        Joueur choixJoueurApo =  p.getJoueur().get(choixJoueur-1);

        int indiceApo=0;
        for (int j2=0; j2<choixJoueurApo.getMain().size();j2++){
            if (choixJoueurApo.getMain().get(j2) instanceof Apocalypse){
                indiceApo=j2;
            }
        }
        choixJoueurApo.getMain().get(indiceApo).capacite(j,p);
        choixJoueurApo.defausseCarte(indiceApo,p);
    }
}
