package model.classes;

import model.abstractClasses.Pokemon;

public class WaterPokemon extends Pokemon {
   private boolean feedable;
    public WaterPokemon(String img, String name, double exp, int level, double health, boolean hasOwner, String type, Attack[] pokemonAttacks,boolean feedable) {
        super(img, name, exp, level, health, hasOwner, type, pokemonAttacks);
        this.feedable = feedable;
    }

    public boolean isFeedable() {
        return feedable;
    }

    public void setFeedable(boolean feedable) {
        this.feedable = feedable;
    }
}
