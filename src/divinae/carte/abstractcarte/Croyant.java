package divinae.carte.abstractcarte;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;

public abstract class Croyant extends CarteDogme{
    private int nbCroyant;
    private boolean rattachable;
    public Croyant(Origine origine,Dogme[] dogme)
    {
        super(origine,dogme);
        this.rattachable=false;
    }
    public void setNbCroyant(int nbCroyant)
    {
        this.nbCroyant=nbCroyant;
    }
    public boolean getRattachable()
    {
        return this.rattachable;
    }
    public void volerCartes(Joueur j, Partie p){
        Scanner sc=new Scanner(System.in);
        int choixCarte;
        do {
            InterfaceCommand.afficheCarteJoueur(j);
            System.out.println("Quel carte voulez vous voler?");
            System.out.println("0------------Quitter");
            choixCarte=sc.nextInt();
            if(choixCarte<=j.getMain().size() && choixCarte>0)
                j.jouer(choixCarte-1,p);
            else if(choixCarte!=0)
                System.out.println("Choix invalide");
        }while (!j.getMain().isEmpty() && choixCarte>0);

    }
}
