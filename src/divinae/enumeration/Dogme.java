package divinae.enumeration;

/**
 * Represente une enumeration des dogmes existants : Nature, Humain, Symbole, Mystique ou Chaos.
 */

public enum Dogme {
    NATURE("NATURE"),
    HUMAIN("HUMAIN"),
    SYMBOLE("SYMBOLE"),
    MYSTIQUE("MYSTIQUE"),
    CHAOS("CHAOS");

    private String dogme="";

    Dogme(String dogme)
    {
        this.dogme=dogme;
    }

    /**
     * Affiche le nom du dogme.
     * @return le nom du dogme en string.
     */
    @Override
    public String toString()
    {
        return dogme;
    }

}
