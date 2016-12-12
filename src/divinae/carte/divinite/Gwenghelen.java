package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Gwenghelen extends Divinite {

    public Gwenghelen() {
        super(Origine.AUBE,new Dogme[]{Dogme.HUMAIN,Dogme.MYSTIQUE,Dogme.SYMBOLE});
        this.setDescriptionDivinite("Première Divinité à recevoir l'influence du Néant, Gwenghelen est celle qui en a reçu le plus de puissance");
        this.setDescription("Récupère autant de points d'Action supplémentaires d'Origine Néant que le nombre de Guides Spirituels que la Divinité possède.\n");
        this.setNom("Gwenghelen");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        j.ajoutPoints(this.getGuideDivinite().size(),"NEANT");
    }
}
