package model.classes;

import model.abstractClasses.Pokemon;
import model.abstractClasses.StoreObject;
import model.interfaces.Tradable;


/**
 * The type Pokeball.
 */
public class Pokeball extends StoreObject implements Tradable{

    private Pokemon pokemon;

    /**
     * Instantiates a new Pokeball.
     *
     * @param name  the name
     * @param price the price
     */
    public Pokeball(String name,double price) {
        super(name,price);
    }

    /**
     * Instantiates a new Pokeball.
     *
     * @param name    the name
     * @param price   the price
     * @param pokemon the pokemon
     */
    public Pokeball(String name, double price, Pokemon pokemon){
        super(name,price);
        this.pokemon = pokemon;
    }

    /**
     * Gets pokemon.
     *
     * @return the pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * Sets pokemon.
     *
     * @param pokemon the pokemon
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
