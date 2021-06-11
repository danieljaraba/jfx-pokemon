package model.interfaces;

public interface Battle {
    boolean userAttack(int attack);
    boolean userHasEnoughMana(int amount);
    boolean atkHasEnoughMana(int amount);
    boolean userWins();
    boolean atkWins();
}
