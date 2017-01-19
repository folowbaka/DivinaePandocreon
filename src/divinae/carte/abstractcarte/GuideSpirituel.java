package divinae.carte.abstractcarte;

import divinae.Partie;
import divinae.Joueur;
import divinae.Joueur;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Represente un guide spirituel, qui possede en attribut la liste des croyants rattaches.
 */
public abstract class GuideSpirituel extends CarteDogme {
    private Croyant[] croyantRattache;

    /**
     * Constructeur du guide spirituel.
     * @param origine
     * @param dogme
     * @param nbMaxCroyant
     * @param cheminCarte
     */
    public GuideSpirituel(Origine origine,Dogme[] dogme,int nbMaxCroyant,String cheminCarte)
    {
        super(origine,dogme,cheminCarte);
        this.croyantRattache=new Croyant[nbMaxCroyant];

    }

    /**
     * Retourne les croyants rattaches.
     * @return une liste de croyants
     * @see Croyant
     */
    public Croyant[] getCroyantRattache() {
        return croyantRattache;
    }

    /**
     * Modifie les croyants rattaches, en parametre une liste de croyants.
     * @param croyantRattache
     */
    public void setCroyantRattache(Croyant[] croyantRattache) {
        this.croyantRattache = croyantRattache;
    }

    /**
     * Cette methode parcours le centre de la table et associe a notre guide des croyants.
     * Elle prend en compte la limite de croyants maximum et les dogmes des croyants.
     * En parametre la partie en cours.
     * @param partie
     * @see Partie
     */
    public void rattacher(Partie partie)
    {
        ArrayList<Croyant> centre=partie.getCentreTable();
        if(centre.isEmpty())
                return;
        int i=0;
        int nbCroyant=0;
        int croyantMax=this.croyantRattache.length;
        while(i<centre.size() && nbCroyant<croyantMax)
        {
            int j=0;
            boolean dogmeTrouve=false;
            while(j<this.getDogme().length && nbCroyant<croyantMax && !dogmeTrouve)
            {
                int k=0;
                while(i<centre.size() && k<centre.get(i).getDogme().length && nbCroyant<croyantMax && !dogmeTrouve)
                {
                    if(this.getDogme()[j]==centre.get(i).getDogme()[k]&& nbCroyant<croyantMax && centre.get(i).estRattachable())
                    {
                        this.croyantRattache[nbCroyant]=centre.remove(i);
                        if(i>1)
                            i=i--;
                        nbCroyant++;
                        dogmeTrouve=true;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

    }

    /**
     * Cette methode libere les croyants rattache au guide en question et les remet au centre de la table.
     * En parametre la partie en cours
     * @param partie
     * @see Partie
     */
    public void libCroyant(Partie partie)
    {
        for(int j=0;j<this.getCroyantRattache().length;j++)
        {
            if(this.croyantRattache[j]!=null)
            {
                partie.getCentreTable().add(getCroyantRattache()[j]);
                this.croyantRattache[j]=null;
            }
        }
    }

    /**
     * Cette methode retourne si le guide possede des croyants ou pas.
     * @return un booleen
     */
    public boolean aCroyantRattache()
    {
        int i=0;
        while(i<this.croyantRattache.length && this.croyantRattache[i]!=null)
        {
            i++;
        }
        return i==this.croyantRattache.length;
    }

    /**
     * Retourne le nombre total de prieres de chaque croyant rattache a ce guide.
     * @return le nombre de prieres en entier.
     */
    public int priereGuide()
    {
        int priere=0;
        for(int i=0;i<this.croyantRattache.length;i++)
        {
            if(this.croyantRattache[i]!=null)
            priere=priere+this.croyantRattache[i].getNbCroyant();
        }
        return priere;
    }
}
