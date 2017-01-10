package divinae;

import divinae.carte.Apocalypse;
import divinae.carte.abstractcarte.Carte;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.Divinite;
import divinae.carte.croyant.*;
import divinae.carte.deusEx.*;
import divinae.carte.divinite.*;
import divinae.carte.guide.*;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import divinae.strategie.*;
import javafx.scene.image.Image;

import java.util.*;
import java.util.Random;

import static java.util.Collections.shuffle;

/*
 * Created by david on 21/11/2016.
 */
public class Partie {
    private ArrayList<Joueur> joueur;
    private ArrayList<Carte> pioche;
    private ArrayList<Carte> defausse;
    private ArrayList<Croyant> centreTable;
    private static Partie ourInstance = null;
    public static boolean PARTIENONFINIE=true;
    public static boolean APOCALYPSE=false;
    private boolean fintour;
    private Origine influenceTour;

    public static Partie getInstance(String[][] nomJoueur)
    {
       if(ourInstance==null)
       {
           ourInstance=new Partie(nomJoueur);
       }
        return ourInstance;
    }
    private Partie(String[][] nomJoueur)
    {
        System.out.println("Partie créée");
        this.joueur=new ArrayList<Joueur>();
        if(nomJoueur[1][0]==null)
        {

            System.out.println();
            for (int i = 0; i < nomJoueur[0].length; i++) {
                this.joueur.add(new Joueur(nomJoueur[0][i]));
            }
        }
        else
        {
            int i=0;
            Random rd=new Random();
            while(i<nomJoueur[0].length && nomJoueur[0][i]!=null)
            {
                this.joueur.add(new Joueur(nomJoueur[0][i]));
                i++;
            }
            i=0;
            while(i<nomJoueur[0].length && nomJoueur[0][i]!=null)
            {
                if(rd.nextInt()==0)
                    this.joueur.add(new JoueurVirtuel(nomJoueur[1][i],new Prudent()));
                else
                    this.joueur.add(new JoueurVirtuel(nomJoueur[1][i],new RNG()));
                i++;
            }
        }
        this.pioche= new ArrayList<Carte>();
        this.defausse= new ArrayList<Carte>();
        this.centreTable=new ArrayList<Croyant>();
        this.fintour=false;
        remplirPioche();
        this.distribDivinite();
        this.distribCarte();
    }

    public static void setOurInstance(Partie ourInstance) {
        Partie.ourInstance = ourInstance;
    }

    public void commencerPartie()
    {
        int tour=0;

        while(PARTIENONFINIE)
        {
            int j=0;
            this.setInfluenceTour(this.lancerDes());
            if(tour==1)
                APOCALYPSE=true;
            fintour=false;
            while (j < this.joueur.size() && !fintour)
            {
                this.joueur.get(j).ajoutPoints(this.influenceTour);
                if(this.joueur.get(j) instanceof JoueurVirtuel)
                {
                    ((JoueurVirtuel) this.joueur.get(j)).getStrategie().jouer(this.joueur.get(j),this);
                }
                else
                InterfaceCommand.jouer(this.joueur.get(j), this,j);
                if(!fintour && APOCALYPSE==false)
                    APOCALYPSE=true;
                if(fintour && !APOCALYPSE)
                {
                    ArrayList<Joueur> joueur2=new ArrayList<Joueur>();
                    for(int k=j;k<this.joueur.size();k++)
                        joueur2.add(this.joueur.get(k));
                    for(int k=0;k<j;k++)
                        joueur2.add(this.joueur.get(k));
                    this.joueur=null;
                    this.joueur=joueur2;

                }

                System.out.println(this.joueur.get(j));
                j++;
            }

            tour++;
        }

    }
    public Origine lancerDes()
    {
        int des= (int) (Math.random() * 3);
        System.out.println("Point "+des);
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
        Collections.addAll(divin,new Brewalen(new Image("ressource/image/carte/brewalen.jpg")),new Drinded(new Image("ressource/image/carte/drinded.jpg")),new Gorpa(new Image("ressource/image/carte/gorpa.jpg")),new Gwenghelen(new Image("ressource/image/carte/gwenghelen.jpg")),new Killinstred(new Image("ressource/image/carte/killinstred.jpg")),new Llewella(new Image("ressource/image/carte/llewella.jpg")),new PuiTara(new Image("ressource/image/carte/puitara.jpg")),new Romtec(new Image("ressource/image/carte/romtec.jpg")),new Shingva(new Image("ressource/image/carte/shingva.jpg")),new Yarstur(new Image("ressource/image/carte/yarstur.jpg")));
        Random rd=new Random();
        for(int i=0;i<this.joueur.size();i++)
        {

            this.joueur.get(i).setDivinite(divin.remove(rd.nextInt(divin.size())));
        }
    }
    public void distribCarte()
    {
        for(int i=0;i<this.joueur.size();i++)
        {
            for(int j=0;j<7;j++)
            {
                this.joueur.get(i).pioche(this);
            }
        }
    }
    public boolean checkInterrompre(int joueurJoue)
    {
        int i=0;
        boolean interrompre=false;
        while(i<this.joueur.size() &&!interrompre)
        {
            int j=0;
            if(i!=joueurJoue)
            while(j<this.joueur.get(i).getMain().size() && !interrompre)
            {
                if(this.joueur.get(i).getMain().get(j) instanceof Apocalypse && APOCALYPSE)
                    interrompre=true;
                else if(this.joueur.get(i).getMain().get(j).getOrigine()==null && !(this.joueur.get(i).getMain().get(j) instanceof Apocalypse))
                    interrompre=true;
                j++;
            }
            i++;
        }
        return interrompre;
    }
    public ArrayList<Carte> getPioche()
    {
        return this.pioche;
    }
    public ArrayList<Carte> getDefausse()
    {
        return this.defausse;
    }
    public ArrayList<Joueur> getJoueur(){
        return this.joueur;
    }
    public ArrayList<Croyant> getCentreTable(){return this.centreTable;}
    public Origine getInfluenceTour() {
        return influenceTour;
    }
    public void setInfluenceTour(Origine influenceTour) {
        this.influenceTour = influenceTour;
    }
    public void setFintour(boolean fintour)
    {
        this.fintour=fintour;
    }
    public void remplirPioche()
    {
        //Ajout Croyant
        this.pioche.add(new Moine(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE},new Image("ressource/image/carte/moine1.jpg"
        )));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/carte/moine2.jpg"
        )));
        this.pioche.add(new Moine(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS},new Image("ressource/image/carte/moine3.jpg"
        )));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/carte/moine4.jpg"
        )));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/carte/moine5.jpg"
        )));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},1,new Image("ressource/image/carte/travailleur1.jpg"
        )));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE},2,new Image("ressource/image/carte/travailleur2.jpg"
        )));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.MYSTIQUE,Dogme.MYSTIQUE,Dogme.CHAOS},3,new Image("ressource/image/carte/travailleur3.jpg"
        )));
        this.pioche.add(new Ermite(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/carte/ermite1.jpg"
        )));
        this.pioche.add(new Ermite(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/carte/ermite2.jpg"
        )));
        this.pioche.add(new Integriste(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/carte/integriste1.jpg"
        )));
        this.pioche.add(new GuerrierSaint(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/carte/guerriersaint1.jpg"
        )));
        this.pioche.add(new Diplomate(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/carte/diplomate1.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE},new Image("ressource/image/carte/demon1.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/carte/demon2.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS},new Image("ressource/image/carte/demon3.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/carte/demon4.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/carte/demon5.jpg"
        )));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.SYMBOLE,Dogme.NATURE,Dogme.CHAOS},1,new Image("ressource/image/carte/alchimiste1.jpg"
        )));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},2,new Image("ressource/image/carte/alchimiste2.jpg"
        )));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.SYMBOLE,Dogme.NATURE,Dogme.CHAOS},3,new Image("ressource/image/carte/alchimiste3.jpg"
        )));
        this.pioche.add(new Vampire(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/carte/vampire1.jpg"
        )));
        this.pioche.add(new Vampire(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/carte/vampire2.jpg"
        )));
        this.pioche.add(new Lycanthrope(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/carte/lycanthrope1.jpg"
        )));
        this.pioche.add(new Pillard(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/carte/pillard1.jpg"
        )));
        this.pioche.add(new Illusionniste(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/carte/illusionniste1.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE},new Image("ressource/image/carte/esprit1.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/carte/esprit2.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS},new Image("ressource/image/carte/esprit3.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/carte/esprit4.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/carte/esprit5.jpg"
        )));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},1,new Image("ressource/image/carte/aliene1.jpg"
        )));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE},2,new Image("ressource/image/carte/aliene2.jpg"
        )));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},3,new Image("ressource/image/carte/aliene3.jpg"
        )));
        this.pioche.add(new Revenant(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE},new Image("ressource/image/carte/revenant1.jpg"
        )));
        this.pioche.add(new Revolutionnaire(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/carte/revolutionnaire1.jpg"
        )));
        this.pioche.add(new Nihilliste(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS},new Image("ressource/image/carte/nihilliste1.jpg"
        )));
        //Ajout Guide
        this.pioche.add(new Martyr(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN},2,new Image("ressource/image/carte/martyr1.jpg"
        )));
        this.pioche.add(new Martyr(Origine.NUIT,new Dogme[]{Dogme.HUMAIN,Dogme.SYMBOLE},2,new Image("ressource/image/carte/martyr2.jpg"
        )));
        this.pioche.add(new Martyr(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.CHAOS},2,new Image("ressource/image/carte/martyr3.jpg"
        )));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.CHAOS},2,new Image("ressource/image/carte/clerc1.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.SYMBOLE},2,new Image("ressource/image/carte/clerc2.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE},2,new Image("ressource/image/carte/clerc3.jpg"
        )));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.CHAOS},2,new Image("ressource/image/carte/clerc4.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.MYSTIQUE,Dogme.SYMBOLE},2,new Image("ressource/image/carte/clerc5.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NEANT,new Dogme[]{Dogme.SYMBOLE,Dogme.CHAOS},2,new Image("ressource/image/carte/clerc6.jpg"
        )));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.MYSTIQUE,Dogme.CHAOS},2,new Image("ressource/image/carte/clerc7.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN},2,new Image("ressource/image/carte/clerc8.jpg"
        )));
        this.pioche.add(new Shaman(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.SYMBOLE},3,new Image("ressource/image/carte/shaman1.jpg"
        )));
        this.pioche.add(new Anarchiste(Origine.NEANT,new Dogme[]{Dogme.HUMAIN,Dogme.CHAOS},3,new Image("ressource/image/carte/anarchiste1.jpg"
        )));
        this.pioche.add(new Paladin(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE},3,new Image("ressource/image/carte/paladin1.jpg"
        )));
        this.pioche.add(new Ascete(Origine.NUIT,new Dogme[]{Dogme.HUMAIN,Dogme.SYMBOLE},1,new Image("ressource/image/carte/ascete1.jpg"
        )));
        this.pioche.add(new Devin(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE},1,new Image("ressource/image/carte/devin1.jpg"
        )));
        this.pioche.add(new Exorciste(Origine.JOUR,new Dogme[]{Dogme.MYSTIQUE,Dogme.CHAOS},1,new Image("ressource/image/carte/exorciste1.jpg"
        )));
        this.pioche.add(new Sorcier(Origine.NUIT,new Dogme[]{Dogme.MYSTIQUE,Dogme.SYMBOLE},3,new Image("ressource/image/carte/sorcier1.jpg"
        )));
        this.pioche.add(new Tyran(Origine.NEANT,new Dogme[]{Dogme.SYMBOLE,Dogme.CHAOS},3,new Image("ressource/image/carte/tyran1.jpg"
        )));
        this.pioche.add(new Messie(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE},3,new Image("ressource/image/carte/messie1.jpg"
        )));
        //AJOUT Deus Ex
        this.pioche.add(new ColereDivine(Origine.JOUR,new Image("ressource/image/carte/coleredivine1.jpg"
        )));
        this.pioche.add(new ColereDivine(Origine.NUIT,new Image("ressource/image/carte/coleredivine2.jpg"
        )));
        this.pioche.add(new Stase(Origine.JOUR,new Image("ressource/image/carte/stase1.jpg"
        )));
        this.pioche.add(new OrdreCeleste(Origine.JOUR,new Image("ressource/image/carte/ordreceleste1.jpg"
        )));
        this.pioche.add(new Fourberie(Origine.NUIT,new Image("ressource/image/carte/fourberie1.jpg"
        )));
        this.pioche.add(new Diversion(Origine.NUIT,new Image("ressource/image/carte/diversion1.jpg"
        )));
        this.pioche.add(new Concentration(Origine.NEANT,new Image("ressource/image/carte/concentration1.jpg"
        )));
        this.pioche.add(new TrouNoir(Origine.NEANT,new Image("ressource/image/carte/trounoir1.jpg"
        )));
        this.pioche.add(new Phoenix(Origine.NEANT,new Image("ressource/image/carte/phoenix1.jpg"
        )));
        this.pioche.add(new InfluenceJour(null,new Image("ressource/image/carte/influencejour1.jpg"
        )));
        this.pioche.add(new InfluenceNuit(null,new Image("ressource/image/carte/influencenuit1.jpg"
        )));
        this.pioche.add(new InfluenceNeant(null,new Image("ressource/image/carte/influenceneant1.jpg"
        )));
        this.pioche.add(new InfluenceNulle(null,new Image("ressource/image/carte/influencenulle1.jpg"
        )));
        this.pioche.add(new InfluenceNulle(null,new Image("ressource/image/carte/influencenulle1.jpg"
        )));
        this.pioche.add(new Transe(null,new Image("ressource/image/carte/transe1.jpg"
        )));
        this.pioche.add(new Miroir(null,new Image("ressource/image/carte/miroir1.jpg"
        )));
        this.pioche.add(new Bouleversement(null,new Image("ressource/image/carte/bouleversement1.jpg"
        )));
        this.pioche.add(new Inquisition(null,new Image("ressource/image/carte/inquisition1.jpg"
        )));
        //Ajout Apocalypse
        this.pioche.add(new Apocalypse(Origine.JOUR,new Image("ressource/image/carte/apocalypse1.jpg"
        )));
        this.pioche.add(new Apocalypse(Origine.NUIT,new Image("ressource/image/carte/apocalypse2.jpg"
        )));
        this.pioche.add(new Apocalypse(Origine.NEANT,new Image("ressource/image/carte/apocalypse3.jpg"
        )));
        this.pioche.add(new Apocalypse(null,new Image("ressource/image/carte/apocalypse4.jpg"
        )));
        this.pioche.add(new Apocalypse(null,new Image("ressource/image/carte/apocalypse4.jpg"
        )));
        shuffle(this.pioche);

    }



    @Override
    public String toString() {
        return "Partie{" +
                "joueur=" + joueur;
    }
}
