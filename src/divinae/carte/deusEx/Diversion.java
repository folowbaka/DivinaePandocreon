package divinae.carte.deusEx;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Diversion extends DeusEx {

    public Diversion(Origine origine,String cheminCarte)
    {
        super(origine,cheminCarte);
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
