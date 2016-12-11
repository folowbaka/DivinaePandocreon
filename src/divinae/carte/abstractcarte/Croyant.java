package divinae.carte.abstractcarte;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

import java.util.Scanner;

public abstract class Croyant extends CarteDogme{
    private int nbCroyant;
    private boolean rattachable;
    public Croyant(Origine origine,Dogme[] dogme)
    {
        super(origine,dogme);
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
}
