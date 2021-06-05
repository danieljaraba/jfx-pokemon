package ui.classes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSpinner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.classes.Game;
import model.classes.Village;
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


    private Village[] villages;
    private Village current;
    private Game curentGame;
    public final static double STEP = 8;
    int down = 0;
    int up = 0;
    int left = 0;
    int right = 0;



    //TODO buscar una clase para que sesa la principal del modelo
    // TODO rangos para cambiar de mapa
    /**
     * Instantiates a new Master gui.
     */
    public MasterGUI() {
        villages = new Village[4];
        curentGame = new Game();
        //por el momento todos los pueblos tienen el mismo tamaño
        for (int i = 0; i <villages.length ; i++) {
            villages[i] = new Village(34,45,3,"pueblo: "+(i+1), 5);
            System.out.println(villages[i].getName()); //validacion
        }

        villages[0].addObject(110,250,35,115, false);
        villages[0].addObject(420,570,30,90, false);
        villages[0].addObject(810,950,35,115, false);
        villages[0].addObject(1120,1270,35,115, false);
        villages[0].addObject(140,290,215,295, false);
        villages[0].addObject(465,605,210,290, false);
        villages[0].addObject(840,990,215,295, false);
        villages[0].addObject(1165,1305,210,290, false);

        villages[0].addObject(110,250,435,515, false);
        villages[0].addObject(420,570,430,490, false);
        villages[0].addObject(810,950,435,515, false);
        villages[0].addObject(1120,1270,435,515, false);
        villages[0].addObject(140,290,615,695, false);
        villages[0].addObject(465,605,610,690, false);
        villages[0].addObject(840,990,615,695, false);
        villages[0].addObject(1165,1305,610,690, false);
        PokemonCreatorThread pct = new PokemonCreatorThread(villages);
        pct.start();

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../villages/village1.fxml"));
        fxmlLoader.setController(this);
        Parent village1 = fxmlLoader.load();
        borderPane.setCenter(village1);
        current = villages[0];
        curentGame.setCurrentTrainer(current.getPlayer());
        curentGame.setCurrentVillage(current);
        village1.requestFocus();


    }

    //metodo funciona en todas las pantallas que sean un mapa
    @FXML
    public void moveCharacter(KeyEvent event) throws IOException, InterruptedException {
        System.out.println(event.getCode());
        System.out.println("current x: "+imgPlayerAllVillages.getLayoutX());
        System.out.println("current y: "+imgPlayerAllVillages.getLayoutY());

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
        }

        if(event.getCode() == KeyCode.UP){
            moveUp();
            up++;
            imgPlayerAllVillages.setImage(new Image("/img/character/emerald_up_1.png"));
            if(up%2==0){
                imgPlayerAllVillages.setImage(new Image("/img/character/emerald_up_2.png"));
            }
            //imgPlayerAllVillages.setImage(new Image("/img/character/emerald_up_rest.png"));

        }

        if(event.getCode() == KeyCode.DOWN){
            moveDown();
            down++;
            imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_1.png"));
            if(down%2==0) {
                imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_2.png"));

            }
            //Permanecer quieto despues de moverse (seria buena idea hacerlo con hilos cada cierto tiempo)
            //imgPlayerAllVillages.setImage(new Image("/img/character/emerald_down_rest.png"));


        }
        if(event.getCode() == KeyCode.LEFT){
            moveLeft();
            left++;
            imgPlayerAllVillages.setImage(new Image("/img/character/emerald_left_1.png"));
            if(left%2==0){
                imgPlayerAllVillages.setImage(new Image("/img/character/emerald_left_2.png"));
            }
            //imgPlayerAllVillages.setImage(new Image("/img/character/emerald_left_rest.png"));

        }

        if(event.getCode() == KeyCode.RIGHT){
            moveRight();
            right++;
            imgPlayerAllVillages.setImage(new Image("/img/character/emerald_right_1.png"));
            if(right%2==0){
                imgPlayerAllVillages.setImage(new Image("/img/character/emerald_right_2.png"));
            }
            //imgPlayerAllVillages.setImage(new Image("/img/character/emerald_right_rest.png"));

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

    public void moveLeft(){
        current.moveLeft();
        imgPlayerAllVillages.setLayoutX(current.getPlayer().getX());
    }



    public void moveRight() {
        current.moveRight();
        imgPlayerAllVillages.setLayoutX(current.getPlayer().getX());
    }



    public void moveUp(){
        current.moveUp();
        imgPlayerAllVillages.setLayoutY(current.getPlayer().getY());

    }

    public void moveDown(){
        current.moveDown();
        imgPlayerAllVillages.setLayoutY(current.getPlayer().getY());

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

    public void createPokemons(){

    }

    @FXML
    //metodo temporal
    public void battle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/wildBattle.fxml"));
        fxmlLoader.setController(this);
        Parent battle = fxmlLoader.load();
        borderPane.setCenter(battle);


    }

    @FXML
    public void btTournamentNewGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../battles/battle2ExampleBetta.fxml"));
        fxmlLoader.setController(this);
        Parent tournament = fxmlLoader.load();
        borderPane.setCenter(tournament);

    }

    @FXML
    //metodo temporal tambien
    public void btExit(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../menus/NewGame.fxml"));
        fxmlLoader.setController(this);
        Parent tournament = fxmlLoader.load();
        borderPane.setCenter(tournament);
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





















    //Getters and Setters.

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
}
