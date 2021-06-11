package model.classes;

import model.abstractClasses.Pokemon;

/**
 * The type Fire pokemon.
 */
public class FirePokemon extends Pokemon {
    /**
     * Instantiates a new Fire pokemon.
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
     */
    public FirePokemon(String img, String name, double exp, int level, double health,double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks) {
        super(img, name, exp, level, health,baseDefense, hasOwner, type, pokemonAttacks);
    }
}
