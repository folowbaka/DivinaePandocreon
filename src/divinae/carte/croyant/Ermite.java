package divinae.carte.croyant;

import divinae.Joueur;
import divinae.InterfaceCommand;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;

public class Ermite extends Croyant {
    public Ermite( Dogme[] dogme) {
        super(Origine.JOUR, dogme);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un\n" +
                "Croyant d'un autre joueur,\n" +
                "qui choisit la carte. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.");
        this.setNom("Ermite");
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
        choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getCroyantRattache()[choixSacrificeCroyant].capacite(choixJoueur,p);

    }
}
