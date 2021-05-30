package model;

public class Pokeball extends StoreObject implements Tradable{

    private Pokemon pokemon;

    public Pokeball(double price) {
        super(price);
    }
}
