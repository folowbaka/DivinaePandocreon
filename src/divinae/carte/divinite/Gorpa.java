package divinae.carte.divinite;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Divinite;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;

public class Gorpa extends Divinite {
    public Gorpa() {
        super(Origine.CREPUSCULE,new Dogme[]{Dogme.HUMAIN,Dogme.SYMBOLE,Dogme.CHAOS});
        this.setDescriptionDivinite("Divinité joueuse et espiègle, Gorpa aime gêner ses consœurs dans leur recherche de puissance.");
        this.setDescription("Peut récupérer les points d'Action d'une autre Divinité en plus des siens. L'autre Divinité ne reçoit aucun point d'Action ce tour-ci.");
        this.setNom("Gorpa");
    }


    @Override
    public void capacite(Joueur j, Partie p) {

    }
}
