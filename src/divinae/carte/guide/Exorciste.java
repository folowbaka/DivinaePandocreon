package divinae.carte.guide;

import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
/**
 * Represente une carte Guide Spirituel Anarchiste.
 * Sa capacite est defini dans la methode capacite.
 */
public class Exorciste extends GuideSpirituel{
    public Exorciste(Origine origine, Dogme[] dogme,int nbMaxCroyant,String cheminCarte) {
        super(origine, dogme,nbMaxCroyant,cheminCarte);
        this.setDescription("Sacrifice :\nUne Divinité d'Origine Nuit\n" +
                "ou ayant les Dogmes\n" +
                "Mystique et Chaos reprend\n" +
                "dans sa main l'un de ses\n" +
                "Guides Spirituels. Les\n" +
                "Croyants qui y étaient\n" +
                "attachés sont défaussés.");
        this.setNom("Exorciste");
    }
    /**
     *Capacite de la carte GuideSpirituel concernee, un guide revient dans la main de son proprietaire, les croyants reviennent sont defausses.
     * <p>
     * @param  Joueur  le joueur sur lequel l'effet aura lieu
     * @param  Partie la partie en cours
     * @see Joueur
     * @see Partie
     */
    @Override
    public void capacite(Joueur j, Partie p) {
        boolean boolDogme=true;
        Joueur choixJoueur;
        do{
            choixJoueur = InterfaceCommand.choixJoueur(p);
            if (choixJoueur.getDivinite().getOrigine()==Origine.NUIT){
                boolDogme=false;

            }
            for (int t=0;t<choixJoueur.getDivinite().getDogme().length;t++){
                if (choixJoueur.getDivinite().getDogme()[t]==Dogme.MYSTIQUE ||choixJoueur.getDivinite().getDogme()[t]==Dogme.CHAOS){
                    boolDogme=false;
                }
            }

            if(boolDogme){
                System.out.println("La divinité est de mauvais dogme ou de mauvaise origine.");
            }
        }while(boolDogme);
        int choixGuide = InterfaceCommand.choixGuide(choixJoueur,p);
        for(int i=0;i<choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getCroyantRattache().length;i++)
        {
            if(choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getCroyantRattache()[i]!=null)
            {
                p.getDefausse().add(choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getCroyantRattache()[i]);
                choixJoueur.getDivinite().getGuideDivinite().get(choixGuide).getCroyantRattache()[i]=null;
            }
        }
        choixJoueur.getMain().add(choixJoueur.getDivinite().getGuideDivinite().remove(choixGuide));

    }
}
