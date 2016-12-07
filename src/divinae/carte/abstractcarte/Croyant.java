package divinae.carte.abstractcarte;

import divinae.Joueur;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public abstract class Croyant extends CarteDogme{
    private int nbCroyant;
    public Croyant(Origine origine,Dogme[] dogme)
    {
        super(origine,dogme);
    }
    public void setNbCroyant(int nbCroyant)
    {
        this.nbCroyant=nbCroyant;
    }
}
