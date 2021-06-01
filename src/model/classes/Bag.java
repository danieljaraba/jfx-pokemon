package model.classes;

import model.abstractClasses.StoreObject;

import java.util.ArrayList;

public class Bag extends StoreObject {

    private double space;
    private ArrayList<Pokeball> pokeballs;
    private Pokedex trainnerPokedex;

    public Bag(double price,double space, Pokedex trainnerPokedex) {
        super(price);
        this.space = space;
        pokeballs = new ArrayList<>();
        this.trainnerPokedex = trainnerPokedex;
    }

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    public ArrayList<Pokeball> getPokeballs() {
        return pokeballs;
    }

    public void setPokeballs(ArrayList<Pokeball> pokeballs) {
        this.pokeballs = pokeballs;
    }

    public Pokedex getTrainnerPokedex() {
        return trainnerPokedex;
    }

    public void setTrainnerPokedex(Pokedex trainnerPokedex) {
        this.trainnerPokedex = trainnerPokedex;
    }
}
