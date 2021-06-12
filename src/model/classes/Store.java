package model.classes;

import exception.IsSaledException;
import exception.NotTrabableException;
import model.abstractClasses.StoreObject;
import model.interfaces.Tradable;

import java.io.Serializable;

/**
 * The type Store.
 */
public class Store implements Serializable {

   // private ArrayList<StoreObject> storeItems;
    private StoreObject storeItems;

    /**
     * Instantiates a new Store.
     *
     * @param storeItems the store items
     */
    public Store(StoreObject storeItems) {
        this.storeItems = storeItems;
    }


    /**
     * Sell item store object.
     *
     * @param money the money
     * @param name  the name
     * @return the store object
     * @throws NotTrabableException the not trabable exception
     * @throws IsSaledException     the is saled exception
     */
//Connect with gui (Dialog pane)
    public StoreObject sellItem(double money, String name) throws NotTrabableException, IsSaledException {
        return sellItem(storeItems,money,name);
    }

    private StoreObject sellItem(StoreObject storeItems,double money, String name) throws NotTrabableException, IsSaledException {
        if (storeItems!=null &&(storeItems.getName().equals(name)) && (money >= storeItems.getPrice())) {
            if(storeItems instanceof Tradable && !storeItems.isSaled() ){
                storeItems.setSaled(true);
                return storeItems;
            }else if (storeItems.isSaled()){
                throw new IsSaledException();
            }else {
                throw new NotTrabableException();
            }
        }else if(storeItems==null){
            return null;
        }else{
            return sellItem(storeItems.getNext(),money,name);
        }

    }

    /**
     * Add store object.
     *
     * @param newObject the new object
     */
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

    /**
     * Gets store items.
     *
     * @return the store items
     */
    public StoreObject getStoreItems() {
        return storeItems;
    }



}
