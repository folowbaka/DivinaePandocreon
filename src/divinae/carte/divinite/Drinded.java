package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Drinded extends Divinite {
    public Drinded(Image imgCarte) {
        super(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN,Dogme.SYMBOLE},imgCarte);
        this.setDescriptionDivinite("Défenseur des hommes, quelles que soient leurs croyances, Drinded protège les chefs religieux");
        this.setDescription("Peut empêcher le sacrifice d'un des Guides Spirituels de n'importe quel joueur.\n");
        this.setNom("Drinded");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }

}
