package divinae.carte.abstractcarte;

import divinae.Partie;
import divinae.Joueur;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.ArrayList;

public abstract class GuideSpirituel extends CarteDogme {
    private Croyant[] croyantRattache;
    public GuideSpirituel(Origine origine,Dogme[] dogme,int nbMaxCroyant)
    {
        super(origine,dogme);
        this.croyantRattache=new Croyant[nbMaxCroyant];

    }
    public void rattacher(Joueur j,Partie p)
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
                while(k<centre.get(i).getDogme().length && nbCroyant<croyantMax && !dogmeTrouve)
                {
                    if(this.getDogme()[j]==centre.get(i).getDogme()[k]&& nbCroyant<croyantMax)
                    {
                        this.croyantRattache[nbCroyant]=centre.remove(i);
                        i--;
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
}
