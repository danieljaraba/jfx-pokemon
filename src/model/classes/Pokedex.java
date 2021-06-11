package model.classes;

import model.abstractClasses.Pokemon;
import model.abstractClasses.StoreObject;

import java.util.ArrayList;

public class Pokedex extends StoreObject {

    private Pokemon[] pokemons;
    private ArrayList<Pokemon> currentPokemons;

    public Pokedex(String name,double price) {
        super(name,price);
        currentPokemons = new ArrayList<>();
        pokemons = new Pokemon[18];
    }

    //When see a new pokemon confirm if its already seen before
    public void addPokemonToSeenPokemons(String pokemonOriginalName){
        boolean found = false;
        for(Pokemon pokemon : currentPokemons){
            if(pokemon.getName().equals(pokemonOriginalName)){
                found = true;
            }
        }
        if(!found){
            for(Pokemon pokemon : pokemons){
                if(pokemon.getName().equals(pokemonOriginalName)){
                    currentPokemons.add(pokemon);
                }
            }
        }
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Pokemon> getCurrentPokemons() {
        return currentPokemons;
    }

    public void setCurrentPokemons(ArrayList<Pokemon> currentPokemons) {
        this.currentPokemons = currentPokemons;
    }
}
