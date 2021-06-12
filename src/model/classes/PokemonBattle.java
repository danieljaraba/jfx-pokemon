package model.classes;

import model.abstractClasses.Pokemon;
import model.interfaces.Battle;

import java.io.Serializable;

/**
 * The type Pokemon battle.
 */
public class PokemonBattle implements Battle , Serializable {

    private Pokemon attacker;
    private Pokemon user;
    private PokemonTrainer trainer;
    private double atkHealth;
    private double defHealth;
    private double atkMana;
    private double defMana;

    /**
     * Instantiates a new Pokemon battle.
     *
     * @param attacker the attacker
     * @param user     the user
     * @param trainer  the trainer
     */
    public PokemonBattle(Pokemon attacker, Pokemon user, PokemonTrainer trainer){
        this.attacker = attacker;
        this.user = user;
        this.trainer = trainer;
        this.atkHealth = attacker.getHealth();
        this.defHealth = user.getHealth();
        this.atkMana = 100;
        this.defMana = 100;
    }

    /**
     * Instantiates a new Pokemon battle.
     *
     * @param attacker the attacker
     * @param user     the user
     */
    public PokemonBattle(Pokemon attacker, Pokemon user) {
        this.attacker = attacker;
        this.user = user;
        this.atkHealth = attacker.getHealth();
        this.defHealth = user.getHealth();
        this.atkMana = 100;
        this.defMana = 100;
    }

    public PokemonBattle(Pokemon user , PokemonTrainer attackerTrainner){
        attacker = attackerTrainner.getRamdomPokemon();
        this.user = user;

        this.defHealth = user.getHealth();
        this.atkMana = 100;
        this.defMana = 100;
    }

    public boolean userAttack(int attack){
        boolean win = false;
        switch(attack){
            case 1:
                if(userHasEnoughMana(10)){
                    defMana -= user.getPokemonAttacks()[0].getPp();
                    atkHealth -= user.getPokemonAttacks()[0].getDamage();
                    if(userWins()){
                        win = true;
                    }
                }
                break;
            case 2:
                if(userHasEnoughMana(20)){
                    defMana -= user.getPokemonAttacks()[1].getPp();
                    atkHealth -= user.getPokemonAttacks()[1].getDamage();
                    if(userWins()){
                        win = true;
                    }
                }
                break;
            case 3:
                if(userHasEnoughMana(0)){
                    defMana += user.getPokemonAttacks()[2].getPp();
                    if(userWins()){
                        win = true;
                    }
                }
                break;
            case 4:
                if(userHasEnoughMana(40)){
                    defMana -= user.getPokemonAttacks()[3].getPp();
                    atkHealth -= user.getPokemonAttacks()[3].getDamage();
                    if(userWins()){
                        win = true;
                    }
                }
                break;
        }
        return win;
    }

    /**
     * Atk attack boolean.
     *
     * @param attack the attack
     * @return the boolean
     */
    public boolean atkAttack(int attack){
        boolean win = false;
        switch(attack){
            case 1:
                if(atkHasEnoughMana(10)){
                    atkMana -= attacker.getPokemonAttacks()[0].getPp();
                    defHealth -= attacker.getPokemonAttacks()[0].getDamage();
                    if(atkWins()){
                        win = true;
                    }
                }
                break;
            case 2:
                if(atkHasEnoughMana(20)){
                    atkMana -= user.getPokemonAttacks()[1].getPp();
                    defHealth -= user.getPokemonAttacks()[1].getDamage();
                    if(atkWins()){
                        win = true;
                    }
                }
                break;
            case 3:
                if(atkHasEnoughMana(0)){
                    atkMana += user.getPokemonAttacks()[2].getPp();
                    if(atkWins()){
                        win = true;
                    }
                }
                break;
            case 4:
                if(atkHasEnoughMana(40)){
                    atkMana -= user.getPokemonAttacks()[3].getPp();
                    defHealth -= user.getPokemonAttacks()[3].getDamage();
                    if(atkWins()){
                        win = true;
                    }
                }
                break;
        }
        return win;
    }

    public boolean userHasEnoughMana(int amount){
        if(defMana > amount){
            return true;
        }else{
            return false;
        }
    }

    public boolean atkHasEnoughMana(int amount){
        if(atkMana > amount){
            return true;
        }else{
            return false;
        }
    }

    public boolean userWins(){
        if(atkHealth <= 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean atkWins(){
        if(defHealth <= 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Gets attacker.
     *
     * @return the attacker
     */
    public Pokemon getAttacker() {
        return attacker;
    }

    /**
     * Sets attacker.
     *
     * @param attacker the attacker
     */
    public void setAttacker(Pokemon attacker) {
        this.attacker = attacker;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public Pokemon getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(Pokemon user) {
        this.user = user;
    }

    /**
     * Gets trainer.
     *
     * @return the trainer
     */
    public PokemonTrainer getTrainer() {
        return trainer;
    }

    /**
     * Sets trainer.
     *
     * @param trainer the trainer
     */
    public void setTrainer(PokemonTrainer trainer) {
        this.trainer = trainer;
    }

    /**
     * Gets atk health.
     *
     * @return the atk health
     */
    public double getAtkHealth() {
        return atkHealth;
    }

    /**
     * Sets atk health.
     *
     * @param atkHealth the atk health
     */
    public void setAtkHealth(double atkHealth) {
        this.atkHealth = atkHealth;
    }

    /**
     * Gets def health.
     *
     * @return the def health
     */
    public double getDefHealth() {
        return defHealth;
    }

    /**
     * Sets def health.
     *
     * @param defHealth the def health
     */
    public void setDefHealth(double defHealth) {
        this.defHealth = defHealth;
    }

    /**
     * Gets atk mana.
     *
     * @return the atk mana
     */
    public double getAtkMana() {
        return atkMana;
    }

    /**
     * Sets atk mana.
     *
     * @param atkMana the atk mana
     */
    public void setAtkMana(double atkMana) {
        this.atkMana = atkMana;
    }

    /**
     * Gets def mana.
     *
     * @return the def mana
     */
    public double getDefMana() {
        return defMana;
    }

    /**
     * Sets def mana.
     *
     * @param defMana the def mana
     */
    public void setDefMana(double defMana) {
        this.defMana = defMana;
    }
}
