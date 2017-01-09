package divinae.carte.deusEx;

import divinae.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;
import javafx.scene.image.Image;

public class Diversion extends DeusEx {

    public Diversion(Origine origine,Image imgCarte)
    {
        super(origine,imgCarte);
        this.setDescription("Prenez 3 cartes dans la main\n" +
                "d'un autre joueur et\n" +
                "incluez-les à votre main.");
        this.setNom("Diversion");
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        j.volerCarte(choixJoueur);
        j.volerCarte(choixJoueur);
        j.volerCarte(choixJoueur);
    }


}
