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
        Collections.addAll(divin,new Brewalen(new Image("ressource/image/brewalen.jpg")),new Drinded(new Image("ressource/image/drinded.jpg")),new Gorpa(new Image("ressource/image/gorpa.jpg")),new Gwenghelen(new Image("ressource/image/gwenghelen.jpg")),new Killinstred(new Image("ressource/image/killinstred.jpg")),new Llewella(new Image("ressource/image/llewella.jpg")),new PuiTara(new Image("ressource/image/puitara.jpg")),new Romtec(new Image("ressource/image/romtec.jpg")),new Shingva(new Image("ressource/image/shingva.jpg")),new Yarstur(new Image("ressource/image/yarstur.jpg")));
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
        this.pioche.add(new Moine(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE},new Image("ressource/image/moine1.jpg"
        )));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/moine2.jpg"
        )));
        this.pioche.add(new Moine(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS},new Image("ressource/image/moine3.jpg"
        )));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/moine4.jpg"
        )));
        this.pioche.add(new Moine(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/moine5.jpg"
        )));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},1,new Image("ressource/image/travailleur1.jpg"
        )));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE},2,new Image("ressource/image/travailleur2.jpg"
        )));
        this.pioche.add(new Travailleur(new Dogme[]{Dogme.MYSTIQUE,Dogme.MYSTIQUE,Dogme.CHAOS},3,new Image("ressource/image/travailleur3.jpg"
        )));
        this.pioche.add(new Ermite(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/ermite1.jpg"
        )));
        this.pioche.add(new Ermite(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/ermite2.jpg"
        )));
        this.pioche.add(new Integriste(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/integriste1.jpg"
        )));
        this.pioche.add(new GuerrierSaint(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/guerriersaint1.jpg"
        )));
        this.pioche.add(new Diplomate(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/diplomate1.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE},new Image("ressource/image/demon1.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/demon2.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS},new Image("ressource/image/demon3.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/demon4.jpg"
        )));
        this.pioche.add(new Demon(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/demon5.jpg"
        )));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.SYMBOLE,Dogme.NATURE,Dogme.CHAOS},1,new Image("ressource/image/alchimiste1.jpg"
        )));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},2,new Image("ressource/image/alchimiste2.jpg"
        )));
        this.pioche.add(new Alchimiste(new Dogme[]{Dogme.SYMBOLE,Dogme.NATURE,Dogme.CHAOS},3,new Image("ressource/image/alchimiste3.jpg"
        )));
        this.pioche.add(new Vampire(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/vampire1.jpg"
        )));
        this.pioche.add(new Vampire(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/vampire2.jpg"
        )));
        this.pioche.add(new Lycanthrope(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/lycanthrope1.jpg"
        )));
        this.pioche.add(new Pillard(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/pillard1.jpg"
        )));
        this.pioche.add(new Illusionniste(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/illusionniste1.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE},new Image("ressource/image/esprit1.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/esprit2.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS},new Image("ressource/image/esprit3.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.SYMBOLE},new Image("ressource/image/esprit4.jpg"
        )));
        this.pioche.add(new Esprit(new Dogme[]{Dogme.MYSTIQUE,Dogme.NATURE,Dogme.CHAOS},new Image("ressource/image/esprit5.jpg"
        )));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},1,new Image("ressource/image/aliene1.jpg"
        )));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.SYMBOLE},2,new Image("ressource/image/aliene2.jpg"
        )));
        this.pioche.add(new Aliene(new Dogme[]{Dogme.MYSTIQUE,Dogme.HUMAIN,Dogme.CHAOS},3,new Image("ressource/image/aliene3.jpg"
        )));
        this.pioche.add(new Revenant(new Dogme[]{Dogme.HUMAIN,Dogme.NATURE,Dogme.MYSTIQUE},new Image("ressource/image/revenant1.jpg"
        )));
        this.pioche.add(new Revolutionnaire(new Dogme[]{Dogme.SYMBOLE,Dogme.HUMAIN,Dogme.CHAOS},new Image("ressource/image/revolutionnaire1.jpg"
        )));
        this.pioche.add(new Nihilliste(new Dogme[]{Dogme.SYMBOLE,Dogme.MYSTIQUE,Dogme.CHAOS},new Image("ressource/image/nihilliste1.jpg"
        )));
        //Ajout Guide
        this.pioche.add(new Martyr(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN},2,new Image("ressource/image/martyr1.jpg"
        )));
        this.pioche.add(new Martyr(Origine.NUIT,new Dogme[]{Dogme.HUMAIN,Dogme.SYMBOLE},2,new Image("ressource/image/martyr2.jpg"
        )));
        this.pioche.add(new Martyr(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.CHAOS},2,new Image("ressource/image/martyr3.jpg"
        )));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.CHAOS},2,new Image("ressource/image/clerc1.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.SYMBOLE},2,new Image("ressource/image/clerc2.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE},2,new Image("ressource/image/clerc3.jpg"
        )));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.CHAOS},2,new Image("ressource/image/clerc4.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.MYSTIQUE,Dogme.SYMBOLE},2,new Image("ressource/image/clerc5.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NEANT,new Dogme[]{Dogme.SYMBOLE,Dogme.CHAOS},2,new Image("ressource/image/clerc6.jpg"
        )));
        this.pioche.add(new Clerc(Origine.JOUR,new Dogme[]{Dogme.MYSTIQUE,Dogme.CHAOS},2,new Image("ressource/image/clerc7.jpg"
        )));
        this.pioche.add(new Clerc(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN},2,new Image("ressource/image/clerc8.jpg"
        )));
        this.pioche.add(new Shaman(Origine.NUIT,new Dogme[]{Dogme.NATURE,Dogme.SYMBOLE},3,new Image("ressource/image/shaman1.jpg"
        )));
        this.pioche.add(new Anarchiste(Origine.NEANT,new Dogme[]{Dogme.HUMAIN,Dogme.CHAOS},3,new Image("ressource/image/anarchiste1.jpg"
        )));
        this.pioche.add(new Paladin(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE},3,new Image("ressource/image/paladin1.jpg"
        )));
        this.pioche.add(new Ascete(Origine.NUIT,new Dogme[]{Dogme.HUMAIN,Dogme.SYMBOLE},1,new Image("ressource/image/ascete1.jpg"
        )));
        this.pioche.add(new Devin(Origine.NEANT,new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE},1,new Image("ressource/image/devin1.jpg"
        )));
        this.pioche.add(new Exorciste(Origine.JOUR,new Dogme[]{Dogme.MYSTIQUE,Dogme.CHAOS},1,new Image("ressource/image/exorciste1.jpg"
        )));
        this.pioche.add(new Sorcier(Origine.NUIT,new Dogme[]{Dogme.MYSTIQUE,Dogme.SYMBOLE},3,new Image("ressource/image/sorcier1.jpg"
        )));
        this.pioche.add(new Tyran(Origine.NEANT,new Dogme[]{Dogme.SYMBOLE,Dogme.CHAOS},3,new Image("ressource/image/tyran1.jpg"
        )));
        this.pioche.add(new Messie(Origine.JOUR,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE},3,new Image("ressource/image/messie1.jpg"
        )));
        //AJOUT Deus Ex
        this.pioche.add(new ColereDivine(Origine.JOUR,new Image("ressource/image/coleredivine1.jpg"
        )));
        this.pioche.add(new ColereDivine(Origine.NUIT,new Image("ressource/image/coleredivine2.jpg"
        )));
        this.pioche.add(new Stase(Origine.JOUR,new Image("ressource/image/stase1.jpg"
        )));
        this.pioche.add(new OrdreCeleste(Origine.JOUR,new Image("ressource/image/ordreceleste1.jpg"
        )));
        this.pioche.add(new Fourberie(Origine.NUIT,new Image("ressource/image/fourberie1.jpg"
        )));
        this.pioche.add(new Diversion(Origine.NUIT,new Image("ressource/image/diversion1.jpg"
        )));
        this.pioche.add(new Concentration(Origine.NEANT,new Image("ressource/image/concentration1.jpg"
        )));
        this.pioche.add(new TrouNoir(Origine.NEANT,new Image("ressource/image/trounoir1.jpg"
        )));
        this.pioche.add(new Phoenix(Origine.NEANT,new Image("ressource/image/phoenix1.jpg"
        )));
        this.pioche.add(new InfluenceJour(null,new Image("ressource/image/influencejour1.jpg"
        )));
        this.pioche.add(new InfluenceNuit(null,new Image("ressource/image/influencenuit1.jpg"
        )));
        this.pioche.add(new InfluenceNeant(null,new Image("ressource/image/influenceneant1.jpg"
        )));
        this.pioche.add(new InfluenceNulle(null,new Image("ressource/image/influencenulle1.jpg"
        )));
        this.pioche.add(new InfluenceNulle(null,new Image("ressource/image/influencenulle1.jpg"
        )));
        this.pioche.add(new Transe(null,new Image("ressource/image/transe1.jpg"
        )));
        this.pioche.add(new Miroir(null,new Image("ressource/image/miroir1.jpg"
        )));
        this.pioche.add(new Bouleversement(null,new Image("ressource/image/bouleversement1.jpg"
        )));
        this.pioche.add(new Inquisition(null,new Image("ressource/image/inquisition1.jpg"
        )));
        //Ajout Apocalypse
        this.pioche.add(new Apocalypse(Origine.JOUR,new Image("ressource/image/apocalypse1.jpg"
        )));
        this.pioche.add(new Apocalypse(Origine.NUIT,new Image("ressource/image/apocalypse2.jpg"
        )));
        this.pioche.add(new Apocalypse(Origine.NEANT,new Image("ressource/image/apocalypse3.jpg"
        )));
        this.pioche.add(new Apocalypse(null,new Image("ressource/image/apocalypse4.jpg"
        )));
        this.pioche.add(new Apocalypse(null,new Image("ressource/image/apocalypse4.jpg"
        )));
        shuffle(this.pioche);

    }



    @Override
    public String toString() {
        return "Partie{" +
                "joueur=" + joueur;
    }
}
