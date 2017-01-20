package divinae;

/**
 * Interface strategie avec la methode jouer.
 */
public interface Strategie
{
    /**
     * Plan de la methode jouer.
     * @param j joueur
     * @param p partie
     */
    public void jouer(Joueur j,Partie p);
}
