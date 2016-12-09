package divinae.carte.abstractcarte;

import divinae.enumeration.Origine;
import divinae.*;
/**
 * Created by Folow on 10/11/2016.
 */
public abstract class Carte {
    private Origine origine;
    private String description;
    private String nom;

    public Carte(Origine origine)
    {
        this.origine=origine;
    }
    public abstract void capacite(Joueur j,Partie p);

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

    @Override
    public String toString() {
        return "Carte{" +
                "origine=" + origine +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
