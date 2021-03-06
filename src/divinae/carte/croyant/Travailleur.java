package divinae.carte.croyant;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import Vue.InterfaceCommand;
/**
 * Represente une carte croyant Travailleur.
 * Son sacrifice est defini dans la methode capacite.
 */
public class Travailleur extends Croyant {
    private int numero;

    public Travailleur(Dogme[] dogme, int numero, String cheminCarte) {
        super(Origine.JOUR,dogme,cheminCarte);
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
    /**
     *Capacite de la carte croyant concernee, en fonction de la version de la carte (attribut numero), cette capacite
     * permet d'empecher un sacrifice ou de voler 2 cartes.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    public void capacite(Joueur j,Partie p) {
        Boolean boolcontient = false;
        Joueur choixJoueur = InterfaceCommand.choixJoueur(p);
        switch(numero) {

            case 1:
                for (int i=0; i<j.getDivinite().getDogme().length;i++){
                    if (j.getDivinite().getDogme()[i]==Dogme.NATURE || j.getDivinite().getDogme()[i]==Dogme.MYSTIQUE){
                        boolcontient = true;
                    }
                }
                if (boolcontient) {
                    choixJoueur.denySacrificeCroyant();
                } else {
                    System.out.println("La divinité choisie est de mauvais type.");
                }
                break;
            case 2:
                for (int i=0; i<j.getDivinite().getDogme().length;i++){
                    if (j.getDivinite().getDogme()[i]==Dogme.CHAOS || j.getDivinite().getDogme()[i]==Dogme.MYSTIQUE){
                        boolcontient = true;
                    }
                }
                if (boolcontient) {
                    choixJoueur.denySacrificeGuide();
                } else {
                    System.out.println("La divinité choisie est de mauvais type.");
                }
                break;
            case 3:
                j.volerCarte(choixJoueur);
                j.volerCarte(choixJoueur);

        }



        }

}
