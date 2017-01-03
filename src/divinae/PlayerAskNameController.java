package divinae;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.awt.*;
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
                this.getDpg().getRootLayout().setCenter(null);
                FXMLLoader loader=new FXMLLoader(getClass().getResource("bottomgamelayout.fxml"));
                Partie p=Partie.getInstance(nomJoueur);
                this.getDpg().setPartie(p);
                try {
                    HBox bottom=((HBox)loader.load());
                    BottomGameController bottomc=loader.getController();

                    this.getDpg().getRootLayout().setBottom(bottom);
                } catch (IOException e) {
                    e.printStackTrace();
                }

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
