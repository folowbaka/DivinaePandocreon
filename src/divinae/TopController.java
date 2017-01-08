package divinae;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/*
 * Created by Folow on 05/01/2017.
 */
public class TopController extends ControllerDivinae {

    public ImageView getImgDivinite() {
        return imgDivinite;
    }
    @FXML
    private ImageView imgDivinite;
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
    public void setImgDivinite(ImageView imgDivinite) {
        this.imgDivinite = imgDivinite;
    }
}
