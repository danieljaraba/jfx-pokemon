package model.classes;

import model.abstractClasses.Pokemon;

/**
 * The type Plant pokemon.
 */
public class PlantPokemon extends Pokemon {
    private int flowers;

    /**
     * Instantiates a new Plant pokemon.
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
     * @param flowers        the flowers
     */
    public PlantPokemon(String img, String name, double exp, int level, double health, double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks, int flowers) {
        super(img, name, exp, level, health,baseDefense, hasOwner, type, pokemonAttacks);
        this.flowers = flowers;
    }

    /**
     * Gets flowers.
     *
     * @return the flowers
     */
    public int getFlowers() {
        return flowers;
    }

    /**
     * Sets flowers.
     *
     * @param flowers the flowers
     */
    public void setFlowers(int flowers) {
        this.flowers = flowers;
    }
    @Override
    public String toString(){
        return super.toString()+";"+flowers;
    }
}
