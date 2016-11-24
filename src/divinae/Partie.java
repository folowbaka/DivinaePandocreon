package divinae;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by david on 21/11/2016.
 */
public class Partie {
    private Joueur[] joueur;
    private ArrayList<Carte> pioche;
    private static Partie ourInstance = null;

    public static Partie getInstance(String[] nomJoueur)
    {
       if(ourInstance==null)
       {
           ourInstance=new Partie(nomJoueur);
       }
        return ourInstance;
    }
    public static String[] choisirJoueur() {
        Scanner choixUtilisateur = new Scanner(System.in);
        int nbJoueur=-1;
        do {
            System.out.println("Veuillez choisir le nombre de joueur");
            try {
                nbJoueur = choixUtilisateur.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Erreur de saisie");
                choixUtilisateur.next();
            }
        } while (nbJoueur<2 || nbJoueur > 6);
        String[] nomJoueur=new String[nbJoueur];
        String choix="";
        do
        {
            System.out.println("Voulez vous jouez avec des joueur virtuels?");
            choix = choixUtilisateur.next();
            System.out.println(choix);
        }while(!choix.equals("oui") && !choix.equals("non"));
        if(choix.equals("non"))
        {
            for(int i=0;i<nbJoueur;i++)
            {
                System.out.println("Veuillez rentrer le nom du Joueur "+i);
                nomJoueur[i]=choixUtilisateur.next();
            }

        }
        return nomJoueur;
    }
    private Partie(String[] nomJoueur)
    {
        System.out.println("Partie créée");
        this.joueur=new Joueur[nomJoueur.length];
        for(int i=0;i<nomJoueur.length;i++)
        {
            this.joueur[i]=new Joueur(nomJoueur[i]);
        }
        this.pioche=new ArrayList<Carte>();
        Collection.shuffle(this.pioche);
    }
    public void remplirPioche()
    {

    }
    @Override
    public String toString() {
        return "Partie{" +
                "joueur=" + Arrays.toString(joueur) +
                '}';
    }
}
