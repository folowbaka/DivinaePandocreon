package divinae;/**
 * Created by Folow on 27/12/2016.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class DivinaePandocreonGraphique extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private VBox beginLayout;
    private VBox topLayout;
    private TopController topController;
    private Partie p;
    private ObservableList<HashMap<String,Integer>> pointsData = FXCollections.observableArrayList();
    public static int JOUEURCOURANT=0;
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
        initTopLayout();

    }
    public void initBeginLayout(){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("beginlayout.fxml"));
            beginLayout=loader.load();
            rootLayout.setCenter(beginLayout);
            BeginLayoutController blc=loader.getController();
            blc.setDpg(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initTopLayout()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("toplayout.fxml"));
        try {
            topLayout=loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rootLayout.setTop(topLayout);
        topController=loader.getController();
        topController.setDpg(this);
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public void setPartie(Partie p)
    {
        this.p=p;
    }

    public Partie getP() {
        return p;
    }

    public TopController getTopController() {
        return topController;
    }

    public void setTopController(TopController topController) {
        this.topController = topController;
    }

    public ObservableList<HashMap<String, Integer>> getPointsData() {
        return pointsData;
    }

    public void setPointsData(ObservableList<HashMap<String, Integer>> pointsData) {
        this.pointsData = pointsData;
    }
}
