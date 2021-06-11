package model.classes;

import model.abstractClasses.StoreObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {

   // private ArrayList<StoreObject> storeItems;
    private StoreObject storeItems;

    public Store(StoreObject storeItems) {
        this.storeItems = storeItems;
    }
    //Connect with gui (Dialog pane)
    public StoreObject sellItem(int money, String name){
        return sellItem(storeItems,money,name);
    }
    private StoreObject sellItem(StoreObject storeItems,int money, String name){
        if (storeItems!=null &&(storeItems.getName().equals(name)) && (money >= storeItems.getPrice())) {
            return storeItems;
        }else{
            return sellItem(storeItems.getNext(),money,name);
        }

    }

    public void addStoreObject(StoreObject newObject){
        if(storeItems == null){
            storeItems = newObject;
        }else{
            StoreObject last = storeItems;
            while (last.getNext()!=null){
                last = last.getNext();
            }
            last.setNext(newObject);
        }
    }

    public StoreObject getStoreItems() {
        return storeItems;
    }

    /**
     *  for(StoreObject storeObject : storeItems){
     *             if ((storeObject.getName().equals(name)) && (money >= storeObject.getPrice())) {
     *                 ret = storeObject;
     *                 break;
     *             }
     *         }
     */


}
