package divinae;/**
 * Created by Folow on 27/12/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DivinaePandocreonGraphique extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
        @Override
    public void start(Stage primaryStage) {
            this.primaryStage = primaryStage;
        try {
            rootLayout=FXMLLoader.load(getClass().getResource("rootlayout.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
        primaryStage.setTitle("Divinae Pandocreon");
        primaryStage.show();

    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
