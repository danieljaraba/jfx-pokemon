package model.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameObjectTest {

    public GameObject object;

    public void setupScenary1(){
        this.object = new GameObject(40,50,10,20,false,10,false);
    }

    @Test
    public void isNear() {
        setupScenary1();
        boolean test = object.isNear(45,15);
        assertTrue(test);
    }

    @Test
    public void executeOption() {
        setupScenary1();
        String str = object.executeOption();
        assertEquals("Method", str);
    }

}