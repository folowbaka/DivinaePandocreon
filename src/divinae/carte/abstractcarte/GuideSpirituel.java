package divinae.carte.abstractcarte;

import divinae.Partie;
import divinae.Joueur;
import divinae.Joueur;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class GuideSpirituel extends CarteDogme {
    private Croyant[] croyantRattache;
    public GuideSpirituel(Origine origine,Dogme[] dogme,int nbMaxCroyant,String cheminCarte)
    {
        super(origine,dogme,cheminCarte);
        this.croyantRattache=new Croyant[nbMaxCroyant];

    }

    public Croyant[] getCroyantRattache() {
        return croyantRattache;
    }

    public void setCroyantRattache(Croyant[] croyantRattache) {
        this.croyantRattache = croyantRattache;
    }

    public void rattacher(Partie p)
    {
        ArrayList<Croyant> centre=p.getCentreTable();
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
                    if(this.getDogme()[j]==centre.get(i).getDogme()[k]&& nbCroyant<croyantMax && centre.get(i).getRattachable())
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
    public void libCroyant(Joueur joueur,Partie p)
    {
        for(int j=0;j<this.getCroyantRattache().length;j++)
        {
            if(this.croyantRattache[j]!=null)
            {
                p.getCentreTable().add(getCroyantRattache()[j]);
                this.croyantRattache[j]=null;
            }
        }
    }
    public boolean croyantVide()
    {
        int i=0;
        while(i<this.croyantRattache.length && this.croyantRattache[i]!=null)
        {
            i++;
        }
        return i==this.croyantRattache.length;
    }
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
