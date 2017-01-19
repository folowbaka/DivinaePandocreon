package divinae.strategie;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.GuideSpirituel;

/*
 * Created by Folow on 24/11/2016.
 */
public class Prudent implements divinae.Strategie {

    public void jouer(Joueur joueur, Partie partie)
    {
        System.out.println("Joueur : "+joueur.getNom()+" joue");
        int i=0;
        if(partie.getCentreTable().size()==0)
        {
            while (i < joueur.getMain().size() && !(joueur.getMain().get(i) instanceof Croyant)) {

            }
            if(i<joueur.getMain().size())
            {
                if(joueur.pointPourJouer(joueur.getMain().get(i)))
                {
                    joueur.getPointsAction().put(joueur.getMain().get(i).getOrigine().toString(), joueur.getPointsAction().get(joueur.getMain().get(i).getOrigine().toString()) - 1);
                    joueur.jouer(i, partie);
                }
            }

        }
        else
        {
            while (i < joueur.getMain().size() && !(joueur.getMain().get(i) instanceof GuideSpirituel)) {

            }
            if(i<joueur.getMain().size())
                joueur.jouer(i,partie);
        }

    }
}
