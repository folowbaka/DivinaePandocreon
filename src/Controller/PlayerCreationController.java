package Controller;

import Controller.ControllerDivinae;
import Controller.PlayerAskNameController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller pour la creation des joueurs
 */
public class PlayerCreationController extends ControllerDivinae {

    @FXML
    private ToggleGroup jVirtuel;
    @FXML
    private ChoiceBox chbNbPlayer;
    @FXML
    private RadioButton virtuelOui;
    @FXML
    private ChoiceBox chbNbPlayerV;
    @FXML
    private Button bvaliderCreation;

    /**
     * Initialise les variables.
     */
    @FXML
    private void initialize()
    {
        chbNbPlayer.getItems().addAll(FXCollections.observableArrayList(2,3,4,5,6));
       chbNbPlayer.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
           public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               initChbVirtuel((Integer)chbNbPlayer.getItems().get(newValue.intValue()));

           }
       });
        chbNbPlayer.getSelectionModel().selectFirst();
    }


    @FXML
    private void handleCheck()
    {
        if(jVirtuel.getSelectedToggle().equals(virtuelOui))
        {
            chbNbPlayerV.setDisable(false);
            initChbVirtuel((Integer)chbNbPlayer.getValue());
        }
        else
            chbNbPlayerV.setDisable(true);

        bvaliderCreation.setDisable(false);
    }

    /**
     * Permet la creation des joueurs avec l'affichage graphique.
     */
    @FXML
    private void handleValiderJoueur()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vue/playeraskname.fxml"));
        try {
            this.getDpg().getRootLayout().setCenter((VBox)loader.load());
            ((PlayerAskNameController)loader.getController()).setNbJoueur((Integer)chbNbPlayer.getValue());
            ((PlayerAskNameController)loader.getController()).setDpg(this.getDpg());
            if(!chbNbPlayerV.isDisabled())
            ((PlayerAskNameController)loader.getController()).setNbJoueurVirtuel((Integer)chbNbPlayerV.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initChbVirtuel(int joueur)
    {
        ArrayList<Integer> ai=new ArrayList<Integer>();
        for(int i=1;i<joueur;i++)
        {
            ai.add(i);
        }
        chbNbPlayerV.getItems().setAll(ai);
        chbNbPlayerV.getSelectionModel().selectFirst();
    }
}
