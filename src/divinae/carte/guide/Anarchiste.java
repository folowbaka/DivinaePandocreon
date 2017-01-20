package divinae.carte.guide;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;
/**
 * Represente une carte Guide Spirituel Anarchiste.
 * Sa capacite est defini dans la methode capacite.
 */
public class Anarchiste extends GuideSpirituel {
    public Anarchiste(Origine origine, Dogme[] dogme,int nbMaxCroyant,String cheminCarte) {
        super(origine, dogme,nbMaxCroyant,cheminCarte);
        this.setDescription("Sacrifice : \nSacrifie un Guide Spirituel, si\n" +
                "lui ou sa Divinité ne croit pas\n" +
                "au Dogme Chaos. Les\n" +
                "capacités spéciales sont jouées\n" +
                "normalement.\n");
        this.setNom("Anarchiste");
    }
    /**
     *Capacite de la carte GuideSpirituel concernee, force le sacrifice d'un guide.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        Scanner sc=new Scanner(System.in);
        int choixSacrificeGuide;
        InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
        boolean boolDogme=true;
        do{

            System.out.println("Entrez le guide à sacrifier.");
            choixSacrificeGuide=sc.nextInt()-1;
            for (int t=0; t<choixJoueur.getDivinite().getDogme().length;t++){
                if (choixJoueur.getDivinite().getDogme()[t]!=Dogme.CHAOS){
                    boolDogme = false;
                }
            }
            for (int t=0; t<choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getDogme().length;t++){
                if (choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getDogme()[t]!=Dogme.CHAOS){
                    boolDogme = false;
                }
            }
            if (boolDogme){
                System.out.println("Le guide ou divinité choisie n'est pas du bon dogme.");
            }
        }while(boolDogme);

        choixJoueur.sacrifierGuide(choixSacrificeGuide,p);
    }
}
