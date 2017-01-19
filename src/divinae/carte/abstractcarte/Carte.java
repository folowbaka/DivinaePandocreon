package divinae.carte.abstractcarte;

import divinae.enumeration.Origine;
import divinae.*;
import javafx.scene.image.Image;

/**
 * Created by Folow on 10/11/2016.
 */
public abstract class Carte {
    private Origine origine;
    private String description;
    private String nom;
    private String cheminCarte;

    public Carte(Origine origine,String cheminCarte)
    {
        this.origine=origine;
        this.cheminCarte=cheminCarte;
    }
    public abstract void capacite(Joueur joueur,Partie partie);

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

    public Image getImgCarte() {
        return new Image(this.cheminCarte);
    }

    public void setImgCarte(String cheminCarte) {

        this.cheminCarte = cheminCarte;
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
