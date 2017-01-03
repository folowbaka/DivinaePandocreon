package divinae;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Folow on 02/01/2017.
 */
public class BottomGameController {

    @FXML
    private ImageView iVpioche;

    @FXML
    private void initialize()
    {
        Image ipioche=new Image("ressource/image/doscarte.jpg");
        iVpioche.setImage(ipioche);
    }

    public void initCarte()
    {

    }
}
