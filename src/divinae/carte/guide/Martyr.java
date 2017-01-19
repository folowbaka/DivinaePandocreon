package divinae.carte.guide;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.Apocalypse;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Martyr extends GuideSpirituel {
    public Martyr(Origine origine, Dogme[] dogme,int nbMaxCroyant,String cheminCarte) {
        super(origine, dogme,nbMaxCroyant,cheminCarte);
        this.setDescription("Sacrifice :\nEquivalent à la pose d'une\n" +
                "carte Apocalypse.\n");
        this.setNom("Martyr");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Apocalypse apocalypse = new Apocalypse(null,"ressource/image/apocalypse42.jpg");
        apocalypse.capacite(j,p);
    }
}
