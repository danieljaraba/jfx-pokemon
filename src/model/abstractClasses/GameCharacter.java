package model.abstractClasses;
import java.io.Serializable;

public abstract class GameCharacter implements Serializable {

    private String img;

    public GameCharacter(String imgURL){
        this.img = imgURL;
    }

    public String getImg() {
        return img;
    }
}
