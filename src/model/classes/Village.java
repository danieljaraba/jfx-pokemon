package model.classes;

import model.abstractClasses.World;

public class Village extends World {

    private String name;

    public Village(double height, double width, int wildPokemons, String name) {
        super(height, width, wildPokemons);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
