package divinae.carte.abstractcarte;

import divinae.enumeration.Origine;
import divinae.*;
import javafx.scene.image.Image;

/**
 * Represente une carte qui possede un nom, description et origine.
 */
public abstract class Carte {
    private Origine origine;
    private String description;
    private String nom;
    private String cheminCarte;

    /**
     * Constructeur d'une carte.
     * @param origine
     * @param cheminCarte
     * @return une Carte
     */
    public Carte(Origine origine,String cheminCarte)
    {
        this.origine=origine;
        this.cheminCarte=cheminCarte;
    }

    /**
     * La capacite generale de chaque carte.
     * Elle sera redefinie ensuite.
     * @param joueur
     * @param partie
     */
    public abstract void capacite(Joueur joueur,Partie partie);

    /**
     * Retourne l'origine d'une carte.
     * @return l'origine de cette carte.
     */
    public Origine getOrigine() {
        return origine;
    }

    /**
     * Retourne la description d'une carte.
     * @return la description de cette carte.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retourne le nom d'une carte.
     * @return le nom de cette carte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie l'origine d'une carte, le paramètre doit etre du type Origine.
     * @param origine
     * @see Origine
     */
    public void setOrigine(Origine origine) {
        this.origine = origine;
    }

    /**
     * Modifie la description d'une carte.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Modifie le nom d'une carte.
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'image de la carte.
     * @return l'imagine de cette carte.
     */
    public Image getImgCarte() {
        return new Image(this.cheminCarte);
    }

    /**
     * Modifie l'image de la carte, le parametre doit etre le chemin vers la cartet en String.
     * @param cheminCarte
     */
    public void setImgCarte(String cheminCarte) {

        this.cheminCarte = cheminCarte;
    }

    /**
     * Affichage de la carte.
     * @return la carte en texte.
     */
    @Override
    public String toString() {
        return "Carte{" +
                "origine=" + origine +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
