package divinae;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

/**
 * Created by Folow on 05/01/2017.
 */
public class TopController extends ControllerDivinae {

    @FXML
    private ImageView imgDivinite;

    public ImageView getImgDivinite() {
        return imgDivinite;
    }

    public void setImgDivinite(ImageView imgDivinite) {
        this.imgDivinite = imgDivinite;
    }
}
