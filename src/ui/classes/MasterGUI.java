package ui.classes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.abstractClasses.Pokemon;
import model.classes.*;
import model.classes.Game;
import model.classes.Village;
import thread.*;


/**
 * The type Master gui.
 */
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
    private ImageView imgPlayerChoosePokemon;

    @FXML
    private ImageView imgPokemonChoosePokemon;

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


    @FXML
    private Label lbBattletext1ChoosePokemon;

    @FXML
    private JFXComboBox<String> cbPokemonChoosePokemonWild;

    @FXML
    private ImageView imgUserUserBattle;

    @FXML
    private ImageView imgAttackerUserBattle;

    @FXML
    private Label lbUserHealthUserBattle;

    @FXML
    private Label lbAttackerHealthUserBattle;

    @FXML
    private ImageView imgUserWildAttack;

    @FXML
    private ImageView imgAttackerWildAttack;

    @FXML
    private Label lbAttackWildAttack;

    @FXML
    private Label lbUserHealthWildAttack;

    @FXML
    private Label lbAttackerHealthWildAttack;

    @FXML
    private ImageView imgUserEndBattle;

    @FXML
    private ImageView imgAttackerEndBattle;

    @FXML
    private Label lbTextEndBattle;

    @FXML
    private JFXTextArea taTextPokedexPane;

    @FXML
    private JFXTextField tfNamePokedexPane;

    private PokemonBattleThread pokemonBattleThread;
    private Village[] villages;
    private Village current;
    private Game curentGame;
    /**
     * The constant STEP.
     */
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
    private Pokemon attacker;
    private Pokemon userPokemon;


    /**
     * Instantiates a new Master gui.
     */
    public MasterGUI() {
        villages = new Village[4];
        curentGame = new Game();
   /*     musicThread = new MusicThread();
        try {
            musicThread.start();
            musicThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    }


    /**
     * Start game adventure pane.
     *
     * @param nameCharacter the name character
     * @param imgURL        the img url
     * @param nameColor     the name color
     */
    public void startGameAdventurePane(String nameCharacter,String imgURL,String nameColor){
        for (int i = 0; i <villages.length ; i++) {
            villages[i] = new Village(370,225,3,"pueblo: "+(i+1), 5,nameCharacter,imgURL,nameColor);

            villages[i].addObject(-30, -15, -45, 800, false, false);
            villages[i].addObject(-30, 1400, -85, -45, false, false);
            villages[i].addObject(1370, 1400, -45, 800, false, false);
            villages[i].addObject(-30, 1400, 750, 770, false, false);

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

        villages[0].addObject(-15,45,-50,150, false, false);
        villages[0].addObject(50,115,-50,30, false, false);
        villages[0].addObject(115,250,-50,-5, false, false);

        villages[1].addObject(205,485,5,70,false,false);
        villages[1].addObject(0,175,15,615,false,false);
        villages[1].addObject(180,425,115,160,false,false);
        villages[1].addObject(180,420,365,365,false,false);
        villages[1].addObject(420,420,325,360,false,false);
        villages[1].addObject(425,515,315,335,false,false);
        villages[1].addObject(515,670,340,340,false,false);
        villages[1].addObject(670,670,285,340,false,false);
        villages[1].addObject(680,890,275,275,false,false);
        villages[1].addObject(895,895,275,415,false,false);
        villages[1].addObject(550,910,420,420,false,false);
        villages[1].addObject(560,560,420,535,false,false);
        villages[1].addObject(955,955,275,455,false,false);
        villages[1].addObject(635,960,450,450,false,false);
        villages[1].addObject(625,625,455,535,false,false);
        villages[1].addObject(565,625,535,535,false,false);
        villages[1].addObject(970,1100,270,270,false,false);

        villages[2].addObject(220,665,205,205,false,false);
        villages[2].addObject(220,220,205,285,false,false);
        villages[2].addObject(220,245,285,285,false,false);
        villages[2].addObject(235,235,300,450,false,false);
        villages[2].addObject(765,765,220,620,false,false);
        villages[2].addObject(890,1065,40,40,false,false);
        villages[2].addObject(845,1065,105,105,false,false);
        villages[2].addObject(365,610,240,240,false,false);

        villages[3].addObject(275,275,210,280,false,false);
        villages[3].addObject(280,275,355,540,false,false);
        villages[3].addObject(275,1060,555,555,false,false);

        addPokemonObjects();

        pct = new PokemonCreatorThread(villages);
        pct.start();

    }


    /**
     * Add pokemon objects.
     */
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

    /**
     * Bt leave wild battle.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btLeaveWildBattle(ActionEvent event) throws IOException {
        leaveBattle();
    }

    /**
     * Leave battle.
     *
     * @throws IOException the io exception
     */
    public void leaveBattle() throws IOException {
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

    /**
     * Set music volumen.
     *
     * @param event the event
     */
    @FXML
    public void setMusicVolumen(MouseEvent event){
        System.out.println("Holam");
        double volumeValue = sldMusicVolumenOptions.getValue();
        musicThread.getPokemonMusic().getPlayer().setVolume(volumeValue / 100);

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

    /**
     * Btn adventure new game.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btnAdventureNewGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/Adventure.fxml"));
        fxmlLoader.setController(this);
        Parent adveturePane = fxmlLoader.load();


        borderPane.setCenter(adveturePane);



    }

    /**
     * Bt start adventure pane.
     *
     * @param event the event
     * @throws IOException the io exception
     */
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


    /**
     * Bt continue tutorial pane.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btContinueTutorialPane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village1.fxml"));
        fxmlLoader.setController(this);
        Parent village1 = fxmlLoader.load();
        current = villages[0];
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
                        "/img/pokemon/pokemon_back_sprites/4.png","Charmander", 100,1 , 200,50, true, "Fire", charizadAttak
                )));
            }else if(rbBulbasaurTutorialPane.isSelected()){
                Attack[] grovlyeAttacks = new Attack[4];
                grovlyeAttacks[0] = new Attack("Leaf bladde",70,35,30);
                grovlyeAttacks[1] = new Attack("Bullet seed",10,5,10);
                current.getPlayer().getTrainersBag().getUsedPokeballs().add(new Pokeball("",0, new PlantPokemon(
                        "/img/pokemon/pokemon_back_sprites/Bulbasaur.png","Bulbasaur", 100,1 , 200,50, true, "Plant", grovlyeAttacks, 10
                )));

            }else{
                Attack[] blastoideAttacks = new Attack[4];
                blastoideAttacks[0] = new Attack("Water gun",40,20,25);
                blastoideAttacks[1] = new Attack("Bubble",20,10,30);
                current.getPlayer().getTrainersBag().getUsedPokeballs().add(new Pokeball("",0, new WaterPokemon(
                        "/img/pokemon/pokemon_back_sprites/Squirtle_back.png","Squirtle", 100,1 , 200,50, true, "Water", blastoideAttacks, true
                )));
            }
            System.out.println(current.getPlayer().getTrainersBag().getUsedPokeballs().get(0).getPokemon().getName());

            village1.requestFocus();
        }


    }

    /**
     * Bt to back adventure pane.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void btToBackAdventurePane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/NewGame.fxml"));
        fxmlLoader.setController(this);
        Parent toBackNewGamePane = fxmlLoader.load();

        borderPane.setCenter(toBackNewGamePane);
    }

    /**
     * Move space tutorial pane.
     *
     * @param event the event
     * @throws IOException the io exception
     */
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
                case 3:  Text text6 = new Text("You also have the possibility to press \"ESC\" to save your progress, See Pokedex or return " +
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
                    num = 1;
                    btContinueTutorialPane.setVisible(true);
                    break;
                default: msg = "DIOSSSS :(";
                    break;
            }

        }
    }


    /**
     * Move character.
     *
     * @param event the event
     * @throws IOException the io exception
     */
//metodo funciona en todas las pantallas que sean un mapa
    @FXML
    public void moveCharacter(KeyEvent event) throws IOException {
        System.out.println(event.getCode());
        if (event.getCode() == KeyCode.ESCAPE){

            List<String> choices = new ArrayList<>();
            choices.add("Save my game");
            choices.add("POKEDEX");
            choices.add("Back to menu");


            ChoiceDialog<String> dialog = new ChoiceDialog<>(null, choices);
            dialog.setTitle("Choice an option");
            dialog.setHeaderText("What do you want to do?");
            dialog.setContentText("Choose an action: ");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(this::makeElection);
        } else if(event.getCode()!= KeyCode.SPACE){
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
        }
    }

    /**
     * Make election.
     *
     * @param election the election
     */
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
            case "POKEDEX":
                FXMLLoader open = new FXMLLoader(getClass().getResource("../menus/Pokedex.fxml"));
                open.setController(this);
                Parent root = null;


                try {
                    root = open.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("Pokedex");
                stage.showAndWait();




                break;
            default:
                System.out.println("Para que muestres el tuto kchon");
                break;
        }

    }

    /**
     * Move left.
     *
     * @throws IOException the io exception
     */
    public void moveLeft() throws IOException {
        String var = current.moveLeft();
        imgPlayerAllVillages.setLayoutX(current.getPlayer().getX());
        if(!var.equals("")){
            moveOption(var);
        }
        System.out.println(current.getPlayer().getX() + " " + current.getPlayer().getY());
    }


    /**
     * Move right.
     *
     * @throws IOException the io exception
     */
    public void moveRight() throws IOException {
        String var = current.moveRight();
        imgPlayerAllVillages.setLayoutX(current.getPlayer().getX());

        if(!var.equals("")){
            moveOption(var);
        }
        System.out.println(current.getPlayer().getX() + " " + current.getPlayer().getY());
    }


    /**
     * Move up.
     *
     * @throws IOException the io exception
     */
    public void moveUp() throws IOException {
        String var = current.moveUp();
        imgPlayerAllVillages.setLayoutY(current.getPlayer().getY());
        if(!var.equals("")){
            moveOption(var);
        }
        System.out.println(current.getPlayer().getX() + " " + current.getPlayer().getY());
    }

    /**
     * Move down.
     *
     * @throws IOException the io exception
     */
    public void moveDown() throws IOException {
        String var = current.moveDown();
        imgPlayerAllVillages.setLayoutY(current.getPlayer().getY());
        if(!var.equals("")){
            moveOption(var);
        }
        System.out.println(current.getPlayer().getX() + " " + current.getPlayer().getY());
    }

    /**
     * Move option.
     *
     * @param var the var
     * @throws IOException the io exception
     */
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

    /**
     * Move village.
     *
     * @throws IOException the io exception
     */
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

    /**
     * Check position boolean.
     *
     * @return the boolean
     */
    public boolean checkPosition(){
        boolean change = false;
        if ((imgPlayerAllVillages.getLayoutX() >= -20 && imgPlayerAllVillages.getLayoutX() <= 30) && (imgPlayerAllVillages.getLayoutY() >= 150 && imgPlayerAllVillages.getLayoutY() <= 195)){
            change = true;

        }else if(imgPlayerAllVillages.getLayoutX() == 473.0 && imgPlayerAllVillages.getLayoutY() ==337.0){
            change = true;
        }
        return change;
    }

    /**
     * Bt tournament new game.
     *
     * @param event the event
     * @throws IOException the io exception
     */
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


    /**
     * Bt load previous game load game.
     *
     * @param event the event
     * @throws IOException the io exception
     */
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

    /**
     * Pokemon zone.
     */
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
            attacker = current.getLocalPokemons()[ramdomPokemon];
            imgPokemonWildBattle.setImage(new Image(attacker.getImg()));
            lbPokemonNameWildBattle.setText(current.getLocalPokemons()[ramdomPokemon].getName());
        }catch (IndexOutOfBoundsException ideo){
            System.out.println("Maldito ramdom");
            imgPokemonWildBattle.setImage(new Image(current.getLocalPokemons()[2].getImg()));
            lbPokemonNameWildBattle.setText(current.getLocalPokemons()[2].getName());
        }
    }

    /**
     * Choose pokemon.
     */
    public void choosePokemon(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/choosePokemon.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent battle = fxmlLoader.load();
            borderPane.setCenter(battle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgPokemonChoosePokemon.setImage(imgPokemonWildBattle.getImage());
        ArrayList<String> items = new ArrayList<>();
        for(int i = 0; i<current.getPlayer().getTrainersBag().getUsedPokeballs().size(); i++){
            cbPokemonChoosePokemonWild.getItems().add(current.getPlayer().getTrainersBag().getUsedPokeballs().get(i).getPokemon().getName());
        }
    }

    /**
     * Bt fight choose pokemon.
     *
     * @param event the event
     */
    @FXML
    void btFightChoosePokemon(ActionEvent event) {
        changeChoosePokemon("img/battles/emerald_battle_gif2.gif", 158, 201, 31, 126);
        userPokemon = current.getPlayer().getTrainersBag().getUsedPokeballs().get(
                current.searchPokemonIndex(cbPokemonChoosePokemonWild.getSelectionModel().getSelectedItem().toString())
        ).getPokemon();
        current.startBattle(attacker, userPokemon , current.getPlayer());
        StartBattleThread thread = new StartBattleThread(this);
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
    }

    /**
     * Start battle.
     */
    public void startBattle(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/userBattle.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent battle = fxmlLoader.load();
            borderPane.setCenter(battle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgUserUserBattle.setImage(new Image(userPokemon.getImg()));
        imgAttackerUserBattle.setImage(new Image(attacker.getImg()));
        lbUserHealthUserBattle.setText("Health: "+ current.getActiveBattle().getDefHealth());
        lbAttackerHealthUserBattle.setText("Health: "+ current.getActiveBattle().getAtkHealth());
    }

    /**
     * Change choose pokemon.
     *
     * @param url       the url
     * @param fitHeight the fit height
     * @param fitWidth  the fit width
     * @param x         the x
     * @param y         the y
     */
    public void changeChoosePokemon(String url, double fitHeight, double fitWidth, double x, double y){
        imgPlayerChoosePokemon.setImage(new Image(url));
        imgPlayerChoosePokemon.setFitHeight(fitHeight);
        imgPlayerChoosePokemon.setFitWidth(fitWidth);
        imgPlayerChoosePokemon.setLayoutX(x);
        imgPlayerChoosePokemon.setLayoutY(y);
    }

    /**
     * Bt fight wild battle.
     *
     * @param event the event
     */
    @FXML
    void btFightWildBattle(ActionEvent event) {
        choosePokemon();
    }

    /**
     * Bt attack 1 user battle.
     *
     * @param event the event
     */
    @FXML
    void btAttack1UserBattle(ActionEvent event) {
        current.getActiveBattle().userAttack(1);
        lbAttackerHealthUserBattle.setText("Health: "+ current.getActiveBattle().getAtkHealth());
        System.out.println("Health: "+ current.getActiveBattle().getAtkHealth());
        if(current.getActiveBattle().userWins()){
            battleWins(1);
        }else{
            changeAttackerScreen();
        }
    }

    /**
     * Bt attack 2 user battle.
     *
     * @param event the event
     */
    @FXML
    void btAttack2UserBattle(ActionEvent event) {
        current.getActiveBattle().userAttack(2);
        lbAttackerHealthUserBattle.setText("Health: "+ current.getActiveBattle().getAtkHealth());
        System.out.println("Health: "+ current.getActiveBattle().getAtkHealth());
        if(current.getActiveBattle().userWins()){
            battleWins(1);
        }else{
            changeAttackerScreen();
        }
    }

    /**
     * Bt attack 3 user battle.
     *
     * @param event the event
     */
    @FXML
    void btAttack3UserBattle(ActionEvent event) {
        current.getActiveBattle().userAttack(3);
        lbAttackerHealthUserBattle.setText("Health: "+ current.getActiveBattle().getAtkHealth());
        System.out.println("Health: "+ current.getActiveBattle().getAtkHealth());
        if(current.getActiveBattle().userWins()){
            battleWins(1);
        }else{
            changeAttackerScreen();
        }
    }

    /**
     * Bt attack 4 user battle.
     *
     * @param event the event
     */
//I
    @FXML
    void btAttack4UserBattle(ActionEvent event) {
        current.getActiveBattle().userAttack(4);
        lbAttackerHealthUserBattle.setText("Health: "+ current.getActiveBattle().getAtkHealth());
        System.out.println("Health: "+ current.getActiveBattle().getAtkHealth());
        if(current.getActiveBattle().userWins()){
            battleWins(1);
        }else{
            changeAttackerScreen();
        }
    }

    /**
     * Bt catch user battle.
     *
     * @param event the event
     */
    @FXML
    void btCatchUserBattle(ActionEvent event) {
        if(current.getActiveBattle().getAtkHealth() < 50){
            if(current.getPlayer().getTrainersBag().saveCapturedPokemon(current.getActiveBattle().getAttacker())){
                battleWins(3);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Look!!");
                alert.setContentText("Capture failed");

                alert.showAndWait();
                changeAttackerScreen();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Look!!");
            alert.setContentText("Capture failed");

            alert.showAndWait();
            changeAttackerScreen();
        }
    }


    /**
     * Change attacker screen.
     */
    public void changeAttackerScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/wildAttack.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent battle = fxmlLoader.load();
            borderPane.setCenter(battle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgUserWildAttack.setImage(new Image(userPokemon.getImg()));
        imgAttackerWildAttack.setImage(new Image(attacker.getImg()));
        lbUserHealthWildAttack.setText("Health: "+ current.getActiveBattle().getDefHealth());
        lbAttackerHealthWildAttack.setText("Health: "+ current.getActiveBattle().getAtkHealth());
        enemysTourn(current.getActiveBattle().getAtkHealth(), current.getActiveBattle().getDefHealth());
    }

    /**
     * Enemys tourn.
     *
     * @param atkHealth the atk health
     * @param defHealth the def health
     */
    public void enemysTourn(double atkHealth, double defHealth){
        pokemonBattleThread = new PokemonBattleThread(new PokemonBattle(userPokemon,attacker),this,defHealth,atkHealth);
        pokemonBattleThread.start();
    }

    /**
     * Resume battle.
     */
    public void resumeBattle(){
        ResumeBattleThread rbt = new ResumeBattleThread(this);
        rbt.start();
    }

    /**
     * Update gui.
     *
     * @param update    the update
     * @param atkHealth the atk health
     * @param defHealth the def health
     */
    public void updateGui(String update,double atkHealth, double defHealth ){
        System.out.println("Salud del enemigo: "+atkHealth);
        System.out.println("Salud del pendejo jugador: "+defHealth);
        lbUserHealthWildAttack.setText("Health: "+defHealth);
        lbAttackerHealthWildAttack.setText("Health: "+ atkHealth);
        current.getActiveBattle().setDefHealth(defHealth);
        current.getActiveBattle().setAtkHealth(atkHealth);
       // lbAttackWildAttack.setText("Attacker uses "+update);
    }

    /**
     * Battle wins.
     *
     * @param option the option
     */
    public void battleWins(int option){
        switch (option){
            case 1:
                chargeEndBattleScreen();
                lbTextEndBattle.setText("User wins");
                break;
            case 2:
                chargeEndBattleScreen();
                lbTextEndBattle.setText("Attacker wins");
                break;
            case 3:
                chargeEndBattleScreen();
                lbTextEndBattle.setText("Pokemon captured");
                break;
        }
    }

    /**
     * Bt leave end battle.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void btLeaveEndBattle(ActionEvent event) throws IOException {
        leaveBattle();
    }

    /**
     * Charge end battle screen.
     */
    public void chargeEndBattleScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/endBattle.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent battle = fxmlLoader.load();
            borderPane.setCenter(battle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgUserEndBattle.setImage(new Image(userPokemon.getImg()));
        imgAttackerEndBattle.setImage(new Image(attacker.getImg()));
    }

    /**
     * Cpchange color adveture pane.
     *
     * @param event the event
     */
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

    /**
     * To rgb code string.
     *
     * @param color the color
     * @return the string
     */
    public String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    /**
     * Load versus screen.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void loadVersusScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/versusScreen.fxml"));
        fxmlLoader.setController(this);
        Parent tournament = fxmlLoader.load();
        borderPane.setCenter(tournament);
        LoadBattleThread lbt = new LoadBattleThread(this);
        lbt.start();



    }

    /**
     * Load battle tournament.
     *
     * @throws IOException the io exception
     */
    public void loadBattleTournament() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("../battles/tournamentBattle.fxml"));
        fxmlLoader2.setController(this);
        Parent battleTournament = fxmlLoader2.load();
        borderPane.setCenter(battleTournament);
    }

    /**
     * Bt leave tournament battle.
     *
     * @param event the event
     * @throws IOException the io exception
     */
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

    /**
     * Bt search pokedex.
     *
     * @param event the event
     */
    @FXML
    public void btSearchPokedex(ActionEvent event) {
       String namePokemon = tfNamePokedexPane.getText();
        taTextPokedexPane.setFont(textEdit);

        switch (namePokemon) {
            case "Arcanine":

                taTextPokedexPane.setText("The sight of it running over 6,200 miles in a " +
                        "single day and night has captivated many people.");
                break;
            case "Blastoise":
                taTextPokedexPane.setText("It crushes its foe under its heavy body to cause fainting." +
                        " In a pinch, it will withdraw inside its shell.");
                break;
            case "Bulbasaur":
                taTextPokedexPane.setText("There is a plant seed on its back right from the day this Pokémon is born." +
                        " The seed slowly grows larger.");
                break;
            case "Charmander":
                taTextPokedexPane.setText("From the time it is born, a flame burns at the tip of its tail." +
                        " Its life would end if the flame were to go out.");
                break;
            case "Charizard":
                taTextPokedexPane.setText("It spits fire that is hot enough to melt boulders. " +
                        "It may cause forest fires by blowing flames.");
                break;
            case "Geodude":
                taTextPokedexPane.setText("Commonly found near mountain trails and the like." +
                        " If you step on one by accident, it gets angry.");
                break;
            case "Grovyle":
                taTextPokedexPane.setText("The leaves growing out of Grovyle’s body are convenient for camouflaging it from enemies in the forest." +
                        " This Pokémon is a master at climbing trees in jungles.");
                break;
            case "Mew":
                taTextPokedexPane.setText("When viewed through a microscope, this Pokémon’s short, fine, delicate hair can be seen.");
                break;
            case "Mewtwo":
                taTextPokedexPane.setText("Its DNA is almost the same as Mew’s. However, its size and disposition are vastly different.");
                break;
            case "Moltres":
                taTextPokedexPane.setText("It’s one of the legendary bird Pokémon. When Moltres flaps its flaming wings, " +
                        "they glimmer with a dazzling red glow.");
                break;
            case "Onix":
                taTextPokedexPane.setText("As it digs through the ground, " +
                        "it absorbs many hard objects. This is what makes its body so solid.");
                break;
            case "Pikachu":
                taTextPokedexPane.setText("Pikachu that can generate powerful electricity have cheek sacs that are extra soft and super stretchy.");
                break;
            case "Psyduck":
                taTextPokedexPane.setText("Psyduck is constantly beset by headaches. If the Pokémon lets its strange power erupt, apparently" +
                        " the pain subsides for a while.");
                break;
            case "Raikou":
                taTextPokedexPane.setText("Raikou embodies the speed of lightning. The roars of this Pokémon send shock waves shuddering" +
                        " through the air and shake the ground as if lightning bolts had come crashing down.");
                break;
            case "Snorlax":
                taTextPokedexPane.setText("It is not satisfied unless it eats over 880 pounds of food every day." +
                        " When it is done eating, it goes promptly to sleep.");
                break;
            case "Squirtle":
                taTextPokedexPane.setText("When it retracts its long neck into its shell, it squirts out water with vigorous force.");
                break;
            case "Venusaur":
                taTextPokedexPane.setText("Its plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight.");
                break;
            case "Zapdos":
                taTextPokedexPane.setText("This Pokémon has complete control over electricity." +
                        " There are tales of Zapdos nesting in the dark depths of pitch-black thunderclouds.");
                break;
            default:
                taTextPokedexPane.setText("Revisa el nombre del Pokemon");
        }

    }





    //Getters and Setters.

    public BorderPane getBorderPane() {
        return borderPane;
    }


    public MusicThread getMusicThread() {
        return musicThread;
    }


    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

}
