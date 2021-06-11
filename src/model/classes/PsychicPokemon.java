package model.classes;

import model.abstractClasses.Pokemon;

/**
 * The type Psychic pokemon.
 */
public class PsychicPokemon extends Pokemon {
    private boolean mindReader;

    /**
     * Instantiates a new Psychic pokemon.
     *
     * @param img            the img
     * @param name           the name
     * @param exp            the exp
     * @param level          the level
     * @param health         the health
     * @param baseDefense    the base defense
     * @param hasOwner       the has owner
     * @param type           the type
     * @param pokemonAttacks the pokemon attacks
     * @param mindReader     the mind reader
     */
    public PsychicPokemon(String img, String name, double exp, int level, double health, double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks, boolean mindReader) {
        super(img, name, exp, level, health,baseDefense , hasOwner, type, pokemonAttacks);
        this.mindReader = mindReader;
    }

    /**
     * Is mind reader boolean.
     *
     * @return the boolean
     */
    public boolean isMindReader() {
        return mindReader;
    }

    /**
     * Sets mind reader.
     *
     * @param mindReader the mind reader
     */
    public void setMindReader(boolean mindReader) {
        this.mindReader = mindReader;
    }

    @Override
    public String toString(){
        return super.toString()+";"+mindReader;
    }
}
