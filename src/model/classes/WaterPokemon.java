package model.classes;

import model.abstractClasses.Pokemon;

/**
 * The type Water pokemon.
 */
public class WaterPokemon extends Pokemon {
   private boolean feedable;

    /**
     * Instantiates a new Water pokemon.
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
     * @param feedable       the feedable
     */
    public WaterPokemon(String img, String name, double exp, int level, double health, double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks,boolean feedable) {
        super(img, name, exp, level, health, baseDefense, hasOwner, type, pokemonAttacks);
        this.feedable = feedable;
    }

    /**
     * Is feedable boolean.
     *
     * @return the boolean
     */
    public boolean isFeedable() {
        return feedable;
    }

    /**
     * Sets feedable.
     *
     * @param feedable the feedable
     */
    public void setFeedable(boolean feedable) {
        this.feedable = feedable;
    }

    @Override
    public String toString(){
        return super.toString()+";"+feedable;
    }
}
