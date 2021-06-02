package model.classes;

import model.abstractClasses.World;

import java.util.ArrayList;

public class Village extends World {

    private String name;
    private PokemonTrainer player;
    private ArrayList<GameObject> gameObjects;
    private boolean isTouched;
    private double movement;

    public Village(double height, double width, int wildPokemons, String name, double movement) {
        super(height, width, wildPokemons);
        this.name = name;
        this.player = new PokemonTrainer(50, 50,"pedro",null,"img/character/emerald_down_rest.png" );
        this.gameObjects = new ArrayList<>();
        this.isTouched = false;
        this.movement = movement;
    }

    public String getName() {
        return name;
    }

    public void addObject(double x1, double x2, double y1, double y2, boolean transferable){
        GameObject obj = new GameObject(x1, x2, y1, y2, transferable, 10);
        gameObjects.add(obj);
    }

    public void moveRight(){
        boolean touch = false;
        for(int i = 0; i<gameObjects.size() && !touch; i++){
            touch = gameObjects.get(i).isNear(player.getX()+movement, player.getY());
        }

        if(!touch){
            player.setX(player.getX() + movement);
        }
    }

    public void moveUp(){
        boolean touch = false;
        for(int i = 0; i<gameObjects.size() && !touch; i++){
            touch = gameObjects.get(i).isNear(player.getX(), player.getY()-movement);
        }

        if(!touch){
            player.setY(player.getY()-movement);
        }
    }

    public void moveDown(){
        boolean touch = false;
        for(int i = 0; i<gameObjects.size() && !touch; i++){
            touch = gameObjects.get(i).isNear(player.getX(), player.getY()+movement);
        }

        if(!touch){
            player.setY(player.getY()+movement);
        }
    }

    public void moveLeft(){
        boolean touch = false;
        for(int i = 0; i<gameObjects.size() && !touch; i++){
            touch = gameObjects.get(i).isNear(player.getX()-movement, player.getY());
        }

        if(!touch){
            player.setX(player.getX() - movement);
        }
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
}
