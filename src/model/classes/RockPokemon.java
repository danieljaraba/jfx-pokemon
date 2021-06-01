package model.classes;

import model.abstractClasses.Pokemon;

public class RockPokemon extends Pokemon {
    private int weight;

    public RockPokemon(String img, String name, double exp, int level, double health, boolean hasOwner, String type, Attack[] pokemonAttacks, int weight) {
        super(img, name, exp, level, health, hasOwner, type, pokemonAttacks);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
