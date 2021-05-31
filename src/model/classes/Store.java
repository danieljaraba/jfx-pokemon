package model.classes;

import model.abstractClasses.StoreObject;

import java.util.ArrayList;

public class Store {

    private ArrayList<StoreObject> storeItems;

    public Store(ArrayList<StoreObject> storeItems) {
        this.storeItems = storeItems;
    }

    public ArrayList<StoreObject> getStoreItems() {
        return storeItems;
    }

    public void setStoreItems(ArrayList<StoreObject> storeItems) {
        this.storeItems = storeItems;
    }
}
