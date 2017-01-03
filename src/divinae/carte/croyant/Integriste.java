package divinae.carte.croyant;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

import java.util.Scanner;

public class Integriste extends Croyant {
    public Integriste(Dogme[] dogme, Image imgCarte) {
        super(Origine.JOUR,dogme,imgCarte);
        this.setDescription("Sacrifice :\nImpose le sacrifice d'un Guide\n" +
                "Spirituel d'un autre joueur,\n" +
                "qui choisit la carte. La\n" +
                "capacité spéciale du sacrifice\n" +
                "est jouée.\n");
        this.setNom("Integriste");
        this.setNbCroyant(1);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        Scanner sc=new Scanner(System.in);
        int choixSacrificeGuide;
        InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
        System.out.println("Entrez le guide à sacrifier");
        choixSacrificeGuide=sc.nextInt()-1;
        choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).capacite(choixJoueur,p);
    }
}
