package divinae;

import divinae.carte.abstractcarte.Croyant;
import divinae.carte.abstractcarte.GuideSpirituel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;

/*
 * Created by Folow on 08/01/2017.
 */
public class CenterGameController extends ControllerDivinae {

    @FXML
    private TilePane centertable;

    @FXML
    private TilePane guideBoard;

    public void addCroyant(Croyant croyant)
    {

        centertable.getChildren().add(createImgCarte(croyant.getImgCarte()));
    }
    public void addGuide(GuideSpirituel guideSpirituel)
    {
        guideBoard.getChildren().add(createImgCarte(guideSpirituel.getImgCarte()));
        guideBoard.getChildren().get(guideBoard.getChildren().size()-1).setOnMouseEntered(new EventHandler<MouseEvent>() {
            private int idGuide=guideBoard.getChildren().size()-1;

            public void handle(MouseEvent event) {
                Joueur joueurcourant=getDpg().getP().getJoueur().get(DivinaePandocreonGraphique.JOUEURCOURANT);
                TilePane tpCroyant=new TilePane();
                for(int i=0;i<joueurcourant.getDivinite().getGuideDivinite().get(idGuide).getCroyantRattache().length;i++)
                {
                    Croyant croyant=joueurcourant.getDivinite().getGuideDivinite().get(idGuide).getCroyantRattache()[i];
                    if(croyant!=null)
                    {
                        ImageView iVCroyant = new ImageView();
                        iVCroyant.setImage(croyant.getImgCarte());
                        tpCroyant.getChildren().add(iVCroyant);
                    }
                }
                if(tpCroyant.getChildren().size()>0)
                {
                    Popup popup = new Popup();
                    popup.setX(300);
                    popup.setY(200);
                    popup.getContent().add(tpCroyant);
                    popup.show(getDpg().getPrimaryStage());
                }
            }
        });
    }
    public ImageView createImgCarte(Image image)
    {
        ImageView iVCarte=new ImageView(image);
        iVCarte.setFitWidth(130);
        iVCarte.setFitHeight(180);
        return iVCarte;
    }

    public void refreshGuideBoard(Joueur joueurcourant)
    {
        int i;
        guideBoard.getChildren().clear();
        for(i=0;i<joueurcourant.getDivinite().getGuideDivinite().size();i++)
        {
            addGuide(joueurcourant.getDivinite().getGuideDivinite().get(i));
        }
        System.out.println("carte "+i);

    }
    public void refreshCenterTable()
    {
        centertable.getChildren().clear();
        for(int i=0;i<this.getDpg().getP().getCentreTable().size();i++)
        {
            addCroyant(this.getDpg().getP().getCentreTable().get(i));
        }
    }
}
