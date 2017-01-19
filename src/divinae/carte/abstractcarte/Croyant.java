package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public abstract class Croyant extends CarteDogme{
    private int nbCroyant;
    private boolean rattachable;
    public Croyant(Origine origine,Dogme[] dogme, String cheminCarte)
    {
        super(origine,dogme,cheminCarte);
        this.rattachable=false;
    }
    public void setNbCroyant(int nbCroyant)
    {
        this.nbCroyant=nbCroyant;
    }
    public boolean getRattachable()
    {
        return this.rattachable;
    }
    public int getNbCroyant()
    {
        return this.nbCroyant;
    }

    public void setRattachable(boolean rattachable) {
        this.rattachable = rattachable;
    }
}
