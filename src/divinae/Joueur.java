package divinae;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.carte.Apocalypse;
import divinae.carte.abstractcarte.*;
import divinae.enumeration.Origine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Joueur {

    private String nom;
    private HashMap<String,Integer>pointsAction;
    private Boolean peutSacrifierCroyant;
    private Boolean peutSacrifierGuide;
    private Boolean peutRecevoirPoint;
    private Boolean aUtiliseCompetenceDivine;
    private Divinite divinite;
    private ArrayList<Carte> main;
    public  static int TAILLEMAIN=7;

    public Joueur(String nom)
    {
        this.nom=nom;
        this.peutSacrifierCroyant=true;
        this.peutSacrifierGuide=true;
        this.peutRecevoirPoint=true;
        this.aUtiliseCompetenceDivine=false;
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
        this.pointsAction.put(origine, this.pointsAction.get(origine)+ajout);
    }
    public void denySacrificeCroyant(){
        this.peutSacrifierCroyant=false;
    }
    public void allowSacrificeCroyant(){
        this.peutSacrifierCroyant=true;
    }
    public Boolean getPeutSacrifierCroyant() {
        return peutSacrifierCroyant;
    }

    public void denySacrificeGuide(){
        this.peutSacrifierGuide=false;
    }
    public void allowSacrificeGuide(){
        this.peutSacrifierGuide=true;
    }

    public Boolean getPeutSacrifierGuide() {
        return peutSacrifierGuide;
    }

    public Boolean getaUtiliseCompetenceDivine() { return aUtiliseCompetenceDivine; }
    public void setaUtiliseCompetenceDivine(Boolean aUtiliseCompetenceDivine) { this.aUtiliseCompetenceDivine = aUtiliseCompetenceDivine;}
    public Boolean getPeutRecevoirPoint() { return peutRecevoirPoint; }
    public void setPeutRecevoirPoint(Boolean peutRecevoirPoint) {this.peutRecevoirPoint = peutRecevoirPoint;}

    public void pioche(Partie partie){
        int taillePioche=partie.getPioche().size()-1;
        this.main.add(partie.getPioche().remove(taillePioche));
    }
    public void volerCarte(Joueur joueurAVole){
        int tailleMain=joueurAVole.getMain().size()-1;
        if (tailleMain >0){
            this.main.add(joueurAVole.getMain().remove(tailleMain));
        }
        else{
            System.out.println("Main vide.");
        }
    }
    public void completerMain(Partie partie)
    {
        int tailleMain=this.main.size();
        for(int i=tailleMain;i<TAILLEMAIN;i++)
        {
            this.pioche(partie);
        }
    }
    public void ajoutPoints(Origine originePoint)
    {
        Origine origineDiv=this.divinite.getOrigine();
        if (this.getPeutRecevoirPoint()) {
            switch (originePoint) {
                case JOUR:
                    switch (origineDiv) {
                        case JOUR:
                            this.pointsAction.put("JOUR", 2 + this.pointsAction.get("JOUR"));
                            break;
                        case AUBE:
                            this.pointsAction.put("JOUR", 1 + this.pointsAction.get("JOUR"));
                            break;
                    }
                    break;
                case NUIT:
                    switch (origineDiv) {
                        case NUIT:
                            this.pointsAction.put("NUIT", 2 + this.pointsAction.get("NUIT"));
                            break;
                        case CREPUSCULE:
                            this.pointsAction.put("NUIT", 1 + this.pointsAction.get("NUIT"));
                            break;

                    }
                    break;
                case NEANT:
                    switch (origineDiv) {
                        case AUBE:
                            this.pointsAction.put("NEANT", 1 + this.pointsAction.get("NEANT"));
                            break;
                        case CREPUSCULE:
                            this.pointsAction.put("NEANT", 1 + this.pointsAction.get("NEANT"));
                            break;
                    }
                    break;
            }
        }
        else{
            System.out.println("Vous ne pouvez pas recevoir de points");
        }
    }
    public void jouer(int numCarte,Partie partie)
    {
        Carte carte =this.getMain().get(numCarte);
        if(carte instanceof Croyant)
        {
            partie.getCentreTable().add((Croyant) this.getMain().remove(numCarte));
        }
        else if(carte instanceof GuideSpirituel)
        {
            this.divinite.getGuideDivinite().add((GuideSpirituel) this.getMain().remove(numCarte));
            ((GuideSpirituel) carte).rattacher(partie);

        }
        else
        {
            if(carte instanceof Apocalypse && !Partie.APOCALYPSE)
            {
                System.out.println("Carte Apocalypse non jouable ce tour");
                return;
            }
                this.getMain().get(numCarte).capacite(this,partie);
                this.defausseCarte(numCarte,partie);
        }


    }
    public void sacrifierGuide(int guide,Partie partie)
    {
        this.getDivinite().getGuideDivinite().get(guide).capacite(this,partie);
        this.getDivinite().getGuideDivinite().get(guide).libCroyant(partie);
        partie.getDefausse().add(this.getDivinite().getGuideDivinite().get(guide));
    }
    public void sacrifierCroyant(int guide,int croyant,Partie p)
    {
        this.getDivinite().getGuideDivinite().get(guide).getCroyantRattache()[croyant].capacite(this,p);
        p.getDefausse().add(this.getDivinite().getGuideDivinite().get(guide).getCroyantRattache()[croyant]);
        this.getDivinite().getGuideDivinite().get(guide).getCroyantRattache()[croyant]=null;
        if(this.getDivinite().getGuideDivinite().get(guide).aCroyantRattache())
            p.getDefausse().add(this.getDivinite().getGuideDivinite().remove(guide));
    }
    public void defausseCarte(int numCarte,Partie partie)
    {
        if(!this.getMain().isEmpty())
            partie.getDefausse().add(this.getMain().remove(numCarte));
    }
    public  int compterPriere()
    {
            int priere=0;
            for(int i=0;i<this.divinite.getGuideDivinite().size();i++)
            {
                priere=priere+this.getDivinite().getGuideDivinite().get(i).priereGuide();
            }
            return priere;

    }
    public void libGuideCroyant(Partie partie)
    {
        int i=0;
        while(i<this.divinite.getGuideDivinite().size())
        {

            this.getDivinite().getGuideDivinite().get(i).libCroyant(partie);
            partie.getDefausse().add(this.divinite.getGuideDivinite().remove(i));
        }
    }
    public boolean pointPourJouer(Carte carte)
    {
        int point=this.getPointsAction().get(carte.getOrigine().toString());
        if(point<=0 && carte.getOrigine()!=Origine.NEANT && carte.getOrigine()!=null)
        {
            return false;
        }
        else if(carte.getOrigine()==Origine.NEANT && this.getPointsAction().get("JOUR")<2 && this.getPointsAction().get("NUIT")<2 && this.getPointsAction().get("NEANT")<1)
            return false;

        else return true;
    }
    public String getNom()
    {
        return this.nom;
    }
    public ArrayList<Carte> getMain()
    {
        return this.main;
    }
    public HashMap<String,Integer> getPointsAction()
    {
        return this.pointsAction;
    }
    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", pointsAction=" + pointsAction +
                ", peutSacrifierCroyant=" + peutSacrifierCroyant +
                ", peutSacrifierGuide=" + peutSacrifierGuide +
                ", divinite=" + divinite +
                '}';
    }
}
