package divinae.strategie;

import divinae.Joueur;
import divinae.Partie;
import divinae.Strategie;

import java.util.Random;

/*
 * Created by david on 12/12/2016.
 */
public class RNG implements Strategie {

    public void jouer(Joueur j, Partie p)
    {
        System.out.println("Joueur : "+j.getNom()+" joue");
        Random rd=new Random();
        int carte=rd.nextInt(j.getMain().size());
        if(j.pointPourJouer(j.getMain().get(carte))) {
            j.getPointsAction().put(j.getMain().get(carte).getOrigine().toString(), j.getPointsAction().get(j.getMain().get(carte).getOrigine().toString()) - 1);
            j.jouer(carte, p, j.getMain().get(carte));
        }
    }
}
