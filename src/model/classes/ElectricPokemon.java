package model.classes;

import model.abstractClasses.Pokemon;

/**
 * The type Electric pokemon.
 */
public class ElectricPokemon extends Pokemon {
    private double voltage;

    /**
     * Instantiates a new Electric pokemon.
     *
     * @param img            the img
     * @param name           the name
     * @param exp            the exp
     * @param level          the level
     * @param health         the health
     * @param baseDefense    the base defense
     * @param hasOwner       the has owner
     * @param type           the type
     * @param pokemonAttacks the pokemon attacks
     * @param voltage        the voltage
     */
    public ElectricPokemon(String img, String name, double exp, int level, double health,double baseDefense, boolean hasOwner, String type, Attack[] pokemonAttacks, double voltage) {
        super(img, name, exp, level, health,baseDefense, hasOwner, type, pokemonAttacks);
        this.voltage = voltage;
    }

    /**
     * Gets voltage.
     *
     * @return the voltage
     */
    public double getVoltage() {
        return voltage;
    }

    /**
     * Sets voltage.
     *
     * @param voltage the voltage
     */
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString(){
        return super.toString()+";"+voltage;
    }
}
