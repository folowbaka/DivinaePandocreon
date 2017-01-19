package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Brewalen extends Divinite {
    public Brewalen(String cheminCarte) {
        super(Origine.JOUR,new Dogme[]{Dogme.NATURE,Dogme.HUMAIN,Dogme.MYSTIQUE},cheminCarte);
        this.setDescriptionDivinite("Premier enfant du Jour, Brewalen cherche à représenter une certaine ressource.image de l'harmonie, et tente de mettre en place un statu quo entre les Divinités");
        this.setDescription("Peut empêcher l'utilisation d'une carte Apocalypse. La carte est défaussée.");
        this.setNom("Brewalen");
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
