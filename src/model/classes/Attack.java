package model.classes;

import java.io.Serializable;

/**
 * The type Attack.
 */
public class Attack implements Serializable {

    private String name;
    private double damage;
    private double defense;
    private int pp;

    /**
     * Instantiates a new Attack.
     *
     * @param name    the name
     * @param damage  the damage
     * @param defense the defense
     * @param pp      the pp
     */
    public Attack(String name, double damage, double defense, int pp) {
        this.name = name;
        this.damage = damage;
        this.defense = defense;
        this.pp = pp;
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
     * Gets damage.
     *
     * @return the damage
     */
    public double getDamage() {
        return damage;
    }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(double damage) {
        this.damage = damage;
    }

    /**
     * Gets defense.
     *
     * @return the defense
     */
    public double getDefense() {
        return defense;
    }

    /**
     * Sets defense.
     *
     * @param defense the defense
     */
    public void setDefense(double defense) {
        this.defense = defense;
    }

    /**
     * Gets pp.
     *
     * @return the pp
     */
    public int getPp() {
        return pp;
    }

    /**
     * Sets pp.
     *
     * @param pp the pp
     */
    public void setPp(int pp) {
        this.pp = pp;
    }
}
