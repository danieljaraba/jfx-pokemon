package model.classes;

import model.abstractClasses.StoreObject;
import model.interfaces.Tradable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The type Bag.
 */
public class Bag extends StoreObject  implements Tradable , Serializable {

    private double space;
    private ArrayList<Pokeball> emptyPokeballs;
    private ArrayList<Pokeball> usedPokeballs;
    private Pokedex trainnerPokedex;

    /**
     * Instantiates a new Bag.
     *
     * @param name            the name
     * @param price           the price
     * @param space           the space
     * @param trainnerPokedex the trainner pokedex
     */
    public Bag(String name, double price,double space, Pokedex trainnerPokedex) {
        super(name,price);
        this.space = space;
        emptyPokeballs = new ArrayList<>();
        usedPokeballs = new ArrayList<>();
        this.trainnerPokedex = trainnerPokedex;
    }


    /**
     * Sort used pokeballs by pokemon name.
     */
    public void sortUsedPokeballsByPokemonName(){
        for(int i = 0; i < usedPokeballs.size(); i++){
            Pokeball min = usedPokeballs.get(i);
            for( int j = i+1; j < usedPokeballs.size(); j++){
                if(usedPokeballs.get(j).getPokemon().getName().compareToIgnoreCase(min.getPokemon().getName()) < 0){
                    Pokeball temp = usedPokeballs.get(j);
                    usedPokeballs.set(j,min);
                    min = temp;
                }
            }
            usedPokeballs.set(i,min);
        }
        //Comparator<Pokeball> pokemonOrderByName = (pokeballA, pokeballB) -> (pokeballA.getPokemon().getName().compareToIgnoreCase(pokeballB.getPokemon().getName()));
        //usedPokeballs.sort(pokemonOrderByName);
    }

    /**
     * Gets space.
     *
     * @return the space
     */
    public double getSpace() {
        return space;
    }

    /**
     * Sets space.
     *
     * @param space the space
     */
    public void setSpace(double space) {
        this.space = space;
    }

    /**
     * Gets empty pokeballs.
     *
     * @return the empty pokeballs
     */
    public ArrayList<Pokeball> getEmptyPokeballs() {
        return emptyPokeballs;
    }

    /**
     * Sets empty pokeballs.
     *
     * @param emptyPokeballs the empty pokeballs
     */
    public void setEmptyPokeballs(ArrayList<Pokeball> emptyPokeballs) {
        this.emptyPokeballs = emptyPokeballs;
    }

    /**
     * Gets used pokeballs.
     *
     * @return the used pokeballs
     */
    public ArrayList<Pokeball> getUsedPokeballs() {
        return usedPokeballs;
    }

    /**
     * Sets used pokeballs.
     *
     * @param usedPokeballs the used pokeballs
     */
    public void setUsedPokeballs(ArrayList<Pokeball> usedPokeballs) {
        this.usedPokeballs = usedPokeballs;
    }

    /**
     * Gets trainner pokedex.
     *
     * @return the trainner pokedex
     */
    public Pokedex getTrainnerPokedex() {
        return trainnerPokedex;
    }

    /**
     * Sets trainner pokedex.
     *
     * @param trainnerPokedex the trainner pokedex
     */
    public void setTrainnerPokedex(Pokedex trainnerPokedex) {
        this.trainnerPokedex = trainnerPokedex;
    }


}
