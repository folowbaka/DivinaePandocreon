package Controller;

import divinae.*;
import divinae.carte.Apocalypse;
import divinae.carte.abstractcarte.Carte;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.GuideSpirituel;
import divinae.enumeration.Origine;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.util.HashMap;
import java.util.Optional;

/*
 * Created by Folow on 02/01/2017.
 */
public class BottomGameController extends ControllerDivinae {

    private int tour;

    private boolean apocalypseJoue=false;

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
    private Label nomjoueur;
    @FXML
    private ImageView imgOrigine;
    @FXML
    private void initialize()
    {
        Image ipioche=new Image("ressource/image/carte/doscarte.jpg");
        tour=0;
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
                    handleCarte(idCarte);
                }
            });
            mainJoueur.get(i).setOnMouseEntered(new EventHandler<MouseEvent>() {
                private int idCarte=mainJoueur.size()-1;

                public void handle(MouseEvent event) {
                    resizeCarteUp(idCarte);
                }
            });
            mainJoueur.get(i).setOnMouseExited(new EventHandler<MouseEvent>() {
                private int idCarte=mainJoueur.size()-1;

                public void handle(MouseEvent event) {
                    resizeCarteDown(idCarte);
                }
            });
        }

    }
    @FXML
    private void handleTerminerTour()
    {
        Joueur j=this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
        j.setPeutRecevoirPoint(true);
        j.allowSacrificeCroyant();
        j.allowSacrificeGuide();
        while(this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT+1) instanceof JoueurVirtuel)
        {
            DivinaePandocreonGraphique.JOUEURCOURANT++;
            JoueurVirtuel jv= (JoueurVirtuel) this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
            jv.getStrategie().jouer(jv,this.getDpg().getP());
            this.initBoard();
            jv.setPeutRecevoirPoint(true);
            jv.allowSacrificeCroyant();
            jv.allowSacrificeGuide();
        }
        if(DivinaePandocreonGraphique.JOUEURCOURANT+1==this.getDpg().getP().getJoueur().size())
        {
            DivinaePandocreonGraphique.JOUEURCOURANT=0;
            this.getDpg().getP().setInfluenceTour(this.getDpg().getP().lancerDes());
            for(int i=0;i<this.getDpg().getP().getJoueur().size();i++)
            {
                this.getDpg().getP().getJoueur().get(i).ajoutPoints(this.getDpg().getP().getInfluenceTour());
            }
            this.refreshOrigine();
            tour++;
            if(tour==1)
                Partie.APOCALYPSE=true;
            else if(!Partie.APOCALYPSE && !apocalypseJoue)
                Partie.APOCALYPSE=true;

            apocalypseJoue=false;
            this.getDpg().getP().centreRattachable();
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
        if(((ImageView)board.getChildren().get(6)).getImage()!=null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Votre main est pleine");
            alert.showAndWait();
        }
        else
        {
            Joueur j = this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
            j.completerMain((this.getDpg().getP()));
            this.refreshBoard(j);
            bpiocher.setDisable(true);
            bdefausser.setDisable(true);
        }

    }
    public void handleCarte(int num)
    {
        bpiocher.setDisable(true);
        Partie p = this.getDpg().getP();
        Joueur j = p.getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
        if(defausser)
        {
            j.defausseCarte(num,p);
        }
        else
        {
            bdefausser.setDisable(true);
            pointJouer(j, num, p, DivinaePandocreonGraphique.JOUEURCOURANT);

        }
        refreshBoard(j);
    }
    public void pointJouer(Joueur j,int c,Partie p,int joueurJoue)
    {
        Carte carte=j.getMain().get(c);
        if(carte.getOrigine()!=null)
        {
            int point = j.getPointsAction().get(carte.getOrigine().toString());
            if(carte instanceof Apocalypse && !Partie.APOCALYPSE)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Vous ne pouvez pas jouer de carte Apocalypse ce tour");
                alert.showAndWait();
                return;
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
                    ButtonType buttonTypeNuit = new ButtonType("Oui");
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
        if(carte instanceof Croyant)
        {
            this.getDpg().getCentercontroller().addCroyant((Croyant)carte);
        }
        j.jouer(c,p,carte);
        if(carte instanceof GuideSpirituel)
        {
            this.getDpg().getCentercontroller().addGuide((GuideSpirituel) carte);
            this.getDpg().getCentercontroller().refreshCenterTable();

        }
        if(!Partie.APOCALYPSE)
            apocalypseJoue=true;
        if(!Partie.PARTIENONFINIE)
        {
            this.getDpg().getRootLayout().setBottom(null);
            this.getDpg().getRootLayout().setTop(null);
            Partie.setOurInstance(null);
            this.getDpg().initBeginLayout();
        }
    }
    public void initBoard()
    {
        Joueur joueurcourant=this.getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
        refreshBoard(joueurcourant);
        nomjoueur.setText(joueurcourant.getNom());
        this.getDpg().initTopLayout();

        this.getDpg().getTopController().getImgDivinite().setImage(joueurcourant.getDivinite().getImgCarte());
        this.getDpg().getCentercontroller().refreshGuideBoard(joueurcourant);
        this.getDpg().getPointsData().setAll(joueurcourant.getPointsAction());
        pointTable.setItems(this.getDpg().getPointsData());
        pointTable.refresh();

    }
    public void refreshBoard(Joueur joueurcourant)
    {
        int i;
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
    public void refreshOrigine()
    {
        switch(this.getDpg().getP().getInfluenceTour())
        {
            case JOUR:
                this.imgOrigine.setImage(new Image("ressource/image/origine/jour.png"));
                break;
            case NUIT:
                this.imgOrigine.setImage(new Image("ressource/image/origine/nuit.png"));
                break;
            case NEANT:
                this.imgOrigine.setImage(new Image("ressource/image/origine/neant.png"));
                break;

        }
    }
    public void resizeCarteUp(int num)
    {
        ((ImageView)board.getChildren().get(num)).setFitWidth(200);
        ((ImageView)board.getChildren().get(num)).setFitHeight(300);
    }
    public void resizeCarteDown(int num)
    {
        ((ImageView)board.getChildren().get(num)).setFitWidth(130);
        ((ImageView)board.getChildren().get(num)).setFitHeight(180);
    }}
