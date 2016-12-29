package divinae;/**
 * Created by Folow on 27/12/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DivinaePandocreonGraphique extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private VBox beginLayout;
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
        initBeginLayout();

    }
    public void initBeginLayout(){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("beginlayout.fxml"));
            beginLayout=loader.load();
            rootLayout.setCenter(beginLayout);
            BeginLayoutController blc=loader.getController();
            blc.setDPG(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
