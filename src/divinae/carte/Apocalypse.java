package divinae.carte;

import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Carte;
import divinae.enumeration.Origine;

public class Apocalypse extends Carte {

    public Apocalypse(Origine origine) {
        super(origine);
        this.setNom("Apocalypse");
    }

    @Override
    public void capacite(Joueur j, Partie p)
    {
        int joueurGagnant=0;
        int joueurPerdant=0;
        boolean egalite=false;
        int scoreMax=p.getJoueur().get(0).compterPriere();
        int scoreMin=p.getJoueur().get(0).compterPriere();
        int tabScore[]=new int[p.getJoueur().size()];
        for(int i=0;i<p.getJoueur().size();i++)
        {
            tabScore[i]=p.getJoueur().get(i).compterPriere();
            if(scoreMin>tabScore[i])
            {
                joueurPerdant=i;
                scoreMin=tabScore[i];
            }
            if(scoreMax<tabScore[i])
            {
                joueurGagnant=i;
                scoreMax=tabScore[i];
            }
        }
        int occurence=0;
        int i=0;
        if(p.getJoueur().size()>4)
        {
            while(i<p.getJoueur().size() && occurence<2)
            {
                if(scoreMin==tabScore[i])
                    occurence++;
            }
            if(occurence>=2)
                System.out.println("Egalité");
            else
            {
                System.out.println("Joueur : "+p.getJoueur().get(joueurPerdant).getNom()+" est éliminé");
                p.getJoueur().get(joueurPerdant).libGuideCroyant(p);
                p.getJoueur().remove(joueurPerdant);
                p.setFintour(true);
            }
            Partie.APOCALYPSE=false;
        }
        else
        {
            while(i<p.getJoueur().size() && occurence<2)
            {
                if(scoreMax==tabScore[i])
                    occurence++;
            }
            if(occurence>=2)
                System.out.println("Egalité");
            else
            {
                System.out.println("Joueur : "+p.getJoueur().get(joueurGagnant).getNom()+" a gagné");
                p.setFintour(true);
                Partie.PARTIENONFINIE=false;
            }
        }
    }
}
