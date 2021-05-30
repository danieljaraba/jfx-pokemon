package model.classes;

import model.abstractClasses.StoreObject;
import model.interfaces.Tradable;

public class Pokeball extends StoreObject implements Tradable {

    private Pokemon pokemon;

    public Pokeball(double price) {
        super(price);
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
