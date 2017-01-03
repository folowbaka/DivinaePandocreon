package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Yarstur extends Divinite {

    public Yarstur(Image imgCarte) {
        super(Origine.JOUR,new Dogme[]{Dogme.CHAOS,Dogme.SYMBOLE,Dogme.MYSTIQUE},imgCarte);
        this.setDescriptionDivinite("Dernier pur du jour, Yarstur combat le Néant sous toutes ses formes");
        this.setDescription("Peut détruire toutes les cartes de Croyants au centre de la table d'Origine Néant.");
        this.setNom("Yartsur");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
