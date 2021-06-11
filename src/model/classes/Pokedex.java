package model.classes;

import model.abstractClasses.Pokemon;
import model.abstractClasses.StoreObject;

import java.util.ArrayList;

/**
 * The type Pokedex.
 */
public class Pokedex extends StoreObject {

    private Pokemon[] pokemons;
    private ArrayList<Pokemon> currentPokemons;

    /**
     * Instantiates a new Pokedex.
     *
     * @param name  the name
     * @param price the price
     */
    public Pokedex(String name,double price) {
        super(name,price);
        currentPokemons = new ArrayList<>();
        pokemons = new Pokemon[18];
    }

    /**
     * Add pokemon to seen pokemons.
     *
     * @param pokemonOriginalName the pokemon original name
     */
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

    /**
     * Get pokemons pokemon [ ].
     *
     * @return the pokemon [ ]
     */
    public Pokemon[] getPokemons() {
        return pokemons;
    }

    /**
     * Sets pokemons.
     *
     * @param pokemons the pokemons
     */
    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    /**
     * Gets current pokemons.
     *
     * @return the current pokemons
     */
    public ArrayList<Pokemon> getCurrentPokemons() {
        return currentPokemons;
    }

    /**
     * Sets current pokemons.
     *
     * @param currentPokemons the current pokemons
     */
    public void setCurrentPokemons(ArrayList<Pokemon> currentPokemons) {
        this.currentPokemons = currentPokemons;
    }
}
