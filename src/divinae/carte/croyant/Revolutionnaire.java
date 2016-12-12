package divinae.carte.croyant;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;

public class Revolutionnaire extends Croyant {

    public Revolutionnaire(Dogme[] dogme) {
        super(Origine.NEANT,dogme);
        this.setDescription("Sacrifice :\nImposez le sacrifice d'une\n" +
                "carte de Croyants à autant de\n" +
                "Divinités que vous le voulez.\n" +
                "Chaque Divinité choisit la\n" +
                "carte à sacrifier. Les capacités\n" +
                "spéciales sont jouées.");
        this.setNom("Revolutionnaire");
        this.setNbCroyant(2);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Scanner sc=new Scanner(System.in);
        int nbJoueursSacrifice;
        System.out.println("A combien de joueurs voulez-vous faire sacrifier un croyant?");
        do{
            nbJoueursSacrifice = sc.nextInt();
            if (nbJoueursSacrifice<1 || nbJoueursSacrifice>p.getJoueur().size()){
                System.out.println("Nombre incorrect.");
            }
        }while(nbJoueursSacrifice<1 || nbJoueursSacrifice>p.getJoueur().size());

        for (int i =0; i<nbJoueursSacrifice; i++){
            Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
            int choixSacrificeGuide;
            int choixSacrificeCroyant;
            InterfaceCommand.afficheCartesSacrifiable(choixJoueur);
            System.out.println("Entrez le croyant à sacrifier");
            choixSacrificeGuide=sc.nextInt()-1;
            choixSacrificeCroyant=sc.nextInt()-1;
            choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getCroyantRattache()[choixSacrificeCroyant].capacite(choixJoueur,p);
        }

    }
}
