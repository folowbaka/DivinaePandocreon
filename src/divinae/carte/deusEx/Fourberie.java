package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Fourberie extends DeusEx {

    public Fourberie(Origine origine, String nom)
    {

        super(origine,nom);
        this.setDescription("Sacrifiez 2 cartes Croyants\n" +
                "d'une autre Divinité. Les\n" +
                "capacités spéciales ne sont pas\n" +
                "jouées.\n");
    }

    @Override
    public void capacite() {

    }
}
