package Controller;

import Controller.BottomGameController;
import Controller.ControllerDivinae;
import divinae.Partie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

/*
 * Controller pour le choix des noms des joueurs au debut de la partie.
 */
public class PlayerAskNameController extends ControllerDivinae
{
    private int nbJoueur;
    private int nbJoueurVirtuel;
    private int joueurCourant;
    private String[][] nomJoueur;

    @FXML
    private Button bValiderNomJoueur;

    @FXML
    private TextField tFieldInputNomJoueur;
    @FXML
    private Label lquestionNomJoueur;

    /**
     * Initialise le nombre de joueurs.
     */
    @FXML
    private void initialize()
    {
        this.joueurCourant=0;
        this.nbJoueur=0;
        this.nbJoueurVirtuel=0;
    }

    /**
     * Permet d'entrer les noms des joueurs.
     */
    @FXML
    private void handleValiderNomJoueur()
    {
        if(joueurCourant==0)
            this.nomJoueur=new String[2][nbJoueur];
        if(tFieldInputNomJoueur.getText().trim().length()>0)
        {
            this.nomJoueur[0][joueurCourant]=tFieldInputNomJoueur.getText().trim();
            if (joueurCourant < (nbJoueur - nbJoueurVirtuel) - 1) {
                joueurCourant++;
                lquestionNomJoueur.setText("Veuillez entrer le nom du joueur " + (joueurCourant + 1));
                tFieldInputNomJoueur.setText("");
            }
            else
            {
                joueurCourant++;
                for(int i=0;i<nbJoueur-(nbJoueur-nbJoueurVirtuel);i++)
                {
                    this.nomJoueur[1][i]="JV "+(i+1);
                }
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vue/bottomgamelayou.fxml"));
                Partie p=Partie.getInstance(nomJoueur);
                p.setInfluenceTour(p.lancerDes());
                for(int i=0;i<p.getJoueur().size();i++)
                    p.getJoueur().get(i).ajoutPoints(p.getInfluenceTour());
                this.getDpg().setPartie(p);
                this.getDpg().initCenterLayout();
                try {
                    HBox bottom=((HBox)loader.load());
                    BottomGameController bottomc=loader.getController();
                    bottomc.setDpg(this.getDpg());
                    bottomc.initBoard();
                    bottomc.refreshOrigine();
                    this.getDpg().getRootLayout().setBottom(bottom);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {

        }
    }

    /**
     * Setter nombre joueurs reels
     * @param nbJoueur
     */
    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    /**
     * Setter nombre joueurs virtuels
     * @param nbJoueurVirtuel
     */
    public void setNbJoueurVirtuel(int nbJoueurVirtuel) {
        this.nbJoueurVirtuel = nbJoueurVirtuel;
    }


}
