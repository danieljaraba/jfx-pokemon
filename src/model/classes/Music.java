package model.classes;

import java.applet.AudioClip;
//import javazoom.jlgui.basicplayer.BasicPlayer;

public class Music {
    public Music(){
        sound();
    }

    AudioClip sound;
    public void sound() {
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/music/retro.wav"));
        sound.play();
    }
}
