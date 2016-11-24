package divinae;

/**
 * Created by Folow on 24/11/2016.
 */
public class JoueurVirtuel extends Joueur{
    public JoueurVirtuel(String nom, Strategie strategie) {
        super(nom);
        this.strategie = strategie;
    }

    private Strategie strategie;
}
