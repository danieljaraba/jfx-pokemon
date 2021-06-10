package thread;

import javafx.application.Platform;
import ui.classes.MasterGUI;

import java.io.IOException;

public class LoadBattleThread extends Thread{
    private MasterGUI masterGUI;

    public LoadBattleThread(MasterGUI gui){
       masterGUI = gui;
    }

    public void run(){
        Platform.runLater(new Thread(() -> {
            try {
                Thread.sleep(2000);
                masterGUI.loadBattleTournament();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }));


    }



}
