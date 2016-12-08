package divinae;

import divinae.carte.abstractcarte.Carte;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Origine;

import java.util.ArrayList;
import java.util.HashMap;

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
    public void jouer(Carte c)
    {
        System.out.println(c.getNom());
        if(c instanceof Croyant)
        {
            System.out.println("TA VU JE SUIS UN CROYANT");
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
