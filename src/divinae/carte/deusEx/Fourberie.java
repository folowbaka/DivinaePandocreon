package divinae.carte.deusEx;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Fourberie extends DeusEx {

    public Fourberie(Origine origine)
    {

        super(origine);
        this.setDescription("Sacrifiez 2 cartes Croyants\n" +
                "d'une autre Divinité. Les\n" +
                "capacités spéciales ne sont pas\n" +
                "jouées.\n");
        this.setNom("Fourberie");
    }

    @Override
    public void capacite(Joueur j, Partie p) {


    }
}
