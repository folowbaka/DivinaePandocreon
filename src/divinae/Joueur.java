package divinae;

import com.sun.org.apache.xpath.internal.operations.Or;
import divinae.carte.abstractcarte.*;
import divinae.enumeration.Origine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Joueur {

    private String nom;
    private HashMap<String,Integer>pointsAction;
    private Boolean peutSacrifier;
    private Divinite divinite;
    private ArrayList<Carte> main;
    public  static int TAILLEMAIN=7;

    public Joueur(String nom)
    {
        this.nom=nom;
        this.peutSacrifier=true;
        this.pointsAction=new HashMap<String,Integer>();
        this.pointsAction.put("JOUR",0);
        this.pointsAction.put("NUIT",0);
        this.pointsAction.put("NEANT",0);
        this.main=new ArrayList<Carte>();
    }
    public void setDivinite(Divinite divinite)
    {
        this.divinite=divinite;
    }
    public Divinite getDivinite(){
        return this.divinite;
    }
    public void ajoutPoints(int ajout, String origine){
        //this.pointsAction.get(origine)+=ajout;
    }
    public void denySacrifice(){
        this.peutSacrifier=false;
    }
    public void allowSacrifice(){
        this.peutSacrifier=true;
    }
    public void pioche(Partie partie){
        int taillePioche=partie.getPioche().size()-1;
        this.main.add(partie.getPioche().remove(taillePioche));
    }
    public void completerMain(Partie p)
    {
        int tailleMain=this.main.size();
        for(int i=tailleMain;i<TAILLEMAIN;i++)
        {
            this.pioche(p);
        }
    }
    public void ajoutPoints(Origine originePoint)
    {
        Origine origineDiv=this.divinite.getOrigine();
        switch(originePoint)
        {
            case JOUR:
                switch(origineDiv)
                {
                    case JOUR:
                        this.pointsAction.put("JOUR",2+this.pointsAction.get("JOUR"));
                        break;
                    case AUBE:
                        this.pointsAction.put("JOUR",1+this.pointsAction.get("JOUR"));
                        break;
                }
                break;
            case NUIT:
                switch (origineDiv)
                {
                    case NUIT:
                        this.pointsAction.put("NUIT",2+this.pointsAction.get("NUIT"));
                        break;
                    case CREPUSCULE:
                        this.pointsAction.put("NUIT",1+this.pointsAction.get("NUIT"));
                        break;

                }
                break;
            case NEANT:
                switch (origineDiv)
                {
                    case AUBE:
                        this.pointsAction.put("NEANT",1+this.pointsAction.get("NEANT"));
                        break;
                    case CREPUSCULE:
                        this.pointsAction.put("NEANT",1+this.pointsAction.get("NEANT"));
                        break;
                }
                break;
        }
    }
    public void jouer(int c,Partie p)
    {
        Carte carte=this.getMain().get(c);
        int point=this.pointsAction.get(carte.getOrigine().toString());
        if(point<=0 && carte.getOrigine()!=Origine.NEANT && carte.getOrigine()!=null)
        {
                System.out.println("Vous n'avez pas assez de points pour jouer");
                return ;
        }
        if(point>0)
        {
            this.pointsAction.put(carte.getOrigine().toString(),point-1);
        }
        else if(point<=0 && carte.getOrigine()==Origine.NEANT)
        {
            Scanner sc=new Scanner(System.in);
            int choixPoint;
            if(this.pointsAction.get("NUIT")>1 && this.pointsAction.get("JOUR")>1)
            {
                System.out.println("1---------Dépenser 2 points Nuit?");
                System.out.println("2---------Dépenser 2 points Jour?");
                System.out.println("0---------Annuler");
                choixPoint=sc.nextInt();
                if(choixPoint==0)
                    return;
                if(choixPoint==1)
                    this.pointsAction.put("NUIT",this.pointsAction.get("NUIT")-2);
                if(choixPoint==2)
                    this.pointsAction.put("JOUR",this.pointsAction.get("JOUR")-2);
            }
            else if(this.pointsAction.get("NUIT")>1)
            {
                System.out.println("1---------Dépenser 2 points Nuit?");
                System.out.println("0---------Annuler");
                choixPoint=sc.nextInt();
                if(choixPoint==0)
                    return;
                if(choixPoint==1)
                    this.pointsAction.put("NUIT",this.pointsAction.get("NUIT")-2);
            }
            else
            {
                System.out.println("1---------Dépenser 2 points Jour?");
                System.out.println("0---------Annuler");
                choixPoint=sc.nextInt();
                if(choixPoint==0)
                    return;
                if(choixPoint==1)
                    this.pointsAction.put("JOUR",this.pointsAction.get("JOUR")-2);
            }
        }
        if(carte instanceof Croyant)
        {
            p.getCentreTable().add((Croyant) this.getMain().remove(c));
        }
        else if(carte instanceof GuideSpirituel)
        {
            this.divinite.getGuideDivinite().add((GuideSpirituel) this.getMain().remove(c));
        }
        else
        {
                this.getMain().get(c).capacite(this,p);
                this.defausseCarte(c,p);
        }


    }
    public void defausseCarte(int carte,Partie p)
    {
        if(!this.getMain().isEmpty())
        p.getDefausse().add(this.getMain().remove(carte));
    }
    public String getNom()
    {
        return this.nom;
    }
    public ArrayList<Carte> getMain()
    {
        return this.main;
    }
    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", pointsAction=" + pointsAction +
                ", peutSacrifier=" + peutSacrifier +
                ", divinite=" + divinite +
                '}';
    }
}
