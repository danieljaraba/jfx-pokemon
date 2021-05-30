package model.classes;

import model.abstractClasses.GameCharacter;

public class Player extends GameCharacter {

    private double x;
    private double y;

    public Player(String imgURL, double x, double y) {
        super(imgURL);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
