package divinae;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.carte.Apocalypse;
import divinae.carte.abstractcarte.*;
import divinae.enumeration.Origine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Represente un joueur reel. Au joueur est rattache sa divinite, ses points d'actions et sa main.
 */
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

    /**
     * Constructeur du joueur.
     * @param nom
     */
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

    /**
     * Setter divinite
     * @param divinite
     */
    public void setDivinite(Divinite divinite)
    {
        this.divinite=divinite;
    }

    /**
     * Getter divinite
     * @return
     */
    public Divinite getDivinite(){
        return this.divinite;
    }

    /**
     * Ajoute le nombre de points voulus, en specifiant l'origine.
     * @param ajout
     * @param origine
     */
    public void ajoutPoints(int ajout, String origine){
        this.pointsAction.put(origine, this.pointsAction.get(origine)+ajout);
    }

    /**
     * Empeche le joueur de sacrifier des croyants pendant ce tour.
     */
    public void denySacrificeCroyant(){
        this.peutSacrifierCroyant=false;
    }

    /**
     * Autorise le joueur a sacrifier des croyants pendant ce tour.
     */
    public void allowSacrificeCroyant(){
        this.peutSacrifierCroyant=true;
    }

    /**
     * Retourne si le joueur peut sacrifier des croyants ou pas.

     */
    public Boolean getPeutSacrifierCroyant() {
        return peutSacrifierCroyant;
    }

    /**
     * Empeche le joueur de sacrifier des guides pendant ce tour.
     */
    public void denySacrificeGuide(){
        this.peutSacrifierGuide=false;
    }
    /**
     * Autorise le joueur a sacrifier des guides pendant ce tour.
     */
    public void allowSacrificeGuide(){
        this.peutSacrifierGuide=true;
    }
    /**
     * Retourne si le joueur peut sacrifier des guides ou pas.

     */
    public Boolean getPeutSacrifierGuide() {
        return peutSacrifierGuide;
    }

    /**
     * Retourne si le joueur a utilise sa competence divine ou pas.
     * @return booleen
     */
    public Boolean getaUtiliseCompetenceDivine() { return aUtiliseCompetenceDivine; }

    /**
     * Modifie si le joueur a utilise sa competence divine ou pas.
     * @param aUtiliseCompetenceDivine
     */
    public void setaUtiliseCompetenceDivine(Boolean aUtiliseCompetenceDivine) { this.aUtiliseCompetenceDivine = aUtiliseCompetenceDivine;}

    /**
     * Retourne si le joueur peut recevoir des points.
     * @return booleen
     */
    public Boolean getPeutRecevoirPoint() { return peutRecevoirPoint; }

    /**
     * Modifie si le joueur peut recevoir des points.
     * @param peutRecevoirPoint
     */
    public void setPeutRecevoirPoint(Boolean peutRecevoirPoint) {this.peutRecevoirPoint = peutRecevoirPoint;}

    /**
     * Ajoute une carte dans la main du joueur en provenance de la pioche.
     * @param partie
     */
    public void pioche(Partie partie){
        int taillePioche=partie.getPioche().size()-1;
        this.main.add(partie.getPioche().remove(taillePioche));
    }

    /**
     * Vole une carte a un autre joueur, en parametre le joueur a voler.
     * @param joueurAVole
     */
    public void volerCarte(Joueur joueurAVole){
        int tailleMain=joueurAVole.getMain().size()-1;
        if (tailleMain >0){
            this.main.add(joueurAVole.getMain().remove(tailleMain));
        }
        else{
            System.out.println("Main vide.");
        }
    }

    /**
     * Completer sa main jusqu'a avoir le maximum de carte.
     * @param partie
     */
    public void completerMain(Partie partie)
    {
        int tailleMain=this.main.size();
        for(int i=tailleMain;i<TAILLEMAIN;i++)
        {
            this.pioche(partie);
        }
    }

    /**
     * Ajoute des points au joueur en fonction de l'origine en entree.
     * @param originePoint
     */
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

    /**
     *
     * @param numCarte
     * @param partie
     */
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

    /**
     * Sacrifie un guide. Les croyants attaches sont liberes et la capacite du guide est activee.
     * @param guide
     * @param partie
     */
    public void sacrifierGuide(int guide,Partie partie)
    {
        this.getDivinite().getGuideDivinite().get(guide).capacite(this,partie);
        this.getDivinite().getGuideDivinite().get(guide).libCroyant(partie);
        partie.getDefausse().add(this.getDivinite().getGuideDivinite().get(guide));
    }

    /**
     * Sacrifie un croyant. Sa capacite est activee.
     * @param guide
     * @param croyant
     * @param p
     */
    public void sacrifierCroyant(int guide,int croyant,Partie p)
    {
        this.getDivinite().getGuideDivinite().get(guide).getCroyantRattache()[croyant].capacite(this,p);
        p.getDefausse().add(this.getDivinite().getGuideDivinite().get(guide).getCroyantRattache()[croyant]);
        this.getDivinite().getGuideDivinite().get(guide).getCroyantRattache()[croyant]=null;
        if(this.getDivinite().getGuideDivinite().get(guide).aCroyantRattache())
            p.getDefausse().add(this.getDivinite().getGuideDivinite().remove(guide));
    }

    /**
     * Defausse une carte, en parametre le numero de la carte dans la main.
     * @param numCarte
     * @param partie
     */
    public void defausseCarte(int numCarte,Partie partie)
    {
        if(!this.getMain().isEmpty())
            partie.getDefausse().add(this.getMain().remove(numCarte));
    }

    /**
     * Compte le total de prieres associees a un joueur.
     * @return un entier de nombres de prieres.
     */
    public  int compterPriere()
    {
            int priere=0;
            for(int i=0;i<this.divinite.getGuideDivinite().size();i++)
            {
                priere=priere+this.getDivinite().getGuideDivinite().get(i).priereGuide();
            }
            return priere;

    }

    /**
     * Detache un guide du joueur. Les croyants reviennent au centre la table.
     * @param partie
     */
    public void libGuideCroyant(Partie partie)
    {
        int i=0;
        while(i<this.divinite.getGuideDivinite().size())
        {

            this.getDivinite().getGuideDivinite().get(i).libCroyant(partie);
            partie.getDefausse().add(this.divinite.getGuideDivinite().remove(i));
        }
    }

    /**
     * Renvois si la carte peut etre jouee ou pas en fonction du nombre de points et des origines.
     * En parametre la carte en question.
     * @param carte
     * @return
     */
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

    /**
     * Renvois le nom du joueur.
     * @return son nom
     */
    public String getNom()
    {
        return this.nom;
    }

    /**
     * Retourne la main du joueur.
     * @return un arraylist de cartes.
     */
    public ArrayList<Carte> getMain()
    {
        return this.main;
    }

    /**
     * Retourne les differents points du joueur.
     * @return un hashmap des points.
     */
    public HashMap<String,Integer> getPointsAction()
    {
        return this.pointsAction;
    }

    /**
     * Affiche le joueur.
     * @return le joueur en string.
     */
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
