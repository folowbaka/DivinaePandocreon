package divinae;

public class Joueur {

    private String nom;

    public Joueur(String nom)
    {
        this.nom=nom;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
