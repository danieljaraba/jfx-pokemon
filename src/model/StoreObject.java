package model;

public abstract class StoreObject {

    private double price;
    private boolean saled;

    public StoreObject(double price){
        this.price = price;
        this.saled = false;
    }
}
