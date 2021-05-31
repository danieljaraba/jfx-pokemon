package model.classes;

import model.abstractClasses.GameCharacter;

public class PokemonNurse extends GameCharacter {

    private String name;

    public PokemonNurse(String imgURL) {
        super(imgURL);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
