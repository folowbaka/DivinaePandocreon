package divinae.carte.abstractcarte;

import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

/**
 * Represente un croyant.
 */
public abstract class Croyant extends CarteDogme{
    private int nbCroyant;
    private boolean rattachable;

    /**
     * Constructeur du croyant.
     * @param origine
     * @param dogme
     * @param cheminCarte
     */
    public Croyant(Origine origine,Dogme[] dogme, String cheminCarte)
    {
        super(origine,dogme,cheminCarte);
        this.rattachable=false;
    }

    /**
     * Modifie le nombre de croyant, le paramètre est un entier.
     * @param nbCroyant
     */
    public void setNbCroyant(int nbCroyant)
    {
        this.nbCroyant=nbCroyant;
    }

    /**
     * Affiche si le croyant peut etre rattache a un guide ou pas.
     * @return estRattachable
     */
    public boolean estRattachable()
    {
        return this.rattachable;
    }

    /**
     * Affiche le nombre de prieres que cette carte represente.
     * @return
     */
    public int getNbCroyant()
    {
        return this.nbCroyant;
    }
    /**
     * Modifie si le croyant peut etre rattache a un guide ou pas.
     * @return
     */
    public void setRattachable(boolean rattachable) {
        this.rattachable = rattachable;
    }
}
