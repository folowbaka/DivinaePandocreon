package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public abstract class GuideSpirituel extends CarteDogme {
    private int nbMaxCroyant;

    public GuideSpirituel(Origine origine,Dogme[] dogme)
    {
        super(origine,dogme);
    }
    public void setNbMaxCroyant(int nbMaxCroyant)
    {
        this.nbMaxCroyant=nbMaxCroyant;
    }
}
