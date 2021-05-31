package thread;

import model.classes.Music;

public class MusicThread extends Thread{
    public Music pokemonMusic;


    public MusicThread(){
        super();
        pokemonMusic = new Music();
    }


    @Override
    public void run(){
        try {
            pokemonMusic.sound();
            Thread.sleep(100 * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


    }

}
