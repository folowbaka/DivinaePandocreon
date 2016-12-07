package divinae;

import divinae.carte.abstractcarte.Carte;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by david on 07/12/2016.
 */
public class InterfaceCommand {


    public InterfaceCommand() {


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
                System.out.println("Veuillez rentrer le nom du Joueur "+(i+1));
                nomJoueur[i]=choixUtilisateur.next();
            }

        }
        return nomJoueur;
    }
}
