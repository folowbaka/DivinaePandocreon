package divinae;

import divinae.carte.abstractcarte.Divinite;

import java.util.HashMap;

public class Joueur {

    private String nom;
    private HashMap<String,Integer>pointsAction;
    private Boolean peutSacrifier;
    protected Divinite divinite;


    public Joueur(String nom, Divinite divinite)
    {
        this.nom=nom;
        this.peutSacrifier=true;
        this.pointsAction=new HashMap<String,Integer>();
        this.pointsAction.put("JOUR",0);
        this.pointsAction.put("NUIT",0);
        this.pointsAction.put("NEANT",0);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
