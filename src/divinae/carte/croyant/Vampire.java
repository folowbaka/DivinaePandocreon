package divinae.carte.croyant;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;

public class Vampire extends Croyant {
    public Vampire( Dogme[] dogme, String cheminCarte) {
        super(Origine.NUIT,dogme,cheminCarte);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un\n" +
                "Croyant d'un autre joueur.\n" +
                "Celui-ci choisit le sacrifié. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.\n");
        this.setNom("Vampire");
        this.setNbCroyant(1);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        Scanner sc=new Scanner(System.in);
        int choixSacrificeGuide;
        int choixSacrificeCroyant;
        InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
        System.out.println("Entrez le croyant à sacrifier");
        choixSacrificeGuide=sc.nextInt()-1;
        choixSacrificeCroyant=sc.nextInt()-1;
        choixJoueur.sacrifierCroyant(choixSacrificeGuide,choixSacrificeCroyant,p);
    }
}
