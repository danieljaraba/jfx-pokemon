package model.classes;

import model.abstractClasses.Pokemon;
import model.abstractClasses.World;

import java.util.ArrayList;

public class Village extends World {

    private String name;
    private PokemonTrainer player;
    private ArrayList<GameObject> gameObjects;
    private boolean isTouched;
    private double movement;
    private Pokemon [] localPokemons;

    public Village(double height, double width, int wildPokemons, String name, double movement,String nameCharacter,String imgURL,String nameColor) {
        super(height, width, wildPokemons);
        this.name = name;
        this.player = new PokemonTrainer(200, 200,nameCharacter,new Bag("",0.0,20.0,new Pokedex("",0.0)),imgURL,nameColor);
        this.gameObjects = new ArrayList<>();
        this.isTouched = false;
        this.movement = movement;
        localPokemons = new Pokemon[3];
    }



    public String getName() {
        return name;
    }

    public void addObject(double x1, double x2, double y1, double y2, boolean transferable, boolean pokemon){
        GameObject obj = new GameObject(x1, x2, y1, y2, transferable, 10, pokemon);
        gameObjects.add(obj);
    }

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


    public void setName(String name) {
        this.name = name;
    }

    public PokemonTrainer getPlayer() {
        return player;
    }

    public void setPlayer(PokemonTrainer player) {
        this.player = player;
    }

    public double getMovement() {
        return movement;
    }

    public void setMovement(double movement) {
        this.movement = movement;
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public boolean isTouched() {
        return isTouched;
    }

    public void setTouched(boolean touched) {
        isTouched = touched;
    }

    public Pokemon[] getLocalPokemons() {
        return localPokemons;
    }
}
