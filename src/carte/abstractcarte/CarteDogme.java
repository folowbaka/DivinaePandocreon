package carte.abstractcarte;

import enumeration.Dogme;

public abstract class CarteDogme  extends Carte{
    private Dogme dogme;

    public CarteDogme(Origine origine,String description,String nom,Dogme dogme)
    {
        super(origine,description,nom);
        this.dogme=dogme;
    }



}
