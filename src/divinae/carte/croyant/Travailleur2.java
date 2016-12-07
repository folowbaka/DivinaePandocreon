package divinae.carte.croyant;

import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Travailleur extends Croyant {
    public Travailleur(Dogme[] dogme) {
        super(Origine.JOUR,dogme);
        this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                "possédant le Dogme Nature\n" +
                "ou Mystique de sacrifier une\n" +
                "de ses cartes de Croyants\n" +
                "durant ce tour.");
        this.setNom("Travailleur");
        this.setNbCroyant(2);
    }
    public void capacite(Joueur j) {
        if (j.divinite.getDogme()=="Nature" || j.divinite.getDogme()=="Mystique"){
            j.peutSacrifier=false;
        }
        else {
            System.out.println("La divinité choisie est de mauvais type.");
        }
    }
}