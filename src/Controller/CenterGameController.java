package Controller;

import divinae.DivinaePandocreonGraphique;
import divinae.Joueur;
import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.GuideSpirituel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;

import java.io.IOException;

/**
 * Controller du centre du jeu avec les guides et croyants mis au centre.
 */
public class CenterGameController extends ControllerDivinae {

    @FXML
    private TilePane centertable;

    @FXML
    private TilePane guideBoard;

    @FXML
    private TilePane croyantGuide;

    public  static Popup popup=new Popup();

    /**
     * Ajoute un croyant a l'affichage.
     * @param croyant
     */
    public void addCroyant(Croyant croyant)
    {

        centertable.getChildren().add(createImgCarte(croyant.getImgCarte()));
    }

    /**
     * Initialise le popup qui affiche les croyants d'un guide.
     */
    public void  initPopup()
    {
        ScrollPane popCroyant=null;
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vue/popupcroyant.fxml"));
        try {
            popCroyant=loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        popup.setX(300);
        popup.setY(300);
        popup.getContent().add(popCroyant);
    }

    /**
     * Ajoute un guide a l'affichage.
     * @param guideSpirituel
     */
    public void addGuide(GuideSpirituel guideSpirituel)
    {
        guideBoard.getChildren().add(createImgCarte(guideSpirituel.getImgCarte()));
        guideBoard.getChildren().get(guideBoard.getChildren().size()-1).setOnMouseEntered(new EventHandler<MouseEvent>() {
            private int idGuide=guideBoard.getChildren().size()-1;
            private TilePane guideCroyant= (TilePane) ((ScrollPane)popup.getContent().get(0)).getContent();
            private boolean show=false;
            public void handle(MouseEvent event) {
                if(!show)
                {
                    final Joueur joueurcourant=getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
                    for(int i=0;i<joueurcourant.getDivinite().getGuideDivinite().get(idGuide).getCroyantRattache().length;i++)
                    {
                        Croyant croyant=joueurcourant.getDivinite().getGuideDivinite().get(idGuide).getCroyantRattache()[i];
                        if(croyant!=null)
                        {
                            ImageView iVCroyant = new ImageView();
                            iVCroyant.setImage(croyant.getImgCarte());
                            iVCroyant.setFitWidth(130);
                            iVCroyant.setFitHeight(180);
                            guideCroyant.getChildren().add(iVCroyant);

                            guideCroyant.getChildren().get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                                private int idCroyant=guideCroyant.getChildren().size()-1;

                                public void handle(MouseEvent event) {
                                        joueurcourant.sacrifierCroyant(idGuide,idCroyant,getDpg().getP());
                                        refreshCenterTable();
                                        refreshGuideBoard(joueurcourant);
                                }
                            });
                        }
                    }
                    if(guideCroyant.getChildren().size()>0)
                    {
                        popup.show(getDpg().getPrimaryStage());
                        this.show=true;
                    }
                popup.getContent().get(0).setOnMouseExited(new EventHandler<MouseEvent>() {
                            private int idGuide=guideBoard.getChildren().size()-1;

                            public void handle(MouseEvent event) {
                                guideCroyant.getChildren().clear();
                                popup.hide();
                        show=false;
                    }
                });
            }}
        });
        guideBoard.getChildren().get(guideBoard.getChildren().size()-1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            private int idGuide=guideBoard.getChildren().size()-1;
            public void handle(MouseEvent event)
            {
                getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT).sacrifierGuide(idGuide,getDpg().getP());
                refreshCenterTable();
                refreshGuideBoard(getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT));
            }
        });
    }

    /**
     * Retourne une imageView a partir d'une image.
     * @param image
     * @return imageView
     * @see Image
     */
    public ImageView createImgCarte(Image image)
    {
        ImageView iVCarte=new ImageView(image);
        iVCarte.setFitWidth(130);
        iVCarte.setFitHeight(180);
        return iVCarte;
    }

    /**
     * Met a jour le plateau.
     * @param joueurcourant
     */
    public void refreshGuideBoard(Joueur joueurcourant)
    {
        int i;
        guideBoard.getChildren().clear();
        for(i=0;i<joueurcourant.getDivinite().getGuideDivinite().size();i++)
        {
            addGuide(joueurcourant.getDivinite().getGuideDivinite().get(i));
        }

    }

    /**
     * Met a jour le centre.
     */
    public void refreshCenterTable()
    {
        centertable.getChildren().clear();
        for(int i=0;i<this.getDpg().getP().getCentreTable().size();i++)
        {
            addCroyant(this.getDpg().getP().getCentreTable().get(i));
        }
    }
}
