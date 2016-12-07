package divinae.carte.divinite;

import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Brewalen extends Divinite {
    public Brewalen(Origine origine, Dogme[] dogme) {
        super(origine,dogme);
        this.setDescriptionDivinite("Premier enfant du Jour, Brewalen cherche à représenter une certaine image de l'harmonie, et tente de mettre en place un statu quo entre les Divinités");
        this.setDescription("Peut empêcher l'utilisation d'une carte Apocalypse. La carte est défaussée.");
    }

    @Override
    public void capacite() {

    }
}
