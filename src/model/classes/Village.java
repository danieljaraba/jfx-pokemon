package model.classes;

import model.abstractClasses.Pokemon;
import model.abstractClasses.World;

import java.util.ArrayList;

/**
 * The type Village.
 */
public class Village extends World {

    private String name;
    private PokemonTrainer player;
    private ArrayList<GameObject> gameObjects;
    private boolean isTouched;
    private double movement;
    private Pokemon [] localPokemons;

    /**
     * Instantiates a new Village.
     *
     * @param height        the height
     * @param width         the width
     * @param wildPokemons  the wild pokemons
     * @param name          the name
     * @param movement      the movement
     * @param nameCharacter the name character
     * @param imgURL        the img url
     * @param nameColor     the name color
     */
    public Village(double height, double width, int wildPokemons, String name, double movement,String nameCharacter,String imgURL,String nameColor) {
        super(height, width, wildPokemons);
        this.name = name;
        this.player = new PokemonTrainer(50, 50,nameCharacter,new Bag("",0.0,20.0,new Pokedex("",0.0)),imgURL,nameColor);
        this.gameObjects = new ArrayList<>();
        this.isTouched = false;
        this.movement = movement;
        localPokemons = new Pokemon[3];
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
     * Add object.
     *
     * @param x1           the x 1
     * @param x2           the x 2
     * @param y1           the y 1
     * @param y2           the y 2
     * @param transferable the transferable
     * @param pokemon      the pokemon
     */
    public void addObject(double x1, double x2, double y1, double y2, boolean transferable, boolean pokemon){
        GameObject obj = new GameObject(x1, x2, y1, y2, transferable, 10, pokemon);
        gameObjects.add(obj);
    }

    /**
     * Move right string.
     *
     * @return the string
     */
    public String moveRight(){
        boolean touch = false;
        String action = "";
        for(int i = 0; i<gameObjects.size() && !touch; i++){
            touch = gameObjects.get(i).isNear(player.getX()+movement, player.getY());
            if(touch){
                if(gameObjects.get(i).isTransferable()){
                    action = gameObjects.get(i).executeOption();
                }
            }
        }

        if(!touch){
            player.setX(player.getX() + movement);
        }
        return action;
    }

    /**
     * Move up string.
     *
     * @return the string
     */
    public String moveUp(){
        boolean touch = false;
        String action = "";
        for(int i = 0; i<gameObjects.size() && !touch; i++){
            touch = gameObjects.get(i).isNear(player.getX(), player.getY()-movement);
            if(touch){
                if(gameObjects.get(i).isTransferable()){
                    action = gameObjects.get(i).executeOption();
                }
            }
        }

        if(!touch){
            player.setY(player.getY()-movement);
        }
        return action;
    }

    /**
     * Move down string.
     *
     * @return the string
     */
    public String moveDown(){
        boolean touch = false;
        String action = "";
        for(int i = 0; i<gameObjects.size() && !touch; i++){
            touch = gameObjects.get(i).isNear(player.getX(), player.getY()+movement);
            if(touch){
                if(gameObjects.get(i).isTransferable()){
                    action = gameObjects.get(i).executeOption();
                }
            }
        }

        if(!touch){
            player.setY(player.getY()+movement);
        }
        return action;
    }

    /**
     * Move left string.
     *
     * @return the string
     */
    public String moveLeft(){
        boolean touch = false;
        String action = "";
        for(int i = 0; i<gameObjects.size() && !touch; i++){
            touch = gameObjects.get(i).isNear(player.getX()-movement, player.getY());
            if(touch){
                if(gameObjects.get(i).isTransferable()){
                    action = gameObjects.get(i).executeOption();
                }
            }
        }

        if(!touch){
            player.setX(player.getX() - movement);
        }
        return action;
    }

    /**
     * Is in pokemon area boolean.
     *
     * @param currentTrainer the current trainer
     * @return the boolean
     */
    public Boolean isInPokemonArea(PokemonTrainer currentTrainer){
        boolean is = false;
        for (int i = 0; i <gameObjects.size() && !is ; i++) {
            if(gameObjects.get(i).isNear(currentTrainer.getX()+movement,currentTrainer.getY())&& gameObjects.get(i).isTransferable()){
                System.out.println("Pokemon area");
                is = true;
            }
        }

        return is;
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
     * Gets player.
     *
     * @return the player
     */
    public PokemonTrainer getPlayer() {
        return player;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(PokemonTrainer player) {
        this.player = player;
    }

    /**
     * Gets movement.
     *
     * @return the movement
     */
    public double getMovement() {
        return movement;
    }

    /**
     * Sets movement.
     *
     * @param movement the movement
     */
    public void setMovement(double movement) {
        this.movement = movement;
    }

    /**
     * Gets game objects.
     *
     * @return the game objects
     */
    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Sets game objects.
     *
     * @param gameObjects the game objects
     */
    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    /**
     * Is touched boolean.
     *
     * @return the boolean
     */
    public boolean isTouched() {
        return isTouched;
    }

    /**
     * Sets touched.
     *
     * @param touched the touched
     */
    public void setTouched(boolean touched) {
        isTouched = touched;
    }

    /**
     * Get local pokemons pokemon [ ].
     *
     * @return the pokemon [ ]
     */
    public Pokemon[] getLocalPokemons() {
        return localPokemons;
    }
}
