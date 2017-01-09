package divinae.carte.deusEx;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Concentration extends DeusEx {

    public Concentration(Origine origine,Image imgCarte)
    {
        super(origine,imgCarte);
        this.setDescription("Vous récupérez un des\n" +
                "Guides Spirituels posés\n" +
                "devant une autre Divinité et\n" +
                "le placez devant vous avec\n" +
                "les Croyants qui y sont\n" +
                "attachés.\n");
        this.setNom("Concentration");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        int choixGuide = InterfaceCommand.choixGuide(choixJoueur, p);
        choixJoueur.getDivinite().getGuideDivinite().add(choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide));

    }
}
