package thread;

import model.classes.Music;

public class MusicThread extends Thread{
    public Music pokemonMusic;


    public MusicThread(){
        pokemonMusic = new Music("src/music/tyler-herro-instrumental.mp3");
    }


    @Override
    public void run(){
       pokemonMusic.init();
    }

    public Music getPokemonMusic() {
        return pokemonMusic;
    }
}
