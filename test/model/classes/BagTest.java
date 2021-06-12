package model.classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;


import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    private Bag bag;

    public void setupScenary1(){
        double space = 10;
        ArrayList<Pokeball> emptyPokeballs = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            emptyPokeballs.add(new Pokeball("",0));
        }
        ArrayList<Pokeball> usedPokeballs = new ArrayList<>();
        Pokedex trainnerPokedex = new Pokedex("",0);
        bag = new Bag("",0,space, trainnerPokedex);

        bag.setEmptyPokeballs(emptyPokeballs);
        bag.setUsedPokeballs(usedPokeballs);

    }
    public void setupScenary2(){
        double space = 10;
        ArrayList<Pokeball> emptyPokeballs = new ArrayList<>();

        ArrayList<Pokeball> usedPokeballs = new ArrayList<>();

        usedPokeballs.add(new Pokeball("",0,
                new WaterPokemon("","Squirtle",100,2,100,20,false,"Water",null, true)));

        usedPokeballs.add(new Pokeball("",0,
                new WaterPokemon("","WaterPokemon",100,1,100,20,false,"Water",null, true)));

        usedPokeballs.add(new Pokeball("",0,
                new WaterPokemon("","Blastoide",100,1,100,20,false,"Water",null, true)));

        Pokedex trainnerPokedex = new Pokedex("",0);
        bag = new Bag("",0,space, trainnerPokedex);

        bag.setEmptyPokeballs(emptyPokeballs);
        bag.setUsedPokeballs(usedPokeballs);

    }

    @Test
    void sortUsedPokeballsByPokemonName() {
        setupScenary2();
        ArrayList<Pokeball> copy = bag.getUsedPokeballs();
        Comparator<Pokeball> automaticOrder = (pokeballA, pokeballB) -> (pokeballA.getPokemon().getName().compareToIgnoreCase(pokeballB.getName()));
        copy.sort(automaticOrder);

        bag.sortUsedPokeballsByPokemonName();

        int differences = 0;
        for(int i = 0; i < copy.size(); i++){
            if(!copy.get(i).getPokemon().getName().equals(bag.getUsedPokeballs().get(i).getPokemon().getName())){
                differences++;
            }
        }
        boolean ans = true;
        if(differences > 0){
            ans = false;
        }
        assertTrue(ans);
    }

    @Test
    void saveCapturedPokemon() {
        setupScenary1();
        FirePokemon pokemon = new FirePokemon("","Charmander",100,1,60,20,false,"Fire",null);
        int initialSizeUsed = bag.getUsedPokeballs().size();
        int initialSizeEmpty = bag.getEmptyPokeballs().size();
        boolean test = bag.saveCapturedPokemon(pokemon);
        int finalSizeUsed = bag.getUsedPokeballs().size();
        int finalSizeEmpty = bag.getEmptyPokeballs().size();
        if(initialSizeUsed < finalSizeUsed){
            assertTrue(test);
        }else if(initialSizeEmpty > finalSizeEmpty && initialSizeUsed==finalSizeUsed){
            assertFalse(test);
        }
    }

    @Test
    void sortUsedPokeballsByLevel() {
        setupScenary2();
        bag.sortUsedPokeballsByLevel();
        int bad = 0;
        for(int i = 1; i < bag.getUsedPokeballs().size(); i++){
            if(bag.getUsedPokeballs().get(i-1).getPokemon().getLevel() > bag.getUsedPokeballs().get(i).getPokemon().getLevel()){
                bad++;
            }
        }
        boolean ret = (bad==0);
        assertTrue(ret);
    }

    @Test
    void sortUsedPokeballByBaseDeffense() {
        setupScenary2();
        bag.sortUsedPokeballByBaseDeffense();
        int bad = 0;
        for(int i = 1; i < bag.getUsedPokeballs().size(); i++){
            if(bag.getUsedPokeballs().get(i-1).getPokemon().getLevel() > bag.getUsedPokeballs().get(i).getPokemon().getLevel()){
                bad++;
            }
        }
        boolean ret = (bad==0);
        assertTrue(ret);
    }

    @Test
    void foundPokemonByLevel() {
    }

    @Test
    void foundPokemonByHealth() {
    }
}