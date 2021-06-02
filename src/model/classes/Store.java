package model.classes;

import model.abstractClasses.StoreObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {

    private ArrayList<StoreObject> storeItems;

    public Store(ArrayList<StoreObject> storeItems) {
        this.storeItems = storeItems;
    }

    public boolean sellItem(int money, String name){
        boolean ret = false;
        for(StoreObject storeObject : storeItems){
            if ((storeObject.getName().equals(name)) && (money >= storeObject.getPrice())) {
                ret = true;
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
