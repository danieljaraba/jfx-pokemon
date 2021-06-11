package model.classes;

import exception.IsSaledException;
import exception.NotTrabableException;
import model.abstractClasses.StoreObject;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

 public class StoreTest {
     private Store store;
     private Pokedex pokedex;
     private Pokeball pokeball;

     //que quiere comprar una pokeball que ya esta se vendío
     public void setUpScenary1(){
         pokeball = new Pokeball("master ball",11.9);
         store = new Store(pokeball);
         store.getStoreItems().setSaled(true);
     }

     //quiere comprar una pokebal que no está en la tienda
     public void setUpScenary2(){
         pokeball = new Pokeball("super ball",2011);
         store = new Store(pokeball);
     }


     //quiere comprar una podekex pero no se puede rey
     public void setUpScenary3(){
         pokeball = new Pokeball("normal ball",9);
         pokedex = new Pokedex("Initial one",5);
         store = new Store(pokeball);
         store.addStoreObject(pokedex);
     }

     @Test
     public void sellItemTest1(){
         setUpScenary1();
         String name = "master ball";
         double price = 11.9;
         StoreObject object;
         try {
           object =  store.sellItem(price,name);
           assertNull(object);
         } catch (IsSaledException e) {
             e.printStackTrace();
         }catch (NotTrabableException nte){
             fail();
         }

     }

     @Test
     public void sellItemTest2(){
         setUpScenary2();
         String name = "master ball";
         double price = 11.9;
         StoreObject object;
         try {
             object =  store.sellItem(price,name);
             assertNull(object);
         } catch (IsSaledException | NotTrabableException e) {
            fail();
         }


     }

     @Test
     public void sellItemTest3(){
         setUpScenary3();
         String name = "Initial one";
         double price = 5;
         StoreObject object;
         try {
             object =  store.sellItem(price,name);
             assertNull(object);
         } catch (IsSaledException e) {
             fail();
         }catch (NotTrabableException nte){
             nte.printStackTrace();
         }


     }








}