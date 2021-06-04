package thread;

import model.abstractClasses.GameCharacter;


public class PokemonTrainnerThread extends GameCharacter implements Runnable {

    public PokemonTrainnerThread(String imgURL) {
        super(imgURL);
    }

    @Override
    public void run() {

    }
}
