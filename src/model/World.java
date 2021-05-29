package model;

public abstract class World {

    private double height;
    private double width;
    private int wildPokemons;

    public World(double height, double width, int wildPokemons){
        this.height = height;
        this.width = width;
        this.wildPokemons = wildPokemons;
    }
}
