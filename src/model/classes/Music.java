package model.classes;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class Music {
    private String fileName;
    private MediaPlayer player;

    public Music(String fileName){
        this.fileName = fileName;
    }
    public void init(){
        PlatformImpl.startup(()->{});
        File file = new File(fileName);
        Media audio = new Media(file.toURI().toString());
        player = new MediaPlayer(audio);
        player.play();
        player.setAutoPlay(true);

    }

    public MediaPlayer getPlayer() {
        return player;
    }



    /**
    AudioClip sound;
    public void sound() {
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/music/retro.wav"));
        sound.play();
    }
     **/
}
