package model.classes;

import model.abstractClasses.Pokemon;

public class PsiquicPokemon extends Pokemon {
    private boolean mindReader;

    public PsiquicPokemon(String img, String name, double exp, int level, double health,double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks, boolean mindReader) {
        super(img, name, exp, level, health,baseDefense , hasOwner, type, pokemonAttacks);
        this.mindReader = mindReader;
    }

    public boolean isMindReader() {
        return mindReader;
    }

    public void setMindReader(boolean mindReader) {
        this.mindReader = mindReader;
    }

    @Override
    public String toString(){
        return super.toString()+";"+mindReader;
    }
}
