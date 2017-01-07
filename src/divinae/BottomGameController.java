package divinae;

import com.sun.deploy.panel.ExceptionListDialog;
import divinae.carte.abstractcarte.Carte;
import divinae.enumeration.Origine;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import jdk.nashorn.internal.scripts.JO;

import java.util.HashMap;
import java.util.Observable;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by Folow on 02/01/2017.
 */
public class BottomGameController extends ControllerDivinae{

    private boolean defausser=false;
    @FXML
    private ObservableList<ImageView> mainJoueur= FXCollections.observableArrayList();
    @FXML
    private ImageView iVpioche;
    @FXML
    private Button bpiocher;
    @FXML
    private Button bdefausser;
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
        for(int i=0;i<board.getChildren().size();i++)
        {
            mainJoueur.add((ImageView) board.getChildren().get(i));
            mainJoueur.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                private int idCarte=mainJoueur.size()-1;

                public void handle(MouseEvent event) {
                    System.out.println(bdefausser.isFocused());
                    handleCarte(idCarte);
                }
            });;
        }

    }
    @FXML
    private void handleTerminerTour()
    {
        System.out.println(DivinaePandocreonGraphique.JOUEURCOURANT);
        Joueur j=this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
        j.setPeutRecevoirPoint(true);
        j.allowSacrificeCroyant();
        j.allowSacrificeGuide();
        if(DivinaePandocreonGraphique.JOUEURCOURANT+1==this.getDpg().getP().getJoueur().size())
        {
            DivinaePandocreonGraphique.JOUEURCOURANT=0;
        }
        else
        {

            DivinaePandocreonGraphique.JOUEURCOURANT++;
        }
        this.initBoard();
        bdefausser.setDisable(false);
        bpiocher.setDisable(false);

    }
    @FXML
    private void handleDefausser()
    {
            if(defausser)
            {
                bdefausser.setDisable(true);
            }
            else
            {
                defausser=true;
            }

    }
    @FXML
    private void handleCompleter()
    {
        bpiocher.setDisable(true);
        bdefausser.setDisable(true);

    }
    public void handleCarte(int num)
    {
        System.out.println(num);
        bpiocher.setDisable(true);
        if(defausser)
        {
            Partie p = this.getDpg().getP();
            Joueur j = p.getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
            j.defausseCarte(num,p);
        }
        else
        {
            bdefausser.setDisable(true);
            Partie p = this.getDpg().getP();
            Joueur j = p.getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);

            pointJouer(j, num, p, DivinaePandocreonGraphique.JOUEURCOURANT);
        }
        refreshBoard();
    }
    public void pointJouer(Joueur j,int c,Partie p,int joueurJoue)
    {
        Carte carte=j.getMain().get(c);
        if(carte.getOrigine()!=null)
        {
            int point = j.getPointsAction().get(carte.getOrigine().toString());
            if (c == 7)
            {
                j.getDivinite().capacite(j, p);
                j.setaUtiliseCompetenceDivine(true);
            }
            if (!j.pointPourJouer(carte))
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Vous n'avez pas assez de points pour jouer cette carte");
                alert.showAndWait();
                return;
            }
            if (point > 0)
            {
                j.getPointsAction().put(carte.getOrigine().toString(), point - 1);
            } else if (point <= 0 && carte.getOrigine() == Origine.NEANT ) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (j.getPointsAction().get("NUIT") > 1 && j.getPointsAction().get("JOUR") > 1) {
                    alert.setHeaderText("Vous pouvez choisir d'utiliser vos points jour ou nuit");
                    alert.setContentText("Choisissez les points à utiliser");

                    ButtonType buttonTypeJour = new ButtonType("Jour");
                    ButtonType buttonTypeNuit = new ButtonType("Nuit");
                    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                    alert.getButtonTypes().setAll(buttonTypeJour, buttonTypeNuit, buttonTypeCancel);

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == buttonTypeJour) {
                        j.getPointsAction().put("JOUR", j.getPointsAction().get("JOUR") - 2);
                    } else if (result.get() == buttonTypeNuit) {
                        j.getPointsAction().put("NUIT", j.getPointsAction().get("NUIT") - 2);
                    } else {
                        alert.close();
                        return;
                    }
                } else if (j.getPointsAction().get("NUIT") > 1) {
                    alert.setHeaderText("Vous pouvez choisir d'utiliser vos points nuit");
                    alert.setContentText("Voulez vous les utiliser?");
                    ButtonType buttonTypeNuit = new ButtonType("Non");
                    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeNuit, buttonTypeCancel);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == buttonTypeNuit) {
                        j.getPointsAction().put("NUIT", j.getPointsAction().get("NUIT") - 2);
                    } else {
                        alert.close();
                        return;
                    }
                } else if(j.getPointsAction().get("JOUR")>1)
                {
                    alert.setHeaderText("Vous pouvez choisir d'utiliser vos points Jour");
                    alert.setContentText("Voulez vous les utiliser?");
                    ButtonType buttonTypeJour = new ButtonType("Oui");
                    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeJour, buttonTypeCancel);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == buttonTypeJour) {
                        j.getPointsAction().put("JOUR", j.getPointsAction().get("JOUR") - 2);
                    } else {
                        alert.close();
                        return;
                    }
                }
            }
        }
        /*if(p.checkInterrompre(joueurJoue))
        {
            int inte;
            System.out.println("9---------Interrompre");
            inte=sc.nextInt();
            switch (inte)
            {
                case 9:
                    InterfaceCommand.interrompre(j,p,joueurJoue);
            }
        }*/
        j.jouer(c,p,carte);
    }
    public void initBoard()
    {
        Joueur joueurcourant=this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
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
    public void refreshBoard()
    {
        int i;
        Joueur joueurcourant=this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
        for(i=0;i<joueurcourant.getMain().size();i++)
        {
            ((ImageView)board.getChildren().get(i)).setImage(joueurcourant.getMain().get(i).getImgCarte());
        }
        for(i=i;i<board.getChildren().size();i++)
        {
            ((ImageView)board.getChildren().get(i)).setImage(null);
        }
        pointTable.refresh();

    }
}
