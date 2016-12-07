package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Yarstur extends Divinite {

    public Yarstur(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
        this.setDescriptionDivinite("Dernier pur du jour, Yarstur combat le Néant sous toutes ses formes");
        this.setDescription("Peut détruire toutes les cartes de Croyants au centre de la table d'Origine Néant.");
    }

    @Override
    public void capacite() {

    }
}
