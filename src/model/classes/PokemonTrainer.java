package model.classes;

import model.abstractClasses.GameCharacter;
import java.util.ArrayList;

public class PokemonTrainer extends GameCharacter {

    private double x;
    private double y;
    private String name;
    private ArrayList<String> gymMedals;
    private int coins;
    private Bag trainersBag;

    public PokemonTrainer(double x, double y, String name, Bag trainersBag, String imgURL) {
        super(imgURL);
        this.x = x;
        this.y = y;
        this.name = name;
        this.gymMedals = new ArrayList<>();
        this.coins = 5;
        this.trainersBag = trainersBag;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getGymMedals() {
        return gymMedals;
    }

    public void setGymMedals(ArrayList<String> gymMedals) {
        this.gymMedals = gymMedals;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Bag getTrainersBag() {
        return trainersBag;
    }

    public void setTrainersBag(Bag trainersBag) {
        this.trainersBag = trainersBag;
    }

}
