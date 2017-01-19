package divinae.carte.croyant;

import divinae.DivinaePandocreon;
import Vue.InterfaceCommand;
import divinae.Joueur;
import divinae.Partie;
import divinae.carte.abstractcarte.Croyant;
import divinae.enumeration.Dogme;
import divinae.enumeration.Origine;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alchimiste extends Croyant {
    private int numero;

    public Alchimiste(Dogme[] dogme, int numero, String cheminCarte) {
        super(Origine.NUIT, dogme,cheminCarte);
        switch(numero) {
            case 1 :
                this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                        "possédant le Dogme Humain\n" +
                        "ou Mystique de sacrifier une\n" +
                        "de ses cartes de Croyants\n" +
                        "durant ce tour de jeu.");
                break;
            case 2 :
                this.setDescription("Sacrifice :\nEmpêche une Divinité\n" +
                        "possédant le Dogme Humain\n" +
                        "ou Symboles de sacrifier une\n" +
                        "de ses cartes de Croyants\n" +
                        "durant ce tour de jeu.");
                break;
            case 3 :
                this.setDescription("Sacrifice :\nVous piochez deux cartes au\n" +
                        "hasard dans la main d'une\n" +
                        "autre Divinité\n");
        }
        this.setNom("Alchimiste");
        this.setNbCroyant(2);
    }

    @Override
    public void capacite(Joueur j, Partie p) {
        Boolean boolcontient = false;
        Joueur choixJoueur;
        if(DivinaePandocreon.getVIEW()==2)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Choississez quel divinité voulez vous affecter");
            for(int i=0;i<p.getJoueur().size();i++)
            {
                ButtonType buttonTypeJoueur = new ButtonType("Joueur "+(i+1));
                alert.getButtonTypes().add(buttonTypeJoueur);

            }
            Optional<ButtonType> result = alert.showAndWait();
            choixJoueur=p.getJoueur().get(alert.getButtonTypes().indexOf(result.get()));
        }
        else
        {
            choixJoueur = InterfaceCommand.choixJoueur(p);
        }
        switch (numero) {

            case 1:
                for (int i = 0; i < j.getDivinite().getDogme().length; i++) {
                    if (j.getDivinite().getDogme()[i] == Dogme.HUMAIN || j.getDivinite().getDogme()[i] == Dogme.MYSTIQUE) {
                        boolcontient = true;
                    }
                }
                if (boolcontient) {
                    choixJoueur.denySacrificeCroyant();
                } else {
                    System.out.println("La divinité choisie est de mauvais type.");
                }
                break;
            case 2:
                for (int i = 0; i < j.getDivinite().getDogme().length; i++) {
                    if (j.getDivinite().getDogme()[i] == Dogme.HUMAIN || j.getDivinite().getDogme()[i] == Dogme.SYMBOLE) {
                        boolcontient = true;
                    }
                }
                if (boolcontient) {
                    choixJoueur.denySacrificeGuide();
                } else {
                    System.out.println("La divinité choisie est de mauvais type.");
                }
                break;
            case 3:
                j.volerCarte(choixJoueur);
                j.volerCarte(choixJoueur);

        }
    }
}
