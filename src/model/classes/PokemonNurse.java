package model.classes;

import model.abstractClasses.GameCharacter;

public class PokemonNurse extends GameCharacter {

    private String name;

    public PokemonNurse(String imgURL, String name) {
        super(imgURL);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
