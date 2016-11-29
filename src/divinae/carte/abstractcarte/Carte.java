package divinae.carte.abstractcarte;

import divinae.enumeration.Origine;

/**
 * Created by Folow on 10/11/2016.
 */
public abstract class Carte {
    private Origine origine;
    private String description;
    private String nom;

    public Carte(Origine origine ,String nom)
    {
        this.origine=origine;
        this.nom=nom;
    }
    public abstract void capacite();

    public Origine getOrigine() {
        return origine;
    }

    public String getDescription() {
        return description;
    }

    public String getNom() {
        return nom;
    }

    public void setOrigine(Origine origine) {
        this.origine = origine;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}