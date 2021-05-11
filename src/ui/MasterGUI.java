package ui;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class MasterGUI {
    //_______________ A. MAIN PANEL ____________
    @FXML
    private BorderPane borderPane;


    public MasterGUI() {
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

   /* public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }*/
}
