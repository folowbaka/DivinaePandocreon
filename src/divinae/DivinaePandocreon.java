package divinae;

import com.sun.media.jfxmedia.control.VideoRenderControl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

/*
 * Created by Folow on 27/12/2016.
 */
public class DivinaePandocreon{
    private static int VIEW;

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int choixInterface;
        do {
            System.out.println("Voulez vous jouez avec une interface commande ou graphique?");
            System.out.println("1-----------------Commande");
            System.out.println("2-----------------Graphique");
            choixInterface=sc.nextInt();
        }while(choixInterface!=1 && choixInterface!=2);
        switch (choixInterface)
        {
            case 1:
                VIEW=1;
                new DivinaePandocreonCommande();
                break;
            case 2:
                VIEW=2;
                Application.launch(DivinaePandocreonGraphique.class,args);
                break;
        }
    }

    public static int getVIEW() {
        return VIEW;
    }
}
