package model.classes;

import model.abstractClasses.Pokemon;

public class FirePokemon extends Pokemon {
    public FirePokemon(String img, String name, double exp, int level, double health,double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks) {
        super(img, name, exp, level, health,baseDefense, hasOwner, type, pokemonAttacks);
    }
}
