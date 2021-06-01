package model.abstractClasses;

import model.classes.Attack;
import model.interfaces.Autoplaying;
import model.interfaces.Battle;

public abstract class Pokemon implements Battle, Autoplaying {

    private String img;
    private String name;
    private double exp;
    private int level;
    private double health;
    private boolean hasOwner;
    private String type;
    private Attack[] pokemonAttacks;

    public Pokemon(String img, String name, double exp, int level, double health, boolean hasOwner, String type, Attack[] pokemonAttacks) {
        this.img = img;
        this.name = name;
        this.exp = exp;
        this.level = level;
        this.health = health;
        this.hasOwner = hasOwner;
        this.type = type;
        this.pokemonAttacks = pokemonAttacks;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attack[] getPokemonAttacks() {
        return pokemonAttacks;
    }

    public void setPokemonAttacks(Attack[] pokemonAttacks) {
        this.pokemonAttacks = pokemonAttacks;
    }
}
