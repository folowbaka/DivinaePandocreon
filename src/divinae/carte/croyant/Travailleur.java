package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Travailleur extends Croyant {
    private int numero;

    public Travailleur(Dogme[] dogme, int numero) {
        super(Origine.JOUR,dogme);
        this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                "possédant le Dogme Nature\n" +
                "ou Mystique de sacrifier une\n" +
                "de ses cartes de Croyants\n" +
                "durant ce tour.");
        this.setNom("Travailleur");
        this.setNbCroyant(2);
    }


    public void capacite(Joueur j,Partie p) {
        /*switch(numero){
            case 1 :
                if (j.divinite.getDogme()=="NATURE" || j.divinite.getDogme()=="MYSTIQUE"){
                    j.denySacrifice();
                }
                else {
                    System.out.println("La divinité choisie est de mauvais type.");
                }
            break;
            case 2 :
                if (j.divinite.getDogme()=="CHAOS" || j.divinite.getDogme()=="MYSTIQUE"){
                    j.denySacrifice();
                }
                else {
                    System.out.println("La divinité choisie est de mauvais type.");
                }
            break;
            case 3 :



        */}

}
