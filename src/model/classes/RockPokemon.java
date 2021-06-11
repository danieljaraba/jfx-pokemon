package model.classes;

import model.abstractClasses.Pokemon;

/**
 * The type Rock pokemon.
 */
public class RockPokemon extends Pokemon {
    private int weight;

    /**
     * Instantiates a new Rock pokemon.
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
     * @param weight         the weight
     */
    public RockPokemon(String img, String name, double exp, int level, double health,double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks, int weight) {
        super(img, name, exp, level, health,baseDefense, hasOwner, type, pokemonAttacks);
        this.weight = weight;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return super.toString()+";"+weight;
    }
}
