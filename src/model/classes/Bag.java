package model.classes;

import model.abstractClasses.StoreObject;
import model.interfaces.Tradable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Bag extends StoreObject  implements Tradable , Serializable {

    private double space;
    private ArrayList<Pokeball> emptyPokeballs;
    private ArrayList<Pokeball> usedPokeballs;
    private Pokedex trainnerPokedex;

    public Bag(String name, double price,double space, Pokedex trainnerPokedex) {
        super(name,price);
        this.space = space;
        emptyPokeballs = new ArrayList<>();
        usedPokeballs = new ArrayList<>();
        this.trainnerPokedex = trainnerPokedex;
    }

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

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    public ArrayList<Pokeball> getEmptyPokeballs() {
        return emptyPokeballs;
    }

    public void setEmptyPokeballs(ArrayList<Pokeball> emptyPokeballs) {
        this.emptyPokeballs = emptyPokeballs;
    }

    public ArrayList<Pokeball> getUsedPokeballs() {
        return usedPokeballs;
    }

    public void setUsedPokeballs(ArrayList<Pokeball> usedPokeballs) {
        this.usedPokeballs = usedPokeballs;
    }

    public Pokedex getTrainnerPokedex() {
        return trainnerPokedex;
    }

    public void setTrainnerPokedex(Pokedex trainnerPokedex) {
        this.trainnerPokedex = trainnerPokedex;
    }


}
