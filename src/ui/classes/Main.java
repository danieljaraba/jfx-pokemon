package ui.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import thread.MusicThread;


/**
 * Pokemon Game.
 * @author Camilo Campaz.
 * @author Camilo González.
 * @author Daniel Jaraba.
 * @author Johan Ricardo.
 * @since May 2021
 * @version 1.0
 */
public class Main extends Application {
    //Relationship.
    private MasterGUI masterGUI;

    public Main() {
        masterGUI = new MasterGUI();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));

        fxmlLoader.setController(masterGUI);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();


        primaryStage.setScene(scene);
        primaryStage.setTitle("POKÉMON");
        primaryStage.show();

        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../menus/Menu.fxml"));
        fxmlLoader1.setController(masterGUI);
        Parent loginPane = fxmlLoader1.load();
        masterGUI.getBorderPane().setCenter(loginPane);




    }
}
