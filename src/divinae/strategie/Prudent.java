package divinae.strategie;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.GuideSpirituel;

/*
 * Created by Folow on 24/11/2016.
 */
public class Prudent implements divinae.Strategie {

    public void jouer(Joueur j, Partie p)
    {
        System.out.println("Joueur : "+j.getNom()+" joue");
        int i=0;
        if(p.getCentreTable().size()==0)
        {
            while (i < j.getMain().size() && !(j.getMain().get(i) instanceof Croyant)) {

            }
            if(i<j.getMain().size())
            {
                if(j.pointPourJouer(j.getMain().get(i)))
                {
                    j.getPointsAction().put(j.getMain().get(i).getOrigine().toString(), j.getPointsAction().get(j.getMain().get(i).getOrigine().toString()) - 1);
                    j.jouer(i, p, j.getMain().get(i));
                }
            }

        }
        else
        {
            while (i < j.getMain().size() && !(j.getMain().get(i) instanceof GuideSpirituel)) {

            }
            if(i<j.getMain().size())
                j.jouer(i,p,j.getMain().get(i));
        }

    }
}
