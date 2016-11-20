/***************************************************
 * InventoryControl Class                          *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.controller;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */

import byui.cit260.fireSwamp.model.Item;
import java.util.ArrayList;

public class InventoryControl {
    
    /**********************************************
    * checkInventory function (Nikkala)
    * checks if the desired item is present in the inventory
    * if it is present, it returns the position of the item in the list (index)
    **********************************************/
        public int checkInventory(ArrayList<Item> inventory, int itemType) {

        //for each loop
        for (Item item : inventory) {
            //check for position of item in the list
            if (item.getItemType() == itemType) {
                return inventory.indexOf(item);
            }
        }
        //if no such item found
        return -1;
    }   
    
}
