package model.classes;

import model.abstractClasses.Pokemon;

public class ElectricPokemon extends Pokemon {
    private double voltage;

    public ElectricPokemon(String img, String name, double exp, int level, double health, boolean hasOwner, String type, Attack[] pokemonAttacks, double voltage) {
        super(img, name, exp, level, health, hasOwner, type, pokemonAttacks);
        this.voltage = voltage;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }
}
