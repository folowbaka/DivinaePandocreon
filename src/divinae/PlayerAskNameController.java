package divinae;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

/*
 * Created by Folow on 31/12/2016.
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
    @FXML
    private void initialize()
    {
        this.joueurCourant=0;
        this.nbJoueur=0;
        this.nbJoueurVirtuel=0;
    }
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
                FXMLLoader loader=new FXMLLoader(getClass().getResource("bottomgamelayou.fxml"));
                Partie p=Partie.getInstance(nomJoueur);
                p.setInfluenceTour(p.lancerDes());
                p.getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT).ajoutPoints(p.getInfluenceTour());
                this.getDpg().setPartie(p);
                try {
                    HBox bottom=((HBox)loader.load());
                    BottomGameController bottomc=loader.getController();
                    bottomc.setDpg(this.getDpg());
                    bottomc.initBoard();
                    this.getDpg().getRootLayout().setBottom(bottom);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                 loader=new FXMLLoader(getClass().getResource("centergamelayout.fxml"));
                VBox centerTable= null;
                try {
                    centerTable = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.getDpg().getRootLayout().setCenter(centerTable);
            }
        }
        else
        {
            System.out.println("nom de joueur vide");
        }
    }
    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public void setNbJoueurVirtuel(int nbJoueurVirtuel) {
        this.nbJoueurVirtuel = nbJoueurVirtuel;
    }


}
