package divinae.carte.abstractcarte;

import divinae.enumeration.*;

public abstract class CarteDogme  extends Carte{
    private Dogme dogme;
    public CarteDogme(Origine origine,String nom,Dogme dogme)
    {
        super(origine,nom);
        this.dogme=dogme;
    }

    public Dogme getDogme() {
        return dogme;
    }

    public void setDogme(Dogme dogme) {
        this.dogme = dogme;
    }
}
