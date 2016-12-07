package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class PuiTara extends Divinite {

    public PuiTara() {
        super(Origine.NUIT, new Dogme[]{Dogme.NATURE,Dogme.MYSTIQUE,Dogme.SYMBOLE});
        this.setDescriptionDivinite("Pui-Tara est la Divinité sur laquelle l'influence de la Nuit s'est faite la plus forte.");
        this.setDescription("Peut détruire toutes les cartes de Croyants au centre de la table d'Origine Jour.");
        this.setNom("Pui-Tara");
    }

    @Override
    public void capacite() {

    }
}
