package divinae;

/**
 * Represente un joueur virtuel.
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
