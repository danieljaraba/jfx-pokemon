package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MasterGUI {
    //_______________ A. MAIN PANEL ____________
    //Attributes
    @FXML
    private BorderPane borderPane;


    /**
     * Instantiates a new Master gui.
     */
    public MasterGUI() {

    }

    @FXML
    public void btCreditsMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Credits.fxml"));
        fxmlLoader.setController(this);
        Parent creditsPane = fxmlLoader.load();

        borderPane.setCenter(creditsPane);
    }

    /**
     * Bt exit menu.
     *
     * @param event the event
     */
    @FXML
    public void btExitMenu(ActionEvent event) {

        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void btLoadGameMenu(ActionEvent event) {

    }

    @FXML
    public void btNewGameMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewGame.fxml"));
        fxmlLoader.setController(this);
        Parent newGamePane = fxmlLoader.load();

        borderPane.setCenter(newGamePane);
    }

    @FXML
    public void btOptionsMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Credits.fxml"));
        fxmlLoader.setController(this);
        Parent optionsPane = fxmlLoader.load();

        borderPane.setCenter(optionsPane);
    }

    @FXML
    public void btScoreMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Credits.fxml"));
        fxmlLoader.setController(this);
        Parent scorePane = fxmlLoader.load();

        borderPane.setCenter(scorePane);
    }

    @FXML
    public void btToBackCreditsPane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        fxmlLoader.setController(this);
        Parent toBackMenuPane = fxmlLoader.load();

        borderPane.setCenter(toBackMenuPane);
    }

    @FXML
    public void btToBackOptionsPane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        fxmlLoader.setController(this);
        Parent toBackMenuPane = fxmlLoader.load();

        borderPane.setCenter(toBackMenuPane);
    }

    @FXML
    public void btToBackNewGamePane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        fxmlLoader.setController(this);
        Parent toBackMenuPane = fxmlLoader.load();

        borderPane.setCenter(toBackMenuPane);
    }








    //Getters and Setters.

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
}
