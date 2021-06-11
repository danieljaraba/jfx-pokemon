package thread;

import javafx.application.Platform;
import ui.classes.MasterGUI;

public class ResumeBattleThread extends Thread{
    private MasterGUI gui;

    public ResumeBattleThread(MasterGUI gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        Platform.runLater(new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gui.startBattle();
        }));
    }
}
