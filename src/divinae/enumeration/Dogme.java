package divinae.enumeration;

/**
 * Created by Folow on 10/11/2016.
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
    @Override
    public String toString()
    {
        return dogme;
    }
}
