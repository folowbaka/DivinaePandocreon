package divinae;

/*
 * Created by Folow on 24/11/2016.
 */
public class JoueurVirtuel extends Joueur{
    private Strategie strategie;
    public JoueurVirtuel(String nom, Strategie strategie) {
        super(nom);
        this.strategie = strategie;
    }
    public Strategie getStrategie()
    {
        return this.strategie;
    }

}
