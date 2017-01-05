package divinae;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import jdk.nashorn.internal.scripts.JO;

import java.util.HashMap;

/**
 * Created by Folow on 02/01/2017.
 */
public class BottomGameController extends ControllerDivinae{

    @FXML
    private ImageView iVpioche;
    @FXML
    private TableView<HashMap<String,Integer>> pointTable;
    @FXML
    private TableColumn<HashMap<String,Integer>,Integer> pointJourColumn;
    @FXML
    private TableColumn<HashMap<String,Integer>,Integer> pointNuitColumn;
    @FXML
    private TableColumn<HashMap<String,Integer>,Integer> pointNeantColumn;
    @FXML
    private HBox board;
    @FXML
    private ImageView imgDivinite;
    @FXML
    private Label nomjoueur;
    @FXML
    private void initialize()
    {
        Image ipioche=new Image("ressource/image/doscarte.jpg");
        iVpioche.setImage(ipioche);

        pointJourColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap<String,Integer>,Integer>, ObservableValue<Integer>>() {
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<HashMap<String,Integer>, Integer> p) {
                return new ReadOnlyObjectWrapper(p.getValue().get("JOUR"));
            }

        });
        pointNuitColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap<String,Integer>,Integer>, ObservableValue<Integer>>() {
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<HashMap<String,Integer>, Integer> p) {
                return new ReadOnlyObjectWrapper(p.getValue().get("NUIT"));
            }

        });
        pointNeantColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap<String,Integer>,Integer>, ObservableValue<Integer>>() {
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<HashMap<String,Integer>, Integer> p) {
                return new ReadOnlyObjectWrapper(p.getValue().get("NEANT"));
            }

        });

    }

    public void initBoard()
    {
        Joueur joueurcourant=this.getDpg().getP().getJoueur().get(0);
        System.out.println(joueurcourant);
        for(int i=0;i<joueurcourant.getMain().size();i++)
        {
            ((ImageView)board.getChildren().get(i)).setImage(joueurcourant.getMain().get(i).getImgCarte());
        }
        nomjoueur.setText(joueurcourant.getNom());
        this.getDpg().getTopController().getImgDivinite().setImage(joueurcourant.getDivinite().getImgCarte());
        this.getDpg().getPointsData().add(joueurcourant.getPointsAction());
        pointTable.setItems(this.getDpg().getPointsData());
        System.out.println(this.getDpg().getP().getInfluenceTour());

    }
}
