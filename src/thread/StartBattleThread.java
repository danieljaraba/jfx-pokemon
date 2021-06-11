package thread;

import javafx.application.Platform;
import ui.classes.MasterGUI;

public class StartBattleThread extends Thread{

    private MasterGUI gui;

    public StartBattleThread(MasterGUI gui){
        this.gui = gui;
    }

    @Override
    public void run() {
        Platform.runLater(new Thread(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gui.startBattle();
        }));
    }
}
