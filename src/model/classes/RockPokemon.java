package model.classes;

import model.abstractClasses.Pokemon;

public class RockPokemon extends Pokemon {
    private int weight;

    public RockPokemon(String img, String name, double exp, int level, double health,double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks, int weight) {
        super(img, name, exp, level, health,baseDefense, hasOwner, type, pokemonAttacks);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return super.toString()+";"+weight;
    }
}
