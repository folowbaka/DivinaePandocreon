package divinae;

import divinae.carte.abstractcarte.Carte;
import divinae.carte.croyant.Moine;
import divinae.enumeration.Dogme;

import java.util.*;

/*
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
    private Partie(String[] nomJoueur)
    {
        System.out.println("Partie créée");
        this.joueur=new Joueur[nomJoueur.length];
        for(int i=0;i<nomJoueur.length;i++)
        {
            this.joueur[i]=new Joueur(nomJoueur[i]);
        }
        this.pioche=new ArrayList<Carte>();
        remplirPioche();
        //Collection.shuffle(this.pioche);
    }
    public void remplirPioche()
    {
        Dogme[] dog={Dogme.HUMAIN,Dogme.HUMAIN};

    }
    @Override
    public String toString() {
        return "Partie{" +
                "joueur=" + Arrays.toString(joueur) +
                '}';
    }
}
