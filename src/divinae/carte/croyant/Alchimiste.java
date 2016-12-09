package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Alchimiste extends Croyant {
    private int numero;

    public Alchimiste(Dogme[] dogme, int numero) {
        super(Origine.NUIT, dogme);
        switch(numero) {
            case 1 :
                this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                        "possédant le Dogme Humain\n" +
                        "ou Mystique de sacrifier une\n" +
                        "de ses cartes de Croyants\n" +
                        "durant ce tour de jeu.");
                break;
            case 2 :
                this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                        "possédant le Dogme Humain\n" +
                        "ou Symboles de sacrifier une\n" +
                        "de ses cartes de Croyants\n" +
                        "durant ce tour de jeu.");
                break;
            case 3 :
                this.setDescription("Sacrifice :\nVous piochez deux cartes au\n" +
                        "hasard dans la main d'une\n" +
                        "autre Divinité\n");
        }
        this.setNom("Alchimiste");
        this.setNbCroyant(2);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
