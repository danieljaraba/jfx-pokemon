package model.classes;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


/**
 * The type Music.
 */
public class Music {
    private String fileName;
    private MediaPlayer player;
    private int duration;
    private boolean stop;

    /**
     * Instantiates a new Music.
     *
     * @param fileName the file name
     */
    public Music(String fileName){
        this.fileName = fileName;
        duration = 155;
        stop = false;
    }

    /**
     * Init.
     */
    public void init(){
        PlatformImpl.startup(()->{});
        File file = new File(fileName);
        Media audio = new Media(file.toURI().toString());
        player = new MediaPlayer(audio);
        player.setAutoPlay(true);
    }


    /**
     * Gets player.
     *
     * @return the player
     */
    public MediaPlayer getPlayer() {
        return player;
    }



}
