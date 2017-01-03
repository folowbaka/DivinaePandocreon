package divinae;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

/*
 * Created by Folow on 27/12/2016.
 */
public class BeginLayoutController extends ControllerDivinae{
    @FXML
    private Button bJouer;
    @FXML
    private Button bQuitter;

    @FXML
    private void handleExit()
    {
        Platform.exit();
    }
    @FXML
    private void handlePlay()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("playercreationlayout.fxml"));
        VBox pCL=null;
        try {
            pCL=loader.load();
            PlayerCreationController pCC=loader.getController();
            pCC.setDpg(this.getDpg());

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.getDpg().getRootLayout().setCenter(pCL);
    }


}
