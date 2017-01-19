package divinae.strategie;

import divinae.Joueur;
import divinae.Partie;
import divinae.Strategie;

import java.util.Random;

/*
 * Created by david on 12/12/2016.
 */
public class RNG implements Strategie {

    public void jouer(Joueur joueur, Partie partie)
    {
        System.out.println("Joueur : "+joueur.getNom()+" joue");
        Random rd=new Random();
        int numCarte=rd.nextInt(joueur.getMain().size());
        if(joueur.pointPourJouer(joueur.getMain().get(numCarte))) {
            joueur.getPointsAction().put(joueur.getMain().get(numCarte).getOrigine().toString(), joueur.getPointsAction().get(joueur.getMain().get(numCarte).getOrigine().toString()) - 1);
            joueur.jouer(numCarte, partie);
        }
    }
}
