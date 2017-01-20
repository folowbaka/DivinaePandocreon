package Vue;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.Apocalypse;
import divinae.carte.abstractcarte.Carte;
import divinae.enumeration.Origine;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contient l'ensemble des methodes (static) utilises pour faire tourner le jeu.
 */
public class InterfaceCommand {


    public InterfaceCommand()
    {


    }

    /**
     * En debut de partie, demande le nombre de joueurs reels et virtuels.
     * @return un tableau de tableau.
     */
    public static String[][] choisirJoueur() {
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
        String[][] nomJoueur=new String[2][nbJoueur];
        String choix="";
        do
        {
            System.out.println("Voulez vous jouez avec des joueur virtuels[o/n]?");
            choix = choixUtilisateur.next();
        }while(!choix.equals("o") && !choix.equals("n"));
        if(choix.equals("n"))
        {
            for(int i=0;i<nbJoueur;i++)
            {
                System.out.println("Veuillez rentrer le nom du Joueur "+(i+1));
                nomJoueur[0][i]=choixUtilisateur.next();
            }

        }
        else
        {
            System.out.println("Combien de joueurs virtuel voulez vous? ");
            int nbVirtuel;
            nbVirtuel=choixUtilisateur.nextInt();
            for(int i=0;i<nbJoueur-nbVirtuel;i++)
            {
                System.out.println("Veuillez rentrer le nom du Joueur "+(i+1));
                nomJoueur[0][i]=choixUtilisateur.next();
            }
            for(int i=0;i<nbJoueur-(nbJoueur-nbVirtuel);i++)
            {
                nomJoueur[1][i]="JV "+(i+1);
            }
        }
        return nomJoueur;
    }

    /**
     * Methode qui permet a un joueur d'effectuer son tour.
     * @param j joueur
     * @param p partie
     * @param joueurJoue
     */
    public static void jouer(Joueur j, Partie p, int joueurJoue)
    {
        System.out.println("C'est à vous de jouer joueur : "+j.getNom());
        boolean tour=true;
        Scanner sc=new Scanner(System.in);
        int choix;
        boolean defausser=false;
        while(tour)
        {       InterfaceCommand.afficheCarteJoueur(j);
                System.out.println("---------------1-Défausser Carte");
                System.out.println("---------------2-Compléter main");
                System.out.println("---------------3-Jouer ou Sacrifier Carte");
                if(p.checkInterrompre(joueurJoue))
                    System.out.println("---------------9-Interrompre");
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
                            System.out.println("---------------3-Jouer ou Sacrifier Carte");
                            if(p.checkInterrompre(joueurJoue))
                                System.out.println("---------------9-Interrompre");
                            break;
                        case 2:
                                if(j.getMain().size()!=Joueur.TAILLEMAIN)
                                {
                                    j.completerMain(p);
                                    InterfaceCommand.afficheCarteJoueur(j);
                                }
                                else
                                    System.out.println("Votre main est déja pleine");
                                System.out.println("---------------3-Jouer ou Sacrifier Carte");
                            if(p.checkInterrompre(joueurJoue))
                                System.out.println("---------------9-Interrompre");
                            break;
                        case 3:
                            InterfaceCommand.choixAction(j,p,joueurJoue);
                            tour=false;
                            break;
                        case 9:
                            InterfaceCommand.interrompre(j,p,joueurJoue);
                            break;
                        case 0:
                            tour = false;
                    }
                    System.out.println("---------------0-Terminer Tour");
                }while(choix>0 && choix<3);

        }//on reinitialise les valeurs peutmachin

        j.setPeutRecevoirPoint(true);
        j.allowSacrificeCroyant();
        j.allowSacrificeGuide();
    }

    /**
     * Demande au joueur si il souhaite depenser ses points et verifie si il en a assez.
     * En parametre le numero de la carte dans la main du joueur.
     * @param joueur
     * @param numCarte
     * @param partie
     * @param joueurJoue
     */
    public static void pointJouer(Joueur joueur,int numCarte,Partie partie,int joueurJoue)
    {
        Carte carte=joueur.getMain().get(numCarte);
        int point=joueur.getPointsAction().get(carte.getOrigine().toString());
        if(!joueur.pointPourJouer(carte))
        {
            System.out.println("Vous n'avez pas assez de points pour jouer");
            return ;
        }
        Scanner sc=new Scanner(System.in);
        if(point>0)
        {
            joueur.getPointsAction().put(carte.getOrigine().toString(),point-1);
        }
        else if(point<=0 && carte.getOrigine()==Origine.NEANT)
        {
            int choixPoint;
            if(joueur.getPointsAction().get("NUIT")>1 && joueur.getPointsAction().get("JOUR")>1)
            {
                System.out.println("1---------Dépenser 2 points Nuit?");
                System.out.println("2---------Dépenser 2 points Jour?");
                System.out.println("0---------Annuler");
                choixPoint=sc.nextInt();
                if(choixPoint==0)
                    return;
                if(choixPoint==1)
                    joueur.getPointsAction().put("NUIT",joueur.getPointsAction().get("NUIT")-2);
                if(choixPoint==2)
                    joueur.getPointsAction().put("JOUR",joueur.getPointsAction().get("JOUR")-2);
            }
            else if(joueur.getPointsAction().get("NUIT")>1)
            {
                System.out.println("1---------Dépenser 2 points Nuit?");
                System.out.println("0---------Annuler");
                choixPoint=sc.nextInt();
                if(choixPoint==0)
                    return;
                if(choixPoint==1)
                    joueur.getPointsAction().put("NUIT",joueur.getPointsAction().get("NUIT")-2);
            }
            else if(joueur.getPointsAction().get("JOUR")>1)
            {
                System.out.println("1---------Dépenser 2 points Jour?");
                System.out.println("0---------Annuler");
                choixPoint=sc.nextInt();
                if(choixPoint==0)
                    return;
                if(choixPoint==1)
                    joueur.getPointsAction().put("JOUR",joueur.getPointsAction().get("JOUR")-2);
            }
        }
        if(partie.checkInterrompre(joueurJoue))
        {
            int inte;
            System.out.println("9---------Interrompre");
            inte=sc.nextInt();
            switch (inte)
            {
                case 9:
                    InterfaceCommand.interrompre(joueur,partie,joueurJoue);
            }
        }
        joueur.jouer(numCarte,partie);
    }

    /**
     * Permet au joueur de choisir quelle carte il souhaite defausser.
     * @param j joueur
     * @param p partie
     */
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

    /**
     * Permet au joueur de choisir quelle action il souhaite executer.
     * @param j joueur
     * @param p partie
     * @param joueurJoue
     */
    public static void choixAction(Joueur j,Partie p,int joueurJoue)
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
                        InterfaceCommand.choixJouerCarte(j, p,joueurJoue);
                        break;
                    case 2:
                        InterfaceCommand.sacrifierCarte(j, p);
                        break;

                }
            }
        }while (choixAct!=0);

    }

    /**
     * Choix de la carte a jouer.
     * @param j joueur
     * @param p partie
     * @param joueurJoue
     */
    public static void choixJouerCarte(Joueur j,Partie p,int joueurJoue)
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
                InterfaceCommand.pointJouer(j,choixCarte-1,p,joueurJoue);
            else if(choixCarte!=0)
                System.out.println("Choix invalide");
        }while (!j.getMain().isEmpty() && choixCarte>0);
    }
    public static void sacrifierCarte(Joueur j,Partie p)
    {
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
                        j.sacrifierGuide(choixSacrificeGuide,p);
                    }
                    break;
                case 2:
                    if(j.getPeutSacrifierCroyant())
                    {
                        System.out.println("Entrez le croyant à sacrifier");
                        choixSacrificeGuide = sc.nextInt() - 1;
                        choixSacrificeCroyant = sc.nextInt() - 1;
                        j.sacrifierCroyant(choixSacrificeGuide,choixSacrificeCroyant,p);
                    }
                    break;


            }

        }while (choixSacrifice>0);
    }

    /**
     * Affiche les cartes dans la main d'un joueur en ligne de commande.
     * @param j joueur
     */
    public static void afficheCarteJoueur(Joueur j)
    {
        for(int i=0;i<j.getMain().size();i++)
        {
            System.out.println("Carte "+(i+1)+" : "+j.getMain().get(i).getNom());
        }
    }

    /**
     * Choix d'un joueur
     * @param p partie
     * @return
     */
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

    /**
     * Choisir une origine pour l'ajout de points.
     * @param p partie
     * @return
     */
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

    /**
     * Affiche les joueurs presents dans la partie.
     * @param p partie
     */
    public static void afficheJoueurs(Partie p){
        for(int i=0;i<p.getJoueur().size();i++)
        {
            System.out.println("Joueur "+(i+1)+" : "+p.getJoueur().get(i).getNom());
        }
    }

    /**
     * Affiche les cartes sacrifiable par un joueur.
     * @param joueur
     */
    public static void afficheCartesSacrifiable(Joueur joueur){
        for(int i=0;i<joueur.getDivinite().getGuideDivinite().size();i++)
        {
            System.out.println("Guide : "+(i+1)+" "+joueur.getDivinite().getGuideDivinite().get(i).getNom());
            for (int j=0;j< joueur.getDivinite().getGuideDivinite().get(i).getCroyantRattache().length;j++){
                System.out.println("Croyant "+(j+1)+" : "+joueur.getDivinite().getGuideDivinite().get(i).getCroyantRattache()[j].getNom());
            }
        }
    }

    /**
     * Affiche les guides d'un joueur.
     * @param joueur
     */
    public static void afficheGuides(Joueur joueur){
        for(int i=0;i< joueur.getDivinite().getGuideDivinite().size();i++){
            System.out.println("Carte "+(i+1)+" : "+joueur.getDivinite().getGuideDivinite().get(i));
        }
    }

    /**
     * Choix d'un guide parmis ceux qui lui sont associes
     * @param joueur
     * @param p partie
     * @return
     */
    public static int choixGuide(Joueur joueur, Partie p){
        Scanner sc=new Scanner(System.in);
        int choixGuide;
        do{
            InterfaceCommand.afficheGuides(joueur);
            System.out.println("Choisissez un guide.");
            choixGuide=sc.nextInt();
            if (choixGuide>joueur.getDivinite().getGuideDivinite().size() || choixGuide<0){
                System.out.println("Choix invalide");
            }
        }while (choixGuide>joueur.getDivinite().getGuideDivinite().size() || choixGuide<0);
        return choixGuide-1;
    }

    /**
     * Choix du joueur a interrompre.
     * @param j joueur
     * @param p partie
     * @param joueurJoue
     */
    public static void  interrompre(Joueur j,Partie p,int joueurJoue)
    {
        Scanner sc=new Scanner(System.in);
        int joueur;
        System.out.println("Quel joueur souhaite interrompre?");
        joueur=sc.nextInt()-1;
        if(joueur!=joueurJoue)
        InterfaceCommand.afficheCarteSansOrigin(p.getJoueur().get(joueur));

    }

    /**
     * Choix parmis les cartes sans origines.
     * @param j joueur
     * @param p partie
     */
    public static void choixSansOrigin(Joueur j,Partie p)
    {
        Scanner sc=new Scanner(System.in);
        int choixCarteSO;
        do {
            InterfaceCommand.afficheCarteSansOrigin(j);
            System.out.println("Quel carte voulez vous utiliser?");
            System.out.println("0------------Quitter");
            choixCarteSO=sc.nextInt();
            if(j.getMain().get(choixCarteSO-1).getOrigine()==null)
            {
                j.jouer(choixCarteSO-1,p);
            }
        }while (choixCarteSO>0 && j.getMain().get(choixCarteSO).getOrigine()!=null);
    }

    /**
     * Affiche les cartes sans origines.
     * @param j joueur
     */
    public static void afficheCarteSansOrigin(Joueur j)
    {
        for(int i=0;i<j.getMain().size();i++)
        {
            if(j.getMain().get(i) instanceof Apocalypse && Partie.APOCALYPSE)
            {
                System.out.println("Carte : "+(i+1)+" "+j.getMain().get(i).getNom());
            }
            else if(j.getMain().get(i).getOrigine()==null)
            {
                System.out.println("Carte : "+(i+1)+" "+j.getMain().get(i).getNom());
            }
        }
    }

}
