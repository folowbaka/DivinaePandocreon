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
     * Lance la fenetre de depart.
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
     * Initialise la creation de la partie, choix des joueurs...
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

    /**
     * Initialise le haut de la fenetre avec les divinites.
     */
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

    /**
     * Initialise le centre de la fenetre avec le centre de la table et les guides associes.
     */
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

    /**
     * Getter rootLayout
     * @return rootLayout
     */
    public BorderPane getRootLayout() {
        return rootLayout;
    }

    /**
     * Getter primaryStage
     * @return primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Setter partie
     * @param p partie
     */
    public void setPartie(Partie p)
    {
        this.p=p;
    }

    /**
     * Getter Partie
     * @return partie
     */
    public Partie getP() {
        return p;
    }

    /**
     * Getter topController
     * @return topController
     */
    public TopController getTopController() {
        return topController;
    }

    /**
     * Setter topController
     * @param topController
     */
    public void setTopController(TopController topController) {
        this.topController = topController;
    }

    /**
     * Getter pointsData
     * @return pointsData
     */
    public ObservableList<HashMap<String, Integer>> getPointsData() {
        return pointsData;
    }

    /**
     * Getter centercontroller
     * @return centercontroller
     */
    public CenterGameController getCentercontroller() {
        return centercontroller;
    }

    /**
     * Setter centercontroller
     * @param centercontroller
     */
    public void setCentercontroller(CenterGameController centercontroller) {
        this.centercontroller = centercontroller;
    }

    /**
     * Setter pointsData
     * @param pointsData
     */
    public void setPointsData(ObservableList<HashMap<String, Integer>> pointsData) {
        this.pointsData = pointsData;
    }
}
