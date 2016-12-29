package divinae;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Folow on 28/12/2016.
 */
public class PlayerCreationController {

    private DivinaePandocreonGraphique dpg;

    @FXML
    private ToggleGroup jVirtuel;
    @FXML
    private ChoiceBox chbNbPlayer;
    @FXML
    private RadioButton virtuelNon;
    @FXML
    private RadioButton virtuelOui;
    @FXML
    private ChoiceBox chbNbPlayerV;
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
    }
    @FXML
    private void handleValiderJoueur()
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("playeraskname.fxml"));
        try {
            this.dpg.getRootLayout().setCenter((VBox)loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initChbVirtuel(int joueur)
    {
        System.out.println(joueur);
        ArrayList<Integer> ai=new ArrayList<Integer>();
        for(int i=1;i<joueur;i++)
        {
            ai.add(i);
        }
        chbNbPlayerV.getItems().setAll(ai);
    }
    public void setDpg(DivinaePandocreonGraphique dpg)
    {
        this.dpg=dpg;
    }
}
