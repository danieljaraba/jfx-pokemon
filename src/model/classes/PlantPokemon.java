package model.classes;

import model.abstractClasses.Pokemon;

public class PlantPokemon extends Pokemon {
    private int flowers;
    public PlantPokemon(String img, String name, double exp, int level, double health, double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks, int flowers) {
        super(img, name, exp, level, health,baseDefense, hasOwner, type, pokemonAttacks);
        this.flowers = flowers;
    }

    public int getFlowers() {
        return flowers;
    }

    public void setFlowers(int flowers) {
        this.flowers = flowers;
    }
    @Override
    public String toString(){
        return super.toString()+";"+flowers;
    }
}
