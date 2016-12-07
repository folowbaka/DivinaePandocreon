package divinae.enumeration;

/**
 * Created by Folow on 10/11/2016.
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
    @Override
    public String toString() {
        return this.origine;
    }
}
