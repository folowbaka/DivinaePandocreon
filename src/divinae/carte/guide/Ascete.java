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
public class Ascete extends GuideSpirituel{
    public Ascete(Origine origine,Dogme[] dogme,int nbMaxCroyant,String cheminCarte) {
        super(origine,dogme,nbMaxCroyant,cheminCarte);
        this.setDescription("Sacrifice :\nSacrifie 2 cartes Croyants\n" +
                "d'une Divinité ayant le\n" +
                "Dogme Humain ou Symboles.\n" +
                "Les capacités spéciales sont\n" +
                "jouées normalement.\n");
        this.setNom("Ascete");
    }
    /**
     *Capacite de la carte GuideSpirituel concernee.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        for(int i=0;i<2;i++) {
            Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
            Scanner sc = new Scanner(System.in);
            int choixSacrificeGuide;
            int choixSacrificeCroyant;
            InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
            System.out.println("Entrez le croyant à sacrifier");
            choixSacrificeGuide = sc.nextInt() - 1;
            Boolean boolDogme=true;
            do{
                choixSacrificeCroyant = sc.nextInt() - 1;
                for (int t=0; t<choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getCroyantRattache()[choixSacrificeCroyant].getDogme().length;t++){
                    if (choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getCroyantRattache()[choixSacrificeCroyant].getDogme()[t]==Dogme.HUMAIN || choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getCroyantRattache()[choixSacrificeCroyant].getDogme()[t]==Dogme.SYMBOLE){
                        boolDogme = false;
                    }
                }
                if(boolDogme){
                    System.out.println("Le croyant est de mauvais dogme.");
                }

            }while(boolDogme);

            choixJoueur.sacrifierCroyant(choixSacrificeGuide,choixSacrificeCroyant,p);
        }
    }
}
