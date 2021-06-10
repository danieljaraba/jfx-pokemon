package ui.classes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXSpinner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.classes.*;
import model.classes.Game;
import model.classes.Village;
import thread.LoadBattleThread;
import thread.MusicThread;
import thread.PokemonCreatorThread;

import java.io.File;
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

    @FXML
    private JFXSlider sldMusicVolumenOptions;

    @FXML
    private JFXSpinner spinnerLoadGame;

    //estos atributos van a cambiar en todas las battallas salvajes
    //se pueden utilizar tambien en las pantallas del torneo
    @FXML
    private ImageView imgPlayerWildBattle;

    @FXML
    private ImageView imgPokemonWildBattle;

    @FXML
    private JFXButton btFigthWildBattle;

    @FXML
    private JFXButton btLeaveWildBattle;

    @FXML
    private Label lbBattletext1WildBattle;

    @FXML
    private Label lbPokemonNameWildBattle;

    @FXML
    private Label lbBattletext2WildBattle;

    @FXML
    private JFXComboBox<String> comboPokemonattaks;

    @FXML
    private ToggleGroup rbCharacterAdventurePane;

    @FXML
    private JFXColorPicker colorPickerAdventurePane;

    @FXML
    private JFXTextField tfNameCharacterAdventurePane;

    @FXML
    private JFXRadioButton rbBoyCharacterAdventurePane;

    @FXML
    private JFXRadioButton rbGirlCharacterAdventurePane;

    @FXML
    private TextFlow tflTutorialPane;

    @FXML
    private ImageView imgFlatTutorialPane;

    @FXML
    private ImageView imgTeacherTutorialPane;


    @FXML
    private ImageView imgVPokemonTutorialPane;

    @FXML
    private JFXRadioButton rbBulbasaurTutorialPane;

    @FXML
    private ToggleGroup tgPokemonsTutorial;

    @FXML
    private JFXRadioButton rbCharmanderTutorialPanel;

    @FXML
    private JFXRadioButton rbSquirtleTutorialPane;

    @FXML
    private JFXButton btContinueTutorialPane;

    @FXML
    private Label lbTrainerNameTournamentBattle;




    private Village[] villages;
    private Village current;
    private Game curentGame;
    public final static double STEP = 8;
    private int down = 0;
    private int up = 0;
    private int left = 0;
    private int right = 0;
    private int num = 1;
    private String imgURL = "";
    private double lasPositionX;
    private double lasPositionY;
    private MusicThread musicThread;
    private PokemonCreatorThread pct;
    private Font textEdit = Font.font("Comic Sans",FontPosture.ITALIC, 30);



    //TODO buscar una clase para que sesa la principal del modelo
    // TODO rangos para cambiar de mapa
    /**
     * Instantiates a new Master gui.
     */
    public MasterGUI() {
        villages = new Village[4];
        curentGame = new Game();
        //por el momento todos los pueblos tienen el mismo tamaño


/*
        musicThread = new MusicThread();
        musicThread.start();
        try {
            musicThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
    }

    public void startGameAdventurePane(String nameCharacter,String imgURL,String nameColor){
        for (int i = 0; i <villages.length ; i++) {
            villages[i] = new Village(34,45,3,"pueblo: "+(i+1), 5,nameCharacter,imgURL,nameColor);

            System.out.println(villages[i].getName()); //validacion
        }

        villages[0].addObject(110,250,35,115, true, false);
        villages[0].addObject(420,570,30,90, false, false);
        villages[0].addObject(810,950,35,115, false, false);
        villages[0].addObject(1120,1270,35,115, false, false);
        villages[0].addObject(140,290,215,295, false, false);
        villages[0].addObject(465,605,210,290, false, false);
        villages[0].addObject(840,990,215,295, false, false);
        villages[0].addObject(1165,1305,210,290, false, false);

        villages[0].addObject(110,250,435,515, false, false);
        villages[0].addObject(420,570,430,490, false, false);
        villages[0].addObject(810,950,435,515, false, false);
        villages[0].addObject(1120,1270,435,515, false, false);
        villages[0].addObject(140,290,615,695, false, false);
        villages[0].addObject(465,605,610,690, false, false);
        villages[0].addObject(840,990,615,695, false, false);
        villages[0].addObject(1165,1305,610,690, false, false);

        addPokemonObjects();

        pct = new PokemonCreatorThread(villages);
        pct.start();

    }


    public void addPokemonObjects(){
        for (Village village : villages) {
            String villageName = village.getName();
            switch (villageName) {
                case "pueblo: 1":
                    village.addObject(565.0, 710.0, 330.0, 375.0, true, true);
                    village.addObject(630.0, 760.0, 25.0, 100.0, true, true);
                    village.addObject(1275.0, 1350.0, 540.0, 580.0, true, true);
                    break;
                case "pueblo: 2":
                    village.addObject(850.0, 930.0, 95.0, 125.0, true, true);
                    village.addObject(1135.0, 1220.0, 425.0, 465.0, true, true);
                    village.addObject(1155.0, 1245.0, 235.0, 275.0, true, true);
                    break;

                case "pueblo: 3":
                    village.addObject(690.0, 785.0, 30.0, 60.0, true, true);
                    village.addObject(1130.0, 1245.0, 40.0, 75.0, true, true);
                    village.addObject(405.0, 485.0, 275.0, 305.0, true, true);
                    break;

                case "pueblo: 4":
                    village.addObject( 1100.0, 1175.0, 505.0, 545.0, true, true);
                    village.addObject(435.0, 505.0, 575.0, 605.0, true, true);
                    village.addObject(945.0, 1020.0, 210.0, 255.0, true, true);
                    break;

            }
        }
    }






    /**
     * Bt credits menu.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btCreditsMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Credits.fxml"));
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

    /**
     * Bt load game menu.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btLoadGameMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/LoadGame.fxml"));
        fxmlLoader.setController(this);
        Parent loadGamePane = fxmlLoader.load();

        borderPane.setCenter(loadGamePane);
    }

    /**
     * Bt new game menu.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btNewGameMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/NewGame.fxml"));
        fxmlLoader.setController(this);
        Parent newGamePane = fxmlLoader.load();

        borderPane.setCenter(newGamePane);
    }

    /**
     * Bt options menu.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btOptionsMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Options.fxml"));
        fxmlLoader.setController(this);
        Parent optionsPane = fxmlLoader.load();

        borderPane.setCenter(optionsPane);
    }

    /**
     * Bt score menu.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btScoreMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Score.fxml"));
        fxmlLoader.setController(this);
        Parent scorePane = fxmlLoader.load();

        borderPane.setCenter(scorePane);
    }

    /**
     * Bt to back credits pane.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btToBackCreditsPane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Menu.fxml"));
        fxmlLoader.setController(this);
        Parent toBackMenuPane = fxmlLoader.load();

        borderPane.setCenter(toBackMenuPane);
    }

    @FXML
    public void btLeaveWildBattle(ActionEvent event) throws IOException {
        String result = current.getName();
        switch (result) {
            case "pueblo: 1": {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village1.fxml"));
                fxmlLoader.setController(this);
                Parent village1 = fxmlLoader.load();
                imgPlayerAllVillages.setLayoutX(lasPositionX-current.getMovement());
                imgPlayerAllVillages.setLayoutY(lasPositionY-current.getMovement());
                if(imgURL.equals("BOY")){
                    imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));
                }else{
                    imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_rest.png"));

                }
                borderPane.setCenter(village1);
                current = villages[0];
                curentGame.setCurrentVillage(current);
                village1.requestFocus();
                break;
            }
            case "pueblo: 2": {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village2.fxml"));
                fxmlLoader.setController(this);
                Parent village1 = fxmlLoader.load();
                imgPlayerAllVillages.setLayoutX(lasPositionX-current.getMovement());
                imgPlayerAllVillages.setLayoutY(lasPositionY-current.getMovement());
                if(imgURL.equals("BOY")){
                    imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));
                }else{
                    imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_rest.png"));

                }
                borderPane.setCenter(village1);
                current = villages[1];
                curentGame.setCurrentVillage(current);
                village1.requestFocus();

                break;
            }
            case "pueblo: 3": {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village3.fxml"));
                fxmlLoader.setController(this);
                Parent village1 = fxmlLoader.load();
                imgPlayerAllVillages.setLayoutX(lasPositionX-current.getMovement());
                imgPlayerAllVillages.setLayoutY(lasPositionY-current.getMovement());
                if(imgURL.equals("BOY")){
                    imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));
                }else{
                    imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_rest.png"));

                }
                borderPane.setCenter(village1);
                current = villages[2];
                curentGame.setCurrentVillage(current);
                village1.requestFocus();

                break;
            }
            default: {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village4.fxml"));
                fxmlLoader.setController(this);
                Parent village1 = fxmlLoader.load();
                imgPlayerAllVillages.setLayoutX(lasPositionX-current.getMovement());
                imgPlayerAllVillages.setLayoutY(lasPositionY-current.getMovement());
                if(imgURL.equals("BOY")){
                    imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));
                }else{
                    imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_rest.png"));

                }
                borderPane.setCenter(village1);
                current = villages[3];
                curentGame.setCurrentVillage(current);
                village1.requestFocus();

                break;
            }
        }

    }

    /**
     * Bt to back options pane.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btToBackOptionsPane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Menu.fxml"));
        fxmlLoader.setController(this);
        Parent toBackMenuPane = fxmlLoader.load();

        borderPane.setCenter(toBackMenuPane);
    }

    @FXML
    public void setMusicVolumen(MouseEvent event){
        System.out.println("Holam");
        double volumeValue = sldMusicVolumenOptions.getValue();
       musicThread.getPokemonMusic().getPlayer().setVolume(volumeValue/100);




    }

    /**
     * Bt to back new game pane.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btToBackNewGamePane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Menu.fxml"));
        fxmlLoader.setController(this);
        Parent toBackMenuPane = fxmlLoader.load();

        borderPane.setCenter(toBackMenuPane);
    }

    /**
     * Bt to back load game pane.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void btToBackLoadGamePane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Menu.fxml"));
        fxmlLoader.setController(this);
        Parent toBackMenuPane = fxmlLoader.load();

        borderPane.setCenter(toBackMenuPane);
    }

    @FXML
    public void btnAdventureNewGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Adventure.fxml"));
        fxmlLoader.setController(this);
        Parent adveturePane = fxmlLoader.load();


        borderPane.setCenter(adveturePane);



    }








    @FXML
    public void btStartAdventurePane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Tutorial.fxml"));
        fxmlLoader.setController(this);
        Parent tutorial = fxmlLoader.load();

        borderPane.setCenter(tutorial);
        tutorial.requestFocus();


        String nameCharacter = tfNameCharacterAdventurePane.getText();

        if(!tfNameCharacterAdventurePane.getText().equals("") && (rbGirlCharacterAdventurePane.isSelected() || rbBoyCharacterAdventurePane.isSelected())){

            tflTutorialPane.setVisible(true);
            imgFlatTutorialPane.setVisible(true);
            imgTeacherTutorialPane.setVisible(true);
            Text text1 = new Text("Hi! Sorry to keep you waiting! ");
            text1.setFont(textEdit);
            Text textName = new Text(nameCharacter);
            textName.setFont(textEdit);
            textName.setEffect(new Glow(5.0));
            textName.setFill(colorPickerAdventurePane.getValue());
            Text text2 = new Text(". Welcome to the world of POKEMON! My name is Reyes, but everyone calls me the POKEMON PROFESSOR. \n");
            text2.setFont(textEdit);
            Text text3 = new Text("                                     PRESS SPACE!");
            text3.setFont(textEdit);
            text3.setFill(colorPickerAdventurePane.getValue());
            text3.setEffect(new Glow(5.0));

            tflTutorialPane.getChildren().addAll(text1,textName,text2,text3);

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("LOOK");
            alert.setContentText("Write your name or choose your character. Please!");

            alert.showAndWait();
        }
    }



    @FXML
    public void btContinueTutorialPane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village1.fxml"));
        fxmlLoader.setController(this);
        Parent village1 = fxmlLoader.load();



        String nameCharacter = tfNameCharacterAdventurePane.getText();
        Color c = colorPickerAdventurePane.getValue();
        String colorCharacter = toRGBCode(c);


        if(rbBoyCharacterAdventurePane.isSelected()){
            imgURL = "BOY";
            imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));
        }else if(rbGirlCharacterAdventurePane.isSelected()){
            imgURL = "GIRL";
            imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_rest.png"));

        }




        if(!tfNameCharacterAdventurePane.getText().equals("") && (rbGirlCharacterAdventurePane.isSelected() || rbBoyCharacterAdventurePane.isSelected())) {
            borderPane.setCenter(village1);
            startGameAdventurePane(nameCharacter, imgURL,colorCharacter);
            current = villages[0];
            curentGame.setCurrentTrainer(current.getPlayer());
            curentGame.setCurrentVillage(current);

            System.out.println(current.getPlayer().getName());

            if(rbCharmanderTutorialPanel.isSelected()){
                Attack[] charizadAttak = new Attack[4];
                charizadAttak[0] = new Attack("Dragon Rage",40,20,10);
                charizadAttak[1] = new Attack("Fire spin",35,18,15);
                current.getPlayer().getTrainersBag().getUsedPokeballs().add(new Pokeball("",0, new FirePokemon(
                        "","Charmander", 100,1 , 200,50, true, "Fire", charizadAttak
                )));
            }else if(rbBulbasaurTutorialPane.isSelected()){
                Attack[] grovlyeAttacks = new Attack[4];
                grovlyeAttacks[0] = new Attack("Leaf bladde",70,35,30);
                grovlyeAttacks[1] = new Attack("Bullet seed",10,5,10);
                current.getPlayer().getTrainersBag().getUsedPokeballs().add(new Pokeball("",0, new FirePokemon(
                        "","Bulbasaur", 100,1 , 200,50, true, "Plant", grovlyeAttacks
                )));

            }else{
                Attack[] blastoideAttacks = new Attack[4];
                blastoideAttacks[0] = new Attack("Water gun",40,20,25);
                blastoideAttacks[1] = new Attack("Bubble",20,10,30);
                current.getPlayer().getTrainersBag().getUsedPokeballs().add(new Pokeball("",0, new FirePokemon(
                        "","Squirtle", 100,1 , 200,50, true, "Water", blastoideAttacks
                )));
            }
            System.out.println(current.getPlayer().getTrainersBag().getUsedPokeballs().get(0).getPokemon().getName());

            village1.requestFocus();
        }


    }

    @FXML
    public void btToBackAdventurePane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/NewGame.fxml"));
        fxmlLoader.setController(this);
        Parent toBackNewGamePane = fxmlLoader.load();

        borderPane.setCenter(toBackNewGamePane);
    }

    @FXML
    public void moveSpaceTutorialPane(KeyEvent event) throws IOException {
        String msg = "";
        System.out.println(event.getCode());



        if(event.getCode() == KeyCode.SPACE){

            switch (num) {
                case 1:  Text text4 = new Text("This is what we call a \"POKEMON\" this world is widely inhabited by" +
                        " creatures known as POKEMON. We humans live alongside POKEMON, at times as friendly playmates, and" +
                        " at times as cooperative workmates.");
                    text4.setFont(textEdit);
                    tflTutorialPane.getChildren().setAll();
                    tflTutorialPane.getChildren().addAll(text4);
                    imgVPokemonTutorialPane.setVisible(true);

                    num +=1;
                    break;
                case 2:  Text text5 = new Text("And sometimes, we band together and battle others like us. But hey, you need" +
                        " to know some things: Move your character with the arrows on your computer (↑ ← ↓ →).");
                    text5.setFont(textEdit);
                    tflTutorialPane.getChildren().setAll();
                    tflTutorialPane.getChildren().addAll(text5);

                    num +=1;
                    break;
                case 3:  Text text6 = new Text("You also have the possibility to press \"ESC\" to save your progress or return " +
                        "to the menu.");
                    text6.setFont(textEdit);
                    tflTutorialPane.getChildren().setAll();
                    tflTutorialPane.getChildren().addAll(text6);
                    num +=1;
                    break;
                case 4: Text text7 = new Text("All right, are you ready?");
                    text7.setFont(textEdit);
                    tflTutorialPane.getChildren().setAll();
                    tflTutorialPane.getChildren().addAll(text7);
                    num +=1;
                    break;
                case 5: Text text8 = new Text("Your very own adventure is about to unfold. Take courage, and leap into the " +
                        "world of POKEMON where dreams, adventure, and friendships await.");
                    text8.setFont(textEdit);
                    tflTutorialPane.getChildren().setAll();
                    tflTutorialPane.getChildren().addAll(text8);
                    num +=1;
                    break;
                case 6:  Text text9 = new Text("Well, first choose your little adventure friend!");
                    text9.setFont(textEdit);
                    tflTutorialPane.getChildren().setAll();
                    tflTutorialPane.getChildren().addAll(text9);
                    Color c = colorPickerAdventurePane.getValue();
                    String colorstring = toRGBCode(c);
                    imgTeacherTutorialPane.setVisible(false);
                    imgFlatTutorialPane.setVisible(false);
                    imgVPokemonTutorialPane.setVisible(false);
                    rbBulbasaurTutorialPane.setVisible(true);
                    rbBulbasaurTutorialPane.setStyle("-jfx-selected-color: " + colorstring + ";");
                    rbCharmanderTutorialPanel.setVisible(true);
                    rbCharmanderTutorialPanel.setStyle("-jfx-selected-color: " + colorstring + ";");
                    rbSquirtleTutorialPane.setVisible(true);
                    rbSquirtleTutorialPane.setStyle("-jfx-selected-color: " + colorstring + ";");
                    num = 0;
                    btContinueTutorialPane.setVisible(true);
                    break;
                default: msg = "DIOSSSS :(";
                    break;
            }

        }
    }


    //metodo funciona en todas las pantallas que sean un mapa
    @FXML
    public void moveCharacter(KeyEvent event) throws IOException {
        System.out.println(event.getCode());



        if (event.getCode() == KeyCode.ESCAPE){
            List<String> choices = new ArrayList<>();
            choices.add("Save my game");
            choices.add("Back to menu");
            choices.add("See the tutorial again");

            ChoiceDialog<String> dialog = new ChoiceDialog<>(null, choices);
            dialog.setTitle("Choice an option");
            dialog.setHeaderText("What do you want to do?");
            dialog.setContentText("Choose an action: ");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(this::makeElection);
        } else {
            if (event.getCode() == KeyCode.UP) {
                moveUp();
                up++;
                if (imgURL.equals("BOY")) {
                    imgPlayerAllVillages.setImage(new Image("/img/character/emerald_up_1.png"));
                } else if (imgURL.equals("GIRL")) {
                    imgPlayerAllVillages.setImage(new Image("/img/character/girl_up_1.png"));
                }
                if (up % 2 == 0) {
                    if (imgURL.equals("BOY")) {
                        imgPlayerAllVillages.setImage(new Image("/img/character/emerald_up_2.png"));
                    } else if (imgURL.equals("GIRL")) {
                        imgPlayerAllVillages.setImage(new Image("/img/character/girl_up_2.png"));
                    }
                }
                //imgPlayerAllVillages.setImage(new Image("/img/character/emerald_up_rest.png"));

            }

            if (event.getCode() == KeyCode.DOWN) {
                moveDown();
                down++;
                if (imgURL.equals("BOY")) {
                    imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_1.png"));
                } else if (imgURL.equals("GIRL")) {
                    imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_1.png"));
                }
                if (down % 2 == 0) {
                    if (imgURL.equals("BOY")) {
                        imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_2.png"));
                    } else if (imgURL.equals("GIRL")) {
                        imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_2.png"));
                    }
                }
                //Permanecer quieto despues de moverse (seria buena idea hacerlo con hilos cada cierto tiempo) o cuando dejer de oprimir la tecla
                //imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));


            }
            if (event.getCode() == KeyCode.LEFT) {
                moveLeft();
                left++;
                if (imgURL.equals("BOY")) {
                    imgPlayerAllVillages.setImage(new Image("/img/character/emerald_left_1.png"));
                } else if (imgURL.equals("GIRL")) {
                    imgPlayerAllVillages.setImage(new Image("/img/character/girl_left_1.png"));
                }
                if (left % 2 == 0) {
                    if (imgURL.equals("BOY")) {
                        imgPlayerAllVillages.setImage(new Image("/img/character/emerald_left_2.png"));
                    } else if (imgURL.equals("GIRL")) {
                        imgPlayerAllVillages.setImage(new Image("/img/character/girl_left_2.png"));
                    }
                }
                //imgPlayerAllVillages.setImage(new Image("/img/character/emerald_left_rest.png"));

            }

            if (event.getCode() == KeyCode.RIGHT) {
                moveRight();
                right++;
                if (imgURL.equals("BOY")) {
                    imgPlayerAllVillages.setImage(new Image("/img/character/emerald_right_1.png"));
                } else if (imgURL.equals("GIRL")) {
                    imgPlayerAllVillages.setImage(new Image("/img/character/girl_right_1.png"));
                }
                if (right % 2 == 0) {
                    if (imgURL.equals("BOY")) {
                        imgPlayerAllVillages.setImage(new Image("/img/character/emerald_right_2.png"));
                    } else if (imgURL.equals("GIRL")) {
                        imgPlayerAllVillages.setImage(new Image("/img/character/girl_right_2.png"));
                    }
                }
                //imgPlayerAllVillages.setImage(new Image("/img/character/emerald_right_rest.png"));

            }

            if (checkPosition()) {
                List<String> choices = new ArrayList<>();
                String check = current.getName();
                switch (check) {
                    case "pueblo: 1":
                        choices.add("pueblo: 2");
                        choices.add("pueblo: 3");
                        choices.add("pueblo: 4");
                        break;
                    case "pueblo: 2":
                        choices.add("pueblo: 1");
                        choices.add("pueblo: 3");
                        choices.add("pueblo: 4");
                        break;

                    case "pueblo: 3":
                        choices.add("pueblo: 1");
                        choices.add("pueblo: 2");
                        choices.add("pueblo: 4");
                        break;

                    case "pueblo: 4":
                        choices.add("pueblo: 1");
                        choices.add("pueblo: 2");
                        choices.add("pueblo: 3");
                        break;
                }

                ChoiceDialog<String> dialog = new ChoiceDialog<>(null, choices);
                dialog.setTitle("Where to go?");
                dialog.setHeaderText("Look, make a choice");
                dialog.setContentText("Choose your destiny:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    if (result.get().equals("pueblo: 1")) {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village1.fxml"));
                        fxmlLoader.setController(this);
                        Parent village1 = fxmlLoader.load();
                        borderPane.setCenter(village1);
                        current = villages[0];
                        curentGame.setCurrentVillage(current);
                        village1.requestFocus();
                    } else if (result.get().equals("pueblo: 2")) {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village2.fxml"));
                        fxmlLoader.setController(this);
                        Parent village1 = fxmlLoader.load();
                        borderPane.setCenter(village1);
                        current = villages[1];
                        if (imgURL.equals("BOY")) {
                            imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));
                        } else {
                            imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_rest.png"));

                        }
                        curentGame.setCurrentVillage(current);
                        village1.requestFocus();

                    } else if (result.get().equals("pueblo: 3")) {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village3.fxml"));
                        fxmlLoader.setController(this);
                        Parent village1 = fxmlLoader.load();
                        borderPane.setCenter(village1);
                        current = villages[2];
                        if (imgURL.equals("BOY")) {
                            imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));
                        } else {
                            imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_rest.png"));

                        }
                        curentGame.setCurrentVillage(current);
                        village1.requestFocus();

                    } else {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village4.fxml"));
                        fxmlLoader.setController(this);
                        Parent village1 = fxmlLoader.load();
                        borderPane.setCenter(village1);
                        current = villages[3];
                        if (imgURL.equals("BOY")) {
                            imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));
                        } else {
                            imgPlayerAllVillages.setImage(new Image("/img/character/girl_down_rest.png"));

                        }
                        curentGame.setCurrentVillage(current);
                        village1.requestFocus();

                    }
                }
            }

        }

    }

    public void makeElection(String election){
        switch (election){
            case "Save my game": TextInputDialog dialog = new TextInputDialog("walter");
                dialog.setTitle("Save a game");
                dialog.setHeaderText(null);
                dialog.setContentText("Please enter a name for saving this game:");
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    try {
                        curentGame.saveGame(result.get());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Game saved successfully");
                        alert.showAndWait();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "Back to menu":  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Menu.fxml"));
                fxmlLoader.setController(this);
                Parent toBackMenuPane = null;
                try {
                    toBackMenuPane = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                borderPane.setCenter(toBackMenuPane);
                break;
            default:
                System.out.println("Para que muestres el tuto kchon");
                break;
        }

    }

    public void moveLeft() throws IOException {
        String var = current.moveLeft();
        imgPlayerAllVillages.setLayoutX(current.getPlayer().getX());
        if(!var.equals("")){
            moveOption(var);
        }
    }



    public void moveRight() throws IOException {
        String var = current.moveRight();
        imgPlayerAllVillages.setLayoutX(current.getPlayer().getX());

        if(!var.equals("")){
            moveOption(var);
        }

    }



    public void moveUp() throws IOException {
        String var = current.moveUp();
        imgPlayerAllVillages.setLayoutY(current.getPlayer().getY());
        if(!var.equals("")){
            moveOption(var);
        }

    }

    public void moveDown() throws IOException {
        String var = current.moveDown();
        imgPlayerAllVillages.setLayoutY(current.getPlayer().getY());
        if(!var.equals("")){
            moveOption(var);
        }
    }

    public void moveOption(String var) throws IOException {
        switch (var){
            case "Method":
                moveVillage();
            break;
            case "Pokemon":
                pokemonZone();
            break;
        }
    }

    public void moveVillage() throws IOException {
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
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village1.fxml"));
                fxmlLoader.setController(this);
                Parent village1 = fxmlLoader.load();
                borderPane.setCenter(village1);
                current = villages[0];
                curentGame.setCurrentVillage(current);
                village1.requestFocus();
            }else if(result.get().equals("pueblo: 2")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village2.fxml"));
                fxmlLoader.setController(this);
                Parent village1 = fxmlLoader.load();
                borderPane.setCenter(village1);
                current = villages[1];
                curentGame.setCurrentVillage(current);
                village1.requestFocus();

            }else if(result.get().equals("pueblo: 3")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village3.fxml"));
                fxmlLoader.setController(this);
                Parent village1 = fxmlLoader.load();
                borderPane.setCenter(village1);
                current = villages[2];
                curentGame.setCurrentVillage(current);
                village1.requestFocus();

            }else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village4.fxml"));
                fxmlLoader.setController(this);
                Parent village1 = fxmlLoader.load();
                borderPane.setCenter(village1);
                current = villages[3];
                curentGame.setCurrentVillage(current);
                village1.requestFocus();

            }
        }
    }

    public boolean checkPosition(){
        boolean change = false;
        if ((imgPlayerAllVillages.getLayoutX() >= -20 && imgPlayerAllVillages.getLayoutX() <= 30) && (imgPlayerAllVillages.getLayoutY() >= 150 && imgPlayerAllVillages.getLayoutY() <= 195)){
            change = true;

        }else if(imgPlayerAllVillages.getLayoutX() == 473.0 && imgPlayerAllVillages.getLayoutY() ==337.0){
            change = true;
        }
        return change;
    }

    @FXML
    public void btTournamentNewGame(ActionEvent event) throws IOException {
       if(current == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("So sorry");
            alert.setHeaderText("There's a problem");
            alert.setContentText("You must set a character first \n So let's go to a new adventure");
            alert.showAndWait();
        }else {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/starTournament.fxml"));
           fxmlLoader.setController(this);
           Parent tournament = fxmlLoader.load();
           tournament.requestFocus();
           borderPane.setCenter(tournament);

        }
    }


    @FXML
    public void btLoadPreviousGameLoadGame(ActionEvent event) throws IOException {
        spinnerLoadGame.setVisible(true);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose your past game");
        fileChooser.setInitialDirectory(new File("data/serializableFiles/games_saved"));
        File f = fileChooser.showOpenDialog(borderPane.getScene().getWindow());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (f!=null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Loading Game");
            try {
                //el nuevo juego llama al anterior
                curentGame = curentGame.loadPreviousGame(f.getAbsolutePath());
                alert.setContentText("Game loaded successfully");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                alert.setContentText("Something went wrong");
            }
            alert.showAndWait();
            String currentVillage = curentGame.getCurrentVillage().getName();
            switch (currentVillage){
                case "pueblo: 1": FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village1.fxml"));
                    fxmlLoader.setController(this);
                    Parent village1 = fxmlLoader.load();
                    borderPane.setCenter(village1);
                    current = villages[0];
                    curentGame.setCurrentVillage(current);
                    village1.requestFocus();
                    break;
                case "pueblo: 2": FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("../villages/village2.fxml"));
                    fxmlLoader2.setController(this);
                    Parent village2 = fxmlLoader2.load();
                    borderPane.setCenter(village2);
                    current = villages[1];
                    curentGame.setCurrentVillage(current);
                    village2.requestFocus();
                    break;

                case "pueblo: 3":  FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("../villages/village3.fxml"));
                    fxmlLoader3.setController(this);
                    Parent village3 = fxmlLoader3.load();
                    borderPane.setCenter(village3);
                    current = villages[2];
                    curentGame.setCurrentVillage(current);
                    village3.requestFocus();
                    break;

                case "pueblo: 4":   FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("../villages/village4.fxml"));
                    fxmlLoader4.setController(this);
                    Parent village4 = fxmlLoader4.load();
                    borderPane.setCenter(village4);
                    current = villages[3];
                    curentGame.setCurrentVillage(current);
                    village4.requestFocus();
                    break;
            }

        }
    }

    public void pokemonZone(){
        lasPositionX = imgPlayerAllVillages.getLayoutX();
        lasPositionY = imgPlayerAllVillages.getLayoutY();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/wildBattle.fxml"));
        fxmlLoader.setController(this);
        int ramdomPokemon = (int) (Math.random()*2)+1;
        try {
            Parent battle = fxmlLoader.load();
            borderPane.setCenter(battle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            imgPokemonWildBattle.setImage(new Image(current.getLocalPokemons()[ramdomPokemon].getImg()));
            lbPokemonNameWildBattle.setText(current.getLocalPokemons()[ramdomPokemon].getName());
        }catch (IndexOutOfBoundsException ideo){
            System.out.println("Maldito ramdom");
            imgPokemonWildBattle.setImage(new Image(current.getLocalPokemons()[2].getImg()));
            lbPokemonNameWildBattle.setText(current.getLocalPokemons()[2].getName());
        }
    }


    @FXML
    public void cpchangeColorAdveturePane(ActionEvent event) {
            Color c = colorPickerAdventurePane.getValue();
            String colorstring = toRGBCode(c);
            if(rbGirlCharacterAdventurePane.isSelected() || rbBoyCharacterAdventurePane.isSelected()) {
                tfNameCharacterAdventurePane.setStyle("-fx-text-inner-color: "+colorstring+";");
                rbBoyCharacterAdventurePane.setStyle("-jfx-selected-color: " + colorstring + ";");
                rbGirlCharacterAdventurePane.setStyle("-jfx-selected-color: " + colorstring + ";");
            }else{
                colorPickerAdventurePane.setValue(Color.WHITE);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Look!!");
                alert.setContentText("Choose your character!");

                alert.showAndWait();
            }


    }

    public String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    @FXML
    public void loadVersusScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/versusScreen.fxml"));
        fxmlLoader.setController(this);
        Parent tournament = fxmlLoader.load();
        borderPane.setCenter(tournament);
        LoadBattleThread lbt = new LoadBattleThread(this);
        lbt.start();



    }

    public void loadBattleTournament() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("../battles/tournamentBattle.fxml"));
        fxmlLoader2.setController(this);
        Parent battleTournament = fxmlLoader2.load();
        borderPane.setCenter(battleTournament);
    }

    @FXML
    public void btLeaveTournamentBattle(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to leve this battle?");
        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne,buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()){
            if (result.get() == buttonTypeOne){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/starTournament.fxml"));
                fxmlLoader.setController(this);
                Parent tournament = fxmlLoader.load();
                tournament.requestFocus();
                borderPane.setCenter(tournament);
            }
        }


    }





    //Getters and Setters.

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
}
