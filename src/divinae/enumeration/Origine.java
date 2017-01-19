package divinae.enumeration;

/**
 * Represente une enumeration des origines existantes : Jour, Aube, Neant, Crupuscule ou Nuit.
 */
public enum  Origine {
    JOUR("JOUR"),
    AUBE("AUBE"),
    NEANT("NEANT"),
    CREPUSCULE("CREPUSCULE"),
    NUIT("NUIT");

    private String origine="";

    Origine(String origine)
    {
        this.origine=origine;
    }
    /**
     * Affiche le nom de l'origine.
     * @return le nom de l'origine en string.
     */
    @Override
    public String toString() {
        return this.origine;
    }
}
