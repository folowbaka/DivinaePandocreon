package divinae;

import java.util.HashMap;

public class Joueur {

    private String nom;
    private HashMap<String,Integer>pointsAction;
    private Boolean peutSacrifier;


    public Joueur(String nom)
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
