package model.classes;

import model.abstractClasses.GameCharacter;
import model.abstractClasses.Pokemon;
import model.interfaces.Autoplaying;

import java.util.ArrayList;

/**
 * The type Pokemon trainer.
 */
public class PokemonTrainer extends GameCharacter {

    private double x;
    private double y;
    private String name;
    private String nameColor;
    private ArrayList<String> gymMedals;
    private int coins;
    private Bag trainersBag;
    private PokemonTrainer parentTrainer;
    private PokemonTrainer leftTrainer;
    private PokemonTrainer rigthTrainer;
    private boolean clashWon;

    /**
     * Instantiates a new Pokemon trainer.
     *
     * @param x           the x
     * @param y           the y
     * @param name        the name
     * @param trainersBag the trainers bag
     * @param imgURL      the img url
     * @param nameColor   the name color
     */
    public PokemonTrainer(double x, double y, String name, Bag trainersBag, String imgURL, String nameColor) {
        super(imgURL);
        this.x = x;
        this.y = y;
        this.name = name;
        this.nameColor = nameColor;
        this.gymMedals = new ArrayList<>();
        this.coins = 5;
        this.trainersBag = trainersBag;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets gym medals.
     *
     * @return the gym medals
     */
    public ArrayList<String> getGymMedals() {
        return gymMedals;
    }

    /**
     * Sets gym medals.
     *
     * @param gymMedals the gym medals
     */
    public void setGymMedals(ArrayList<String> gymMedals) {
        this.gymMedals = gymMedals;
    }

    /**
     * Gets coins.
     *
     * @return the coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Sets coins.
     *
     * @param coins the coins
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * Gets trainers bag.
     *
     * @return the trainers bag
     */
    public Bag getTrainersBag() {
        return trainersBag;
    }

    /**
     * Sets trainers bag.
     *
     * @param trainersBag the trainers bag
     */
    public void setTrainersBag(Bag trainersBag) {
        this.trainersBag = trainersBag;
    }

    /**
     * Gets name color.
     *
     * @return the name color
     */
    public String getNameColor() {
        return nameColor;
    }

    public Pokemon getRamdomPokemon(){
        int ramdom = (int)(Math.random()*(trainersBag.getUsedPokeballs().size()))+1;
        return trainersBag.getUsedPokeballs().get(ramdom-1).getPokemon();
    }

    public boolean isClashWon() {
        return clashWon;
    }

    public void setClashWon(boolean clashWon) {
        this.clashWon = clashWon;
    }

    /**
     * Sets name color.
     *
     * @param nameColor the name color
     */
    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }

    public PokemonTrainer getParentTrainer() {
        return parentTrainer;
    }

    public void setParentTrainer(PokemonTrainer parentTrainer) {
        this.parentTrainer = parentTrainer;
    }

    public PokemonTrainer getLeftTrainer() {
        return leftTrainer;
    }

    public void setLeftTrainer(PokemonTrainer leftTrainer) {
        this.leftTrainer = leftTrainer;
    }

    public PokemonTrainer getRigthTrainer() {
        return rigthTrainer;
    }

    public void setRigthTrainer(PokemonTrainer rigthTrainer) {
        this.rigthTrainer = rigthTrainer;
    }
}
