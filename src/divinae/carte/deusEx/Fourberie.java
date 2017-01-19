package divinae.carte.deusEx;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

import java.util.Scanner;

public class Fourberie extends DeusEx {

    public Fourberie(Origine origine,String cheminCarte)
    {

        super(origine,cheminCarte);
        this.setDescription("Sacrifiez 2 cartes Croyants\n" +
                "d'une autre Divinité. Les\n" +
                "capacités spéciales ne sont pas\n" +
                "jouées.\n");
        this.setNom("Fourberie");
    }

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
            choixSacrificeCroyant = sc.nextInt() - 1;
            p.getDefausse().add(choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getCroyantRattache()[choixSacrificeCroyant]);
            choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).getCroyantRattache()[choixSacrificeCroyant] = null;
            if (choixJoueur.getDivinite().getGuideDivinite().get(choixSacrificeGuide).aCroyantRattache())
                p.getDefausse().add(choixJoueur.getDivinite().getGuideDivinite().remove(choixSacrificeCroyant));
        }
    }
}
