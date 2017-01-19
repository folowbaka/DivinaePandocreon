package divinae;

import Controller.BeginLayoutController;
import Controller.CenterGameController;
import Controller.TopController;
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
/**
 * L'application en affichage graphique.
 */
public class DivinaePandocreonGraphique extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private VBox beginLayout;
    private VBox topLayout;
    private TopController topController;
    private CenterGameController centercontroller;
    private Partie p;
    private ObservableList<HashMap<String,Integer>> pointsData = FXCollections.observableArrayList();
    public static int JOUEURCOURANT=0;

    /**
     * Lance la fenetre.
     * @param primaryStage
     */
        @Override
    public void start(Stage primaryStage) {
            this.primaryStage = primaryStage;
        try {
            rootLayout=FXMLLoader.load(getClass().getResource("../Vue/rootlayout.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
        primaryStage.setTitle("Divinae Pandocreon");
        primaryStage.show();
        initBeginLayout();

    }

    /**
     * Initialise 
     */
    public void initBeginLayout(){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vue/beginlayout.fxml"));
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
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vue/toplayout.fxml"));
        try {
            topLayout=loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rootLayout.setTop(topLayout);
        topController=loader.getController();
        topController.setDpg(this);
    }
    public void initCenterLayout()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vue/centergamelayout.fxml"));
        VBox centerTable= null;
        try {
            centerTable = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.centercontroller=loader.getController();
        this.centercontroller.setDpg(this);
        this.rootLayout.setCenter(centerTable);
        this.centercontroller.initPopup();
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

    public CenterGameController getCentercontroller() {
        return centercontroller;
    }

    public void setCentercontroller(CenterGameController centercontroller) {
        this.centercontroller = centercontroller;
    }

    public void setPointsData(ObservableList<HashMap<String, Integer>> pointsData) {
        this.pointsData = pointsData;
    }
}
