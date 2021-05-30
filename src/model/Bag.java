package model;

import java.util.ArrayList;

public class Bag extends StoreObject{

    private double space;
    private ArrayList<Pokeball> pokeballs;
    private Pokedex trainnerPokedex;

    public Bag(double price) {
        super(price);
    }
}
