package model.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VillageTest {

    private Village village;
    PokemonTrainer player;

    public void setupScenary1(){
        player = new PokemonTrainer(50,50,"Pedro",
                new Bag("",0,20,
                        new Pokedex("", 0)), "","");
        village = new Village(150, 150,18, "Village 1", 2, player.getName(), player.getImg(), player.getNameColor());
    }

    @org.junit.jupiter.api.Test
    void moveRight() {
        setupScenary1();
        double xAxisPosition = player.getX();
        village.moveRight();
        assertTrue(village.getPlayer().getX() > xAxisPosition);
    }

    @org.junit.jupiter.api.Test
    void moveUp() {
        setupScenary1();
        double yAxisPosition = player.getY();
        village.moveUp();
        assertTrue(village.getPlayer().getY() < yAxisPosition);
    }

    @org.junit.jupiter.api.Test
    void moveDown() {
        setupScenary1();
        double yAxisPosition = player.getY();
        village.moveDown();
        assertTrue(village.getPlayer().getY() > yAxisPosition);
    }

    @org.junit.jupiter.api.Test
    void moveLeft() {
        setupScenary1();
        double xAxisPosition = player.getX();
        village.moveLeft();
        assertTrue(village.getPlayer().getX() < xAxisPosition);
    }

    @Test
    void addObject() {
        double x1 = 10;
        double x2 = 20;
        double y1 = 10;
        double y2 = 20;
        int initialSize = village.getGameObjects().size();

        village.addObject(x1,x2,y1,y2, false, false);

        int finalSize = village.getGameObjects().size();
        assertTrue(finalSize > initialSize);
    }

    @Test
    void isInPokemonArea() {

    }
}