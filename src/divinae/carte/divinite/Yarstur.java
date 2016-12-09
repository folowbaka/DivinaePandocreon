package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Yarstur extends Divinite {

    public Yarstur() {
        super(Origine.JOUR,new Dogme[]{Dogme.CHAOS,Dogme.SYMBOLE,Dogme.MYSTIQUE});
        this.setDescriptionDivinite("Dernier pur du jour, Yarstur combat le Néant sous toutes ses formes");
        this.setDescription("Peut détruire toutes les cartes de Croyants au centre de la table d'Origine Néant.");
        this.setNom("Yartsur");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
