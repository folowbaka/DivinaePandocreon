package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Gwenghelen extends Divinite {

    public Gwenghelen(Origine origine, String nom, Dogme dogme) {
        super(origine,nom, dogme);
        this.setDescriptionDivinite("Première Divinité à recevoir l'influence du Néant, Gwenghelen est celle qui en a reçu le plus de puissance");
        this.setDescription("Récupère autant de points d'Action supplémentaires d'Origine Néant que le nombre de Guides Spirituels que la Divinité possède.\n");
    }

    @Override
    public void capacite() {

    }
}
