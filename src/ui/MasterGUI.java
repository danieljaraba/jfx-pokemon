package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Village;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MasterGUI {
    //_______________ A. MAIN PANEL ____________
    //Attributes
    @FXML
    private BorderPane borderPane;
    @FXML
    private ImageView imgPlayerAllVillages;

    private Village[] villages;
    private Village current;
    public final static double STEP = 8;


    //TODO buscar una clase para que sesa la principal del modelo
    /**
     * Instantiates a new Master gui.
     */
    public MasterGUI() {
        villages = new Village[4];
        //por el momento todos los pueblos tienen el mismo tamaño
        for (int i = 0; i <villages.length ; i++) {
            villages[i] = new Village(34,45,10,"pueblo: "+(i+1));
            System.out.println(villages[i].getName()); //validacion
        }
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

    @FXML
    public void btnAdventureNewGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("village1.fxml"));
        fxmlLoader.setController(this);
        Parent village1 = fxmlLoader.load();
        village1.requestFocus();
        borderPane.setCenter(village1);
        current = villages[0];
    }

    //metodo funciona en todas las pantallas que sean un mapa
    @FXML
    public void moveCharacter(KeyEvent event) throws IOException {
        System.out.println(event.getCode());
        System.out.println("current x: "+imgPlayerAllVillages.getLayoutX());
        System.out.println("current y: "+imgPlayerAllVillages.getLayoutY());

        if(event.getCode() == KeyCode.UP){
            moveUp();
        }
        if(event.getCode() == KeyCode.DOWN){
            moveDown();

        }
        if(event.getCode() == KeyCode.LEFT){
            moveLeft();
        }
        if(event.getCode() == KeyCode.RIGHT){
            moveRight();
        }

        if (checkPosition()){
            List<String> choices = new ArrayList<>();
            String check = current.getName();
            switch (check){
                case "pueblo: 1": choices.add("pueblo: 2");
                                   choices.add("pueblo: 3");
                                   choices.add("pueblo: 4");
                                   break;
                case "pueblo: 2":choices.add("pueblo: 1");
                                 choices.add("pueblo: 3");
                                 choices.add("pueblo: 4");
                    break;

                case "pueblo: 3": choices.add("pueblo: 1");
                                  choices.add("pueblo: 2");
                                  choices.add("pueblo: 4");
                    break;

                case "pueblo: 4":  choices.add("pueblo: 1");
                                   choices.add("pueblo: 2");
                                   choices.add("pueblo: 3");
                    break;
            }
            ChoiceDialog<String> dialog = new ChoiceDialog<>(null, choices);
            dialog.setTitle("Where to go?");
            dialog.setHeaderText("Look, make a choice");
            dialog.setContentText("Choose your destiny:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
               if (result.get().equals("pueblo: 1")){
                   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("village1.fxml"));
                   fxmlLoader.setController(this);
                   Parent village1 = fxmlLoader.load();
                   borderPane.setCenter(village1);
                   current = villages[0];
               }else if(result.get().equals("pueblo: 2")){
                   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("village2.fxml"));
                   fxmlLoader.setController(this);
                   Parent village1 = fxmlLoader.load();
                   borderPane.setCenter(village1);
                   current = villages[1];

               }else if(result.get().equals("pueblo: 3")){
                   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("village3.fxml"));
                   fxmlLoader.setController(this);
                   Parent village1 = fxmlLoader.load();
                   borderPane.setCenter(village1);
                   current = villages[2];

               }else {
                   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("village4.fxml"));
                   fxmlLoader.setController(this);
                   Parent village1 = fxmlLoader.load();
                   borderPane.setCenter(village1);

                   current = villages[3];

               }
            }

        }



    }

    public void moveLeft(){
        double x = imgPlayerAllVillages.getLayoutX();
        imgPlayerAllVillages.setLayoutX(x-STEP);

    }



    public void moveRight() {
        double x = imgPlayerAllVillages.getLayoutX();
        x = x + STEP;
        imgPlayerAllVillages.setLayoutX(x);

    }



    public void moveUp(){
        double y = imgPlayerAllVillages.getLayoutY();
        y = y - STEP;
        imgPlayerAllVillages.setLayoutY(y);

    }

    public void moveDown(){
        double y = imgPlayerAllVillages.getLayoutY();
        y = y+STEP;
        imgPlayerAllVillages.setLayoutY(y);

    }

    public boolean checkPosition(){
        boolean change = false;
        if (imgPlayerAllVillages.getLayoutX() == -10.0 && imgPlayerAllVillages.getLayoutY() ==142.0){
            change = true;

        }else if(imgPlayerAllVillages.getLayoutX() == 473.0 && imgPlayerAllVillages.getLayoutY() ==337.0){
            change = true;

        }
        return change;
    }












    //Getters and Setters.

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
}
