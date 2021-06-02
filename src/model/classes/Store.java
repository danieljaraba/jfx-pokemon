package model.classes;

import model.abstractClasses.StoreObject;

import java.util.ArrayList;

public class Store {

    private ArrayList<StoreObject> storeItems;

    public Store(ArrayList<StoreObject> storeItems) {
        this.storeItems = storeItems;
    }

    public StoreObject sellItem(int money, String name){
        StoreObject ret = null;
        for(StoreObject storeObject : storeItems){
            if ((storeObject.getName().equals(name)) && (money >= storeObject.getPrice())) {
                ret = storeObject;
                break;
            }
        }
        return ret;
    }

    public ArrayList<StoreObject> getStoreItems() {
        return storeItems;
    }

    public void setStoreItems(ArrayList<StoreObject> storeItems) {
        this.storeItems = storeItems;
    }
}
