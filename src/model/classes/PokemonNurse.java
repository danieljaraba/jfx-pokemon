package model.classes;

import model.abstractClasses.GameCharacter;

/**
 * The type Pokemon nurse.
 */
public class PokemonNurse extends GameCharacter {

    private String name;

    /**
     * Instantiates a new Pokemon nurse.
     *
     * @param imgURL the img url
     * @param name   the name
     */
    public PokemonNurse(String imgURL, String name) {
        super(imgURL);
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
