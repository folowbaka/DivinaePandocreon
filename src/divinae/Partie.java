package divinae;

import java.util.Scanner;

/**
 * Created by david on 21/11/2016.
 */
public class Partie {
    private Joueur[] joueur;
    private static Partie ourInstance = null;

    public static Partie getInstance()
    {
       if(ourInstance==null)
       {
           ourInstance=new Partie();
       }
        return ourInstance;
    }
    public void choisirJoueur() {
        Scanner choixUtilisateur = new Scanner(System.in);
        int nbJoueur;
        do {
            System.out.println("Veuillez choisir le nombre de joueur");
            nbJoueur = choixUtilisateur.nextInt();
        } while (nbJoueur > 2 && nbJoueur < 7);
        this.joueur=new Joueur[nbJoueur];
    }
    private Partie()
    {
        System.out.println("Partie créée");
    }

}
