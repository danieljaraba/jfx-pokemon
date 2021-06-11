package model.classes;

import model.abstractClasses.Pokemon;

public class PokemonBattle {

    private Pokemon attacker;
    private Pokemon user;
    private PokemonTrainer trainer;
    private double atkHealth;
    private double defHealth;
    private double atkMana;
    private double defMana;

    public PokemonBattle(Pokemon attacker, Pokemon user, PokemonTrainer trainer){
        this.attacker = attacker;
        this.user = user;
        this.trainer = trainer;
        this.atkHealth = attacker.getHealth();
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

    public Pokemon getAttacker() {
        return attacker;
    }

    public void setAttacker(Pokemon attacker) {
        this.attacker = attacker;
    }

    public Pokemon getUser() {
        return user;
    }

    public void setUser(Pokemon user) {
        this.user = user;
    }

    public PokemonTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(PokemonTrainer trainer) {
        this.trainer = trainer;
    }

    public double getAtkHealth() {
        return atkHealth;
    }

    public void setAtkHealth(double atkHealth) {
        this.atkHealth = atkHealth;
    }

    public double getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(double defHealth) {
        this.defHealth = defHealth;
    }

    public double getAtkMana() {
        return atkMana;
    }

    public void setAtkMana(double atkMana) {
        this.atkMana = atkMana;
    }

    public double getDefMana() {
        return defMana;
    }

    public void setDefMana(double defMana) {
        this.defMana = defMana;
    }
}
