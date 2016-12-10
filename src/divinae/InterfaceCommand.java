package divinae;

import divinae.carte.abstractcarte.Carte;
import divinae.carte.abstractcarte.GuideSpirituel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by david on 07/12/2016.
 */
public class InterfaceCommand {


    public InterfaceCommand()
    {


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
    public static void jouer(Joueur j,Partie p)
    {
        System.out.println("C'est à vous de jouer joueur : "+j.getNom());
        System.out.println(j);
        boolean tour=true;
        Scanner sc=new Scanner(System.in);
        int choix;
        boolean defausser=false;
        while(tour)
        {       InterfaceCommand.afficheCarteJoueur(j);
                System.out.println("---------------1-Défausser Carte");
                System.out.println("---------------2-Compléter main");
                System.out.println("---------------3-Jouer Carte");
                System.out.println("---------------0-Terminer Tour");
                do
                {
                    choix = sc.nextInt();
                    switch (choix) {
                        case 1:
                            if(!j.getMain().isEmpty() &&!defausser)
                            {
                                InterfaceCommand.choixDefausseCarte(j, p);
                                defausser=true;
                            }
                            else
                                System.out.println("Votre main est déjà vide ou vous avez déjà défaussé des cartes pendant ce tour");
                            System.out.println("---------------2-Compléter main");
                            System.out.println("---------------3-Jouer Carte");
                            break;
                        case 2:
                                if(j.getMain().size()!=Joueur.TAILLEMAIN)
                                {
                                    j.completerMain(p);
                                    InterfaceCommand.afficheCarteJoueur(j);
                                }
                                else
                                    System.out.println("Votre main est déja pleine");
                                System.out.println("---------------3-Jouer Carte");
                            break;
                        case 3:
                            InterfaceCommand.choixJouerCarte(j,p);
                            tour=false;
                            break;
                        case 0:
                            tour = false;
                    }
                    System.out.println("---------------0-Terminer Tour");
                }while(choix>0 && choix<3);
                /*if(choix==0)
                    tour=false;
                else
                {
                    j.jouer(j.getMain().get(choix-1));
                }*/

        }
    }
    public static void choixDefausseCarte(Joueur j,Partie p) {
        Scanner sc=new Scanner(System.in);
        int choixCarte;
        do {
            InterfaceCommand.afficheCarteJoueur(j);
            System.out.println("Quel carte voulez vous défausser?");
            System.out.println("0------------Quitter");
            choixCarte=sc.nextInt();
            if(choixCarte<=j.getMain().size() && choixCarte>0)
            j.defausseCarte(choixCarte-1,p);
            else if(choixCarte!=0)
                System.out.println("Choix invalide");
        }while (!j.getMain().isEmpty() && choixCarte>0);
    }
    public static void choixJouerCarte(Joueur j,Partie p)
    {
        Scanner sc=new Scanner(System.in);
        int choixCarte;
        do {
            InterfaceCommand.afficheCarteJoueur(j);
            System.out.println("Quel carte voulez vous jouer?");
            System.out.println("0------------Quitter");
            choixCarte=sc.nextInt();
            if(choixCarte<=j.getMain().size() && choixCarte>0)
                j.jouer(choixCarte-1,p);
            else if(choixCarte!=0)
                System.out.println("Choix invalide");
        }while (!j.getMain().isEmpty() && choixCarte>0);
    }
    public static void afficheCarteJoueur(Joueur j)
    {
        for(int i=0;i<j.getMain().size();i++)
        {
            System.out.println("Carte "+(i+1)+" : "+j.getMain().get(i).getNom());
        }
    }
}
