package model.abstractClasses;

import model.interfaces.Autoplaying;

import java.io.Serializable;

public abstract class GameCharacter implements Autoplaying, Serializable {

    private String img;

    public GameCharacter(String imgURL){
        this.img = imgURL;
    }

    public String getImg() {
        return img;
    }
}
