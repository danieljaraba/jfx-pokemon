package model.abstractClasses;

import java.io.Serializable;

public abstract class World implements Serializable {

    private double height;
    private double width;
    private int wildPokemons;

    public World(double height, double width, int wildPokemons){
        this.height = height;
        this.width = width;
        this.wildPokemons = wildPokemons;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public int getWildPokemons() {
        return wildPokemons;
    }
}
