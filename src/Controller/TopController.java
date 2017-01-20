package Controller;

import Controller.ControllerDivinae;
import divinae.DivinaePandocreonGraphique;
import divinae.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/*
 * Controller pour le haut de l'ecran avec les divinites.
 */
public class TopController extends ControllerDivinae {

    public ImageView getImgDivinite() {
        return imgDivinite;
    }
    @FXML
    private ImageView imgDivinite;

    /**
     * Permet la gestion de la capacite de la divinite.
     */
    @FXML
    private void  handleDivinite()
    {
        Joueur jcourant=this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
        if(!jcourant.getaUtiliseCompetenceDivine())
        {
            jcourant.getDivinite().capacite(jcourant, this.getDpg().getP());
            jcourant.setaUtiliseCompetenceDivine(true);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Vous avez deja utilisé votre divinité");
            alert.showAndWait();
            return;
        }
    }

    /**
     * Definie l'image de la divinite.
     * @param imgDivinite
     */
    public void setImgDivinite(ImageView imgDivinite) {
        this.imgDivinite = imgDivinite;
    }
}
