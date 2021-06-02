package model.classes;

import model.abstractClasses.Pokemon;
import model.abstractClasses.StoreObject;

import java.util.ArrayList;

public class Pokedex extends StoreObject {

    private Pokemon[] pokemons;
    private ArrayList<Pokeball> currentPokemons;

    public Pokedex(String name,double price) {
        super(name,price);
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Pokeball> getCurrentPokemons() {
        return currentPokemons;
    }

    public void setCurrentPokemons(ArrayList<Pokeball> currentPokemons) {
        this.currentPokemons = currentPokemons;
    }
}
