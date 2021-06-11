package model.classes;

import model.abstractClasses.Pokemon;
import model.abstractClasses.StoreObject;
import model.interfaces.Tradable;



public class Pokeball extends StoreObject implements Tradable{

    private Pokemon pokemon;

    public Pokeball(String name,double price) {
        super(name,price);
    }
    public Pokeball(String name, double price, Pokemon pokemon){
        super(name,price);
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
