package Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Controller pour le debut de la partie.
 */
public class BeginLayoutController extends ControllerDivinae {
    @FXML
    private Button bJouer;
    @FXML
    private Button bQuitter;

    /**
     * Exit
     */
    @FXML
    private void handleExit()
    {
        Platform.exit();
    }

    /**
     * Debut de partie.
     */
    @FXML
    private void handlePlay()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vue/playercreationlayout.fxml"));
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
