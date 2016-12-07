package divinae;

import divinae.carte.abstractcarte.Carte;
import divinae.carte.croyant.*;
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
        this.pioche.add(new Moine(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE}));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Moine(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS}));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.MYSTIQUE,Dogme.MYSTIQUE,Dogme.CHAOS}));
        this.pioche.add(new Ermite(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Ermite(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Integriste(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new GuerrierSaint(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Diplomate(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Demon(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE}));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Demon(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS}));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.SYMBOLE,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.SYMBOLE,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Vampire(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Vampire(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Lycanthrope(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Pillar(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Illusionniste(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE}));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS}));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Revenant(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE}));
        this.pioche.add(new Revolutionnaire(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Nihilliste(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS}));



    }
    @Override
    public String toString() {
        return "Partie{" +
                "joueur=" + Arrays.toString(joueur) +
                '}';
    }
}
