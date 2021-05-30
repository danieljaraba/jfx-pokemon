package model.abstractClasses;

import model.interfaces.Autoplaying;

public abstract class GameCharacter implements Autoplaying {

    private String img;

    public GameCharacter(String imgURL){
        this.img = imgURL;
    }


}
