package divinae;

import divinae.carte.Apocalypse;
import divinae.carte.abstractcarte.Carte;
import divinae.carte.abstractcarte.Divinite;
import divinae.carte.croyant.*;
import divinae.carte.deusEx.*;
import divinae.carte.divinite.*;
import divinae.carte.guide.*;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.*;

import static java.util.Collections.shuffle;

/*
 * Created by david on 21/11/2016.
 */
public class Partie {
    private ArrayList<Joueur> joueur;
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
        this.joueur=new ArrayList<Joueur>();
        for(int i=0;i<nomJoueur.length;i++)
        {
            this.joueur.add(new Joueur(nomJoueur[i]));
        }
        this.pioche= new ArrayList<Carte>();
        remplirPioche();
        this.distribDivinite();
        this.commencerPartie();
    }
    public void commencerPartie()
    {

        int j=0;
        Origine origineTour=this.lancerDes();
        System.out.println(origineTour);
        while(j<this.joueur.size())
        {
            this.joueur.get(j).ajoutPoints(origineTour);
            System.out.println(this.joueur.get(j));
            j++;
        }

    }
    public Origine lancerDes()
    {
        Random rd=new Random();
        int des=rd.nextInt(3);
        System.out.println(des);
        switch(des)
        {
            case 0:
                return Origine.JOUR;
            case 1:
                return Origine.NUIT;
            case 2:
                return Origine.NEANT;
            default:
                return null;
        }
    }

    public void distribDivinite()
    {
        ArrayList<Divinite> divin=new ArrayList<Divinite>();
        Collections.addAll(divin,new Brewalen(),new Drinded(),new Gorpa(),new Gwenghelen(),new Killinstred(),new Llewella(),new PuiTara(),new Romtec(),new Shingva(),new Yarstur());
        Random rd=new Random();
        for(int i=0;i<this.joueur.size();i++)
        {

            this.joueur.get(i).setDivinite(divin.remove(rd.nextInt(divin.size())));
        }
    }
    public void remplirPioche()
    {
        //Ajout Croyant
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
        //Ajout Guide
        this.pioche.add(new Martyr(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN}));
        this.pioche.add(new Martyr(Origine.NUIT,new Dogme[]{Dogme.HUMAIN,Dogme.SYMBOLE}));
        this.pioche.add(new Martyr(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Clerc(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE}));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.CHAOS}));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.MYSTIQUE,Dogme.SYMBOLE}));
        this.pioche.add(new Clerc(Origine.NEANT,new Dogme[]{Dogme.SYMBOLE,Dogme.CHAOS}));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.MYSTIQUE,Dogme.CHAOS}));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN}));
        this.pioche.add(new Shaman(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.SYMBOLE}));
        this.pioche.add(new Anarchiste(Origine.NEANT,new Dogme[]{Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Paladin(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE}));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.CHAOS}));
        this.pioche.add(new Ascete(Origine.NUIT,new Dogme[]{Dogme.HUMAIN,Dogme.SYMBOLE}));
        this.pioche.add(new Devin(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE}));
        this.pioche.add(new Exorciste(Origine.JOUR,new Dogme[]{Dogme.MYSTIQUE,Dogme.CHAOS}));
        this.pioche.add(new Sorcier(Origine.NUIT,new Dogme[]{Dogme.MYSTIQUE,Dogme.SYMBOLE}));
        this.pioche.add(new Tyran(Origine.NEANT,new Dogme[]{Dogme.SYMBOLE,Dogme.CHAOS}));
        this.pioche.add(new Messie(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE}));
        //AJOUT Deus Ex
        this.pioche.add(new ColereDivine(Origine.JOUR));
        this.pioche.add(new ColereDivine(Origine.NUIT));
        this.pioche.add(new Stase(Origine.JOUR));
        this.pioche.add(new OrdreCeleste(Origine.JOUR));
        this.pioche.add(new Fourberie(Origine.NUIT));
        this.pioche.add(new Diversion(Origine.NUIT));
        this.pioche.add(new Concentration(Origine.NEANT));
        this.pioche.add(new TrouNoir(Origine.NEANT));
        this.pioche.add(new Phoenix(Origine.NEANT));
        this.pioche.add(new InfluenceJour(null));
        this.pioche.add(new InfluenceNuit(null));
        this.pioche.add(new InfluenceNeant(null));
        this.pioche.add(new InfluenceNulle(null));
        this.pioche.add(new InfluenceNulle(null));
        this.pioche.add(new Transe(null));
        this.pioche.add(new Miroir(null));
        this.pioche.add(new Bouleversement(null));
        this.pioche.add(new Inquisition(null));
        //Ajout Apocalypse
        this.pioche.add(new Apocalypse(Origine.JOUR));
        this.pioche.add(new Apocalypse(Origine.NUIT));
        this.pioche.add(new Apocalypse(Origine.NEANT));
        this.pioche.add(new Apocalypse(null));
        this.pioche.add(new Apocalypse(null));
        shuffle(this.pioche);

    }



    @Override
    public String toString() {
        return "Partie{" +
                "joueur=" + joueur;
    }
}
