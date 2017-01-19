package divinae.carte.deusEx;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

import java.util.Scanner;

public class Phoenix extends DeusEx {

    public Phoenix(Origine origine,String cheminCarte) {
        super(origine,cheminCarte);
        this.setDescription("Permet de bénéficier de la\n" +
                "capacité spéciale de l'un de\n" +
                "vos Croyants ou Guides\n" +
                "Spirituels sans sacrifier la\n" +
                "carte.\n");
        this.setNom("Phoenix");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Scanner sc=new Scanner(System.in);
        if(j.getDivinite().getGuideDivinite().size()==0)
        {
            System.out.println("Aucune carte à sacrifier");
            return;
        }
        int choixSacrificeGuide;
        int choixSacrificeCroyant;
        int choixSacrifice;
        do {
            InterfaceCommand.afficheCartesSacrifiable(j);
            System.out.println("Quel carte voulez sacrifier?");
            System.out.println("1------------Guide");
            System.out.println("2------------Croyant");
            System.out.println("0------------Quitter");
            choixSacrifice=sc.nextInt();
            switch (choixSacrifice)
            {
                case 1:
                    if(j.getPeutSacrifierGuide())
                    {
                        System.out.println("Entrez le guide à sacrifier");
                        choixSacrificeGuide = sc.nextInt()-1;
                        j.getDivinite().getGuideDivinite().get(choixSacrificeGuide).capacite(j,p);
                    }
                    break;
                case 2:
                    if(j.getPeutSacrifierCroyant())
                    {
                        System.out.println("Entrez le croyant à sacrifier");
                        choixSacrificeGuide = sc.nextInt() - 1;
                        choixSacrificeCroyant = sc.nextInt() - 1;
                        j.getDivinite().getGuideDivinite().get(choixSacrificeCroyant).capacite(j,p);
                    }
                    break;


            }

        }while (choixSacrifice>0);

    }
}
