package model.classes;

public class Attack {

    private String name;
    private double damage;
    private double defense;
    private int pp;

    public Attack(String name, double damage, double defense, int pp) {
        this.name = name;
        this.damage = damage;
        this.defense = defense;
        this.pp = pp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
