package divinae.carte.divinite;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;

public class Shingva extends Divinite {

    public Shingva(String cheminCarte) {
        super(Origine.AUBE,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE,Dogme.CHAOS},cheminCarte);
        this.setDescriptionDivinite("Perverse et retorse, Shingva est une Divinité que toutes les autres détestent.\n");
        this.setDescription("Peut imposer le sacrifice d'un Guide Spirituel ayant le Dogme Symboles ou Nature.");
        this.setNom("Shingva");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        Scanner sc=new Scanner(System.in);
        int choixSacrificeGuide;
        InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
        boolean boolDogme=true;
        do{

            System.out.println("Entrez le guide de dogme Symboles ou Nature à sacrifier");
            choixSacrificeGuide=sc.nextInt()-1;
            for (int t=0; t<choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getDogme().length;t++){
                if (choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getDogme()[t]==Dogme.NATURE || choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getDogme()[t]==Dogme.SYMBOLE){
                    boolDogme = false;
                }
            }
            if (boolDogme){
                System.out.println("Le guide choisi n'est pas du bon dogme.");
            }
        }while(boolDogme);

        choixJoueur.sacrifierGuide(choixSacrificeGuide,p);
    }
}
