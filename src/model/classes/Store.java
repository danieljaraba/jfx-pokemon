package model.classes;

import model.abstractClasses.StoreObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Store.
 */
public class Store implements Serializable {

    private ArrayList<StoreObject> storeItems;

    /**
     * Instantiates a new Store.
     *
     * @param storeItems the store items
     */
    public Store(ArrayList<StoreObject> storeItems) {
        this.storeItems = storeItems;
    }

    /**
     * Sell item store object.
     *
     * @param money the money
     * @param name  the name
     * @return the store object
     */
//Connect with gui (Dialog pane)
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

    /**
     * Gets store items.
     *
     * @return the store items
     */
    public ArrayList<StoreObject> getStoreItems() {
        return storeItems;
    }

    /**
     * Sets store items.
     *
     * @param storeItems the store items
     */
    public void setStoreItems(ArrayList<StoreObject> storeItems) {
        this.storeItems = storeItems;
    }
}
