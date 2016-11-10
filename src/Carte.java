import enumeration.Origine;

import java.util.Enumeration;

/**
 * Created by Folow on 10/11/2016.
 */
public abstract class Carte {
    private Origine origine;
    private String description;
    private String nom;

    public Carte(Origine origine,String description,String nom)
    {
        this.origine=origine;
        this.description=description;
        this.nom=nom;

    }
}
