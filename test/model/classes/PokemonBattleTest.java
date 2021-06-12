package model.classes;

import model.interfaces.Battle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonBattleTest {

    private PokemonBattle battle;

    private void setupScenary1(){
        Attack[] attacks = new Attack[4];
        attacks[0] = new Attack("Primary", 20, 0, 20);
        attacks[1] = new Attack("Secondary", 20, 0, 20);
        attacks[2] = new Attack("Terciary", 20, 0, 20);
        attacks[3] = new Attack("Ultimate", 20, 0, 20);
        FirePokemon pkm1 = new FirePokemon("", "Arcanine", 0, 1, 100, 1, false, "Fire", attacks);
        FirePokemon pkm2 = new FirePokemon("", "Charmander", 0, 1, 100, 1, false, "Fire", attacks);
        this.battle = new PokemonBattle(pkm1, pkm2);
    }

    @Test
    void userAttack() {
        setupScenary1();
        battle.userAttack(1);
        assertEquals(80, battle.getAtkHealth());
    }

    @Test
    void atkAttack() {
        setupScenary1();
        battle.atkAttack(1);
        assertEquals(80, battle.getDefHealth());
    }

    @Test
    void userHasEnoughMana() {
        setupScenary1();
        battle.userAttack(1);
        assertEquals(true, battle.userHasEnoughMana(20));
    }

    @Test
    void atkHasEnoughMana() {
        setupScenary1();
        battle.atkAttack(1);
        assertEquals(true, battle.atkHasEnoughMana(20));
    }

    @Test
    void userWins() {
        setupScenary1();
        battle.userAttack(1);
        battle.userAttack(1);
        battle.userAttack(1);
        battle.userAttack(1);
        battle.userAttack(1);
        assertEquals(true, battle.userWins());
    }

    @Test
    void atkWins() {
        setupScenary1();
        battle.atkAttack(1);
        battle.atkAttack(1);
        battle.atkAttack(1);
        battle.atkAttack(1);
        battle.atkAttack(1);
        assertEquals(true, battle.atkWins());
    }
}