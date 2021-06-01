package model.classes;

import model.abstractClasses.Pokemon;

public class FirePokemon extends Pokemon {
    public FirePokemon(String img, String name, double exp, int level, double health, boolean hasOwner, String type, Attack[] pokemonAttacks) {
        super(img, name, exp, level, health, hasOwner, type, pokemonAttacks);
    }
}
