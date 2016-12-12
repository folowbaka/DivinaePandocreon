package divinae;

import divinae.carte.abstractcarte.Carte;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Origine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/*
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

        }//on reinitialise les valeurs peutmachin
        j.setPeutRecevoirPoint(true);
        j.allowSacrifice();

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
    public static void choixAction(Joueur j,Partie p)
    {
        Scanner sc=new Scanner(System.in);
        int choixAct;
        do {
            System.out.println("1------------Jouer une carte Action?");
            System.out.println("2------------Sacrifier une carte?");
            System.out.println("0------------Quitter");
            choixAct=sc.nextInt();
            if(choixAct==1 || choixAct==2)
            {
                switch (choixAct) {
                    case 1:
                        InterfaceCommand.choixJouerCarte(j, p);
                        break;
                    case 2:
                        InterfaceCommand.sacrifierCarte(j, p);
                        break;

                }
            }
        }while (choixAct!=0);

    }
    public static void choixJouerCarte(Joueur j,Partie p)
    {
        Scanner sc=new Scanner(System.in);
        int choixCarte;
        do {
            InterfaceCommand.afficheCarteJoueur(j);
            System.out.println("Quel carte voulez vous jouer?");
            if(!j.getaUtiliseCompetenceDivine())
                System.out.println("8------------Divinité");
            System.out.println("0------------Quitter");
            choixCarte=sc.nextInt();
            if(choixCarte<=j.getMain().size()+1 && choixCarte>0)
                j.jouer(choixCarte-1,p);
            else if(choixCarte!=0)
                System.out.println("Choix invalide");
        }while (!j.getMain().isEmpty() && choixCarte>0);
    }
    public static void sacrifierCarte(Joueur j,Partie p)
    {
        Scanner sc=new Scanner(System.in);
        if(j.getDivinite().getGuideDivinite().size()==0)
            return;
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
                    System.out.println("Entrez le guide à sacrifier");
                    choixSacrificeGuide=sc.nextInt();
                    break;
                case 2:
                    System.out.println("Entrez le croyant à sacrifier");
                    choixSacrificeGuide=sc.nextInt()-1;
                    choixSacrificeCroyant=sc.nextInt()-1;

            }

        }while (choixSacrifice>0);
    }
    public static void afficheCarteJoueur(Joueur j)
    {
        for(int i=0;i<j.getMain().size();i++)
        {
            System.out.println("Carte "+(i+1)+" : "+j.getMain().get(i).getNom());
        }
    }
    public static Joueur choixJoueur(Partie p){
        Scanner sc=new Scanner(System.in);
        int choixJoueur;
        do {
            InterfaceCommand.afficheJoueurs(p);
            System.out.println("Sur quel joueur voulez-vous appliquer l'effet de la carte?");
            choixJoueur=sc.nextInt();
            if(choixJoueur>p.getJoueur().size() || choixJoueur<0)
                System.out.println("Choix invalide");
        }while (choixJoueur>p.getJoueur().size() || choixJoueur<0);
        return p.getJoueur().get(choixJoueur-1);

    }
    public static String choixOriginePoints(Partie p){
        Scanner sc=new Scanner(System.in);
        int choixOrigine;
        System.out.println("Quel origine choisissez-vous pour l'ajout de point d'actions?");
        System.out.println("1 : Jour");
        System.out.println("2 : Nuit");
        System.out.println("3 : Néant");
        choixOrigine=sc.nextInt();
        String out="JOUR";
        switch(choixOrigine){
            case 1:
                out="JOUR";
            break;
            case 2:
                out="NUIT";
            break;
            case 3:
                out="NEANT";
            break;

        }
        return out;


    }
    public static void afficheJoueurs(Partie p){
        for(int i=0;i<p.getJoueur().size();i++)
        {
            System.out.println("Joueur "+(i+1)+" : "+p.getJoueur().get(i).getNom());
        }
    }
    public static void afficheCartesSacrifiable(Joueur joueur){
        for(int i=0;i<joueur.getDivinite().getGuideDivinite().size();i++)
        {
            System.out.println("Guide : "+(i+1)+" "+joueur.getDivinite().getGuideDivinite().get(i).getNom());
            for (int j=0;j< joueur.getDivinite().getGuideDivinite().get(i).getCroyantRattache().length;j++){
                System.out.println("Croyant "+(j+1)+" : "+joueur.getDivinite().getGuideDivinite().get(i).getCroyantRattache()[j].getNom());
            }
        }
    }
    public static void afficheGuides(Joueur joueur){
        for(int i=0;i< joueur.getDivinite().getGuideDivinite().size();i++){
            System.out.println("Carte "+(i+1)+" : "+joueur.getDivinite().getGuideDivinite().get(i));
        }
    }
    public static int choixGuide(Joueur joueur, Partie p){
        Scanner sc=new Scanner(System.in);
        int choixGuide;
        do{
            InterfaceCommand.afficheGuides(joueur);
            System.out.println("Choisissez un guide à défausser.");
            choixGuide=sc.nextInt();
            if (choixGuide>joueur.getDivinite().getGuideDivinite().size() || choixGuide<0){
                System.out.println("Choix invalide");
            }
        }while (choixGuide>joueur.getDivinite().getGuideDivinite().size() || choixGuide<0);
        return choixGuide-1;
    }

}
