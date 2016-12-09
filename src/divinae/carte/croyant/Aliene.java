package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Aliene extends Croyant {
    private int numero;
    public Aliene(Dogme[] dogme, int numero) {
        super(Origine.NEANT,dogme);
        switch(numero){
            case 1 :
                this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                        "possédant le Dogme Nature\n" +
                        "ou Mystique de sacrifier une\n" +
                        "de ses cartes de Croyants\n" +
                        "durant ce tour.");
                break;
            case 2 :
                this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                        "possédant le Dogme Mystique\n" +
                        "ou Chaos de sacrifier une\n" +
                        "de ses cartes de Croyants\n" +
                        "durant ce tour.");
                break;
            case 3 :
                this.setDescription("Sacrifice :\nVous piochez deux cartes au\n" +
                        "hasard dans la main d'une\n" +
                        "autre Divinité\n");
        }
        this.setNom("Aliéné");
        this.setNbCroyant(2);
    }

    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
