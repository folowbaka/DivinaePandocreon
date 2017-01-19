package divinae.carte;

import divinae.DivinaePandocreon;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Carte;
import divinae.enumeration.Origine;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class Apocalypse extends Carte {

    public Apocalypse(Origine origine,String cheminCarte) {
        super(origine,cheminCarte);
        this.setNom("Apocalypse");
    }

    @Override
    public void capacite(Joueur j, Partie p)
    {
        int joueurGagnant=0;
        int joueurPerdant=0;
        int scoreMax=p.getJoueur().get(0).compterPriere();
        int scoreMin=p.getJoueur().get(0).compterPriere();
        int tabScore[]=new int[p.getJoueur().size()];
        String affichageResultat="";
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
                affichageResultat="égalité";
            else
            {
                affichageResultat="Joueur : "+p.getJoueur().get(joueurPerdant).getNom()+" est éliminé";
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
                affichageResultat="Egalité";
            else
            {
                affichageResultat="Joueur : "+p.getJoueur().get(joueurGagnant).getNom()+" a gagné";
                p.setFintour(true);
                Partie.PARTIENONFINIE=false;
            }
        }
        switch (DivinaePandocreon.getVIEW())
        {
            case 1:
                System.out.println(affichageResultat);
                break;
            case 2:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(affichageResultat);
                alert.showAndWait();
                break;
        }
    }
}
