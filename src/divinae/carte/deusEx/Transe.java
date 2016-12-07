package divinae.carte.deusEx;

import divinae.carte.abstractcarte.DeusEx;
import divinae.enumeration.Origine;

public class Transe extends DeusEx {

    public Transe(Origine origine) {
        super(origine);
        this.setDescription("Permet de récupérer les effets\n" +
                "bénéfiques d'une carte\n" +
                "d'Action posée par une autre\n" +
                "Divinité. S'il s'agit d'une carte\n" +
                "Croyants ou Guide Spirituel,\n" +
                "vous posez la carte devant\n" +
                "vous.");
        this.setNom("Transe");
    }

    @Override
    public void capacite() {

    }
}
