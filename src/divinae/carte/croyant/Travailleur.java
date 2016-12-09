package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import java.util.*;

public class Travailleur extends Croyant {
    private int numero;

    public Travailleur(Dogme[] dogme, int numero) {
        super(Origine.JOUR,dogme);
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
                        "possédant le Dogme Chaos\n" +
                        "ou Mystique de sacrifier une\n" +
                        "de ses cartes de Croyants\n" +
                        "durant ce tour.");
                break;
            case 3 :
                this.setDescription("Sacrifice :\nVous piochez deux cartes au\n" +
                        "hasard dans la main d'une\n" +
                        "autre Divinité\n");
        }

        this.setNom("Travailleur");
        this.setNbCroyant(2);
    }

    public void capacite(Joueur j,Partie p) {
        /*switch(numero) {
            case 1:
                if (j.getDivinite().getDogme().contains(Dogme.NATURE) || j.getDivinite().getDogme().contains(Dogme.MYSTIQUE)) {
                    j.denySacrifice();
                } else {
                    System.out.println("La divinité choisie est de mauvais type.");
                }
                break;
            case 2:
                if (j.getDivinite().getDogme().contains(Dogme.CHAOS) || j.getDivinite().getDogme().contains(Dogme.MYSTIQUE)) {
                    j.denySacrifice();
                } else {
                    System.out.println("La divinité choisie est de mauvais type.");
                }
                break;
            case 3:


        }*/



        }

}
