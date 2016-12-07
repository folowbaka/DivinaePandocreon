package divinae;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Origine;

import java.util.HashMap;

public class Joueur {

    private String nom;
    private HashMap<String,Integer>pointsAction;
    private Boolean peutSacrifier;
    private Divinite divinite;


    public Joueur(String nom)
    {
        this.nom=nom;
        this.peutSacrifier=true;
        this.pointsAction=new HashMap<String,Integer>();
        this.pointsAction.put("JOUR",0);
        this.pointsAction.put("NUIT",0);
        this.pointsAction.put("NEANT",0);
    }
    public void setDivinite(Divinite divinite)
    {
        this.divinite=divinite;
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
