package model;

import java.util.ArrayList;

public class Pokedex extends StoreObject{

    private Pokemon[] pokemons;
    private ArrayList<Pokeball> currentPokemons;

    public Pokedex(double price) {
        super(price);
    }
}
