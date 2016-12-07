package divinae.carte.abstractcarte;

import divinae.enumeration.*;

public abstract class CarteDogme  extends Carte{
    private Dogme[] dogme;
    public CarteDogme(Origine origine,Dogme[] dogme)
    {
        super(origine);
        this.dogme=dogme;
    }

    public Dogme[] getDogme() {
        return dogme;
    }

}
