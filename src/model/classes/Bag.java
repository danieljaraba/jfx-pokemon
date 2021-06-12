package model.classes;

import model.abstractClasses.Pokemon;
import model.abstractClasses.StoreObject;
import model.interfaces.Tradable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Bag.
 */
public class Bag extends StoreObject  implements Tradable , Serializable {

    private double space;
    private ArrayList<Pokeball> emptyPokeballs;
    private ArrayList<Pokeball> usedPokeballs;
    private Pokedex trainnerPokedex;

    /**
     * Instantiates a new Bag.
     *
     * @param name            the name
     * @param price           the price
     * @param space           the space
     * @param trainnerPokedex the trainner pokedex
     */
    public Bag(String name, double price,double space, Pokedex trainnerPokedex) {
        super(name,price);
        this.space = space;
        emptyPokeballs = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            emptyPokeballs.add(new Pokeball("",0));
        }
        usedPokeballs = new ArrayList<>();
        this.trainnerPokedex = trainnerPokedex;
    }

    /**
     * Save captured pokemon boolean.
     *
     * @param pokemon the pokemon
     * @return the boolean
     */
    public boolean saveCapturedPokemon(Pokemon pokemon){
        if(!emptyPokeballs.isEmpty()){
            int canCapture = (int)(Math.random()*6);
            if(canCapture > 1){
                WaterPokemon pkm = new WaterPokemon(pokemon.getImg(), pokemon.getName(), pokemon.getExp(), pokemon.getLevel(), pokemon.getHealth(), pokemon.getBaseDefense(), pokemon.isHasOwner(), pokemon.getType(), pokemon.getPokemonAttacks(), true);
                Pokeball pokeball = emptyPokeballs.remove(emptyPokeballs.size()-1);
                pokeball.setPokemon(pkm);
                switch (pokeball.getPokemon().getName()){
                    case "Arcanine":
                        pokeball.getPokemon().setImg("img/pokemon/pokemon_back_sprites/Arcanine.png");
                    break;
                    case "Blastoide":
                        pokeball.getPokemon().setImg("img/pokemon/pokemon_back_sprites/Blastoise_back.png");
                    break;
                }
                usedPokeballs.add(pokeball);
                return true;
            }else{
                emptyPokeballs.remove(getEmptyPokeballs().size()-1);
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Sort used pokeballs by level.
     */
    public void sortUsedPokeballsByLevel(){
        ArrayList<Pokeball> copy = usedPokeballs;
        boolean changed = true;
        for(int i = 1; i < copy.size() && changed; i++){
            changed = false;
            for(int j = 0; j < copy.size() -i; j++){
                if(copy.get(j).getPokemon().getLevel() > copy.get(j+1).getPokemon().getLevel()){
                    changed = true;
                    Pokeball temp = copy.get(j);
                    copy.set(j, copy.remove(j+1));
                    copy.set(j+1, temp);
                }
            }
        }
    }

    /**
     * Sort used pokeballs by pokemon name.
     */
    public void sortUsedPokeballsByPokemonName(){
        for(int i = 0; i < usedPokeballs.size(); i++){
            Pokeball min = usedPokeballs.get(i);
            for( int j = i+1; j < usedPokeballs.size(); j++){
                if(usedPokeballs.get(j).getPokemon().getName().compareToIgnoreCase(min.getPokemon().getName()) < 0){
                    Pokeball temp = usedPokeballs.get(j);
                    usedPokeballs.set(j,min);
                    min = temp;
                }
            }
            usedPokeballs.set(i,min);
        }
        //Comparator<Pokeball> pokemonOrderByName = (pokeballA, pokeballB) -> (pokeballA.getPokemon().getName().compareToIgnoreCase(pokeballB.getPokemon().getName()));
        //usedPokeballs.sort(pokemonOrderByName);
    }

    /**
     * Sort used pokeball by base deffense.
     */
    public void sortUsedPokeballByBaseDeffense(){
        for(int i = 1; i < usedPokeballs.size(); i++){
            for(int j = i; j > 0 && usedPokeballs.get(j-1).getPokemon().getBaseDefense() > usedPokeballs.get(j).getPokemon().getBaseDefense(); j--){
                Pokeball temp = usedPokeballs.get(j);
                usedPokeballs.set(j, usedPokeballs.get(j-1));
                usedPokeballs.set(j-1,temp);
            }
        }
    }

    /**
     * Found pokemon by level pokeball.
     *
     * @param used  the used
     * @param level the level
     * @return the pokeball
     */
    public Pokeball foundPokemonByLevel(ArrayList<Pokeball> used, int level){
        Pokeball ret = null;
        int first = used.get(0).getPokemon().getLevel();
        int last = used.get(used.size()-1).getPokemon().getLevel();
        int mid = ( first + last)/2;
        while( first <= last ){
            if ( used.get(mid).getPokemon().getLevel() < level ){
                first = mid + 1;
            }else if ( used.get(mid).getPokemon().getLevel() == level ){
                //System.out.println("Element is found at index: " + mid);
                ret = used.get(mid);
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            return null;
        }else{
            return ret;
        }
    }

    /**
     * Found pokemon by health pokeball.
     *
     * @param used   the used
     * @param health the health
     * @return the pokeball
     */
    public Pokeball foundPokemonByHealth(ArrayList<Pokeball> used, int health){
        Pokeball ret = null;
        int first = (int)used.get(0).getPokemon().getHealth();
        int last = (int)used.get(used.size()-1).getPokemon().getHealth();
        int mid = ( first + last)/2;
        while( first <= last ){
            if ( used.get(mid).getPokemon().getLevel() < health){
                first = mid + 1;
            }else if ( used.get(mid).getPokemon().getHealth() == health){
                //System.out.println("Element is found at index: " + mid);
                ret = used.get(mid);
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            return null;
        }else{
            return ret;
        }
    }

    /**
     * Gets space.
     *
     * @return the space
     */
    public double getSpace() {
        return space;
    }

    /**
     * Sets space.
     *
     * @param space the space
     */
    public void setSpace(double space) {
        this.space = space;
    }

    /**
     * Gets empty pokeballs.
     *
     * @return the empty pokeballs
     */
    public ArrayList<Pokeball> getEmptyPokeballs() {
        return emptyPokeballs;
    }

    /**
     * Sets empty pokeballs.
     *
     * @param emptyPokeballs the empty pokeballs
     */
    public void setEmptyPokeballs(ArrayList<Pokeball> emptyPokeballs) {
        this.emptyPokeballs = emptyPokeballs;
    }

    /**
     * Gets used pokeballs.
     *
     * @return the used pokeballs
     */
    public ArrayList<Pokeball> getUsedPokeballs() {
        return usedPokeballs;
    }

    /**
     * Sets used pokeballs.
     *
     * @param usedPokeballs the used pokeballs
     */
    public void setUsedPokeballs(ArrayList<Pokeball> usedPokeballs) {
        this.usedPokeballs = usedPokeballs;
    }

    /**
     * Gets trainner pokedex.
     *
     * @return the trainner pokedex
     */
    public Pokedex getTrainnerPokedex() {
        return trainnerPokedex;
    }

    /**
     * Sets trainner pokedex.
     *
     * @param trainnerPokedex the trainner pokedex
     */
    public void setTrainnerPokedex(Pokedex trainnerPokedex) {
        this.trainnerPokedex = trainnerPokedex;
    }


}
