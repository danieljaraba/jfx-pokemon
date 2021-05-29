package model;

public abstract class GameCharacter implements Autoplaying{

    private String img;

    public GameCharacter(String imgURL){
        this.img = imgURL;
    }
}
