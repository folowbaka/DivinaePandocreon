package divinae;

public class Joueur {

    private String nom;
    protected Double pointJour;
    protected Double pointNuit;
    protected Double pointNeant;
    protected Boolean peutSacrifier;


    public Joueur(String nom)
    {
        this.nom=nom;
        this.pointJour=0;
        this.pointNeant=0;
        this.pointNuit=0;
        this.peutSacrifier=true;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
