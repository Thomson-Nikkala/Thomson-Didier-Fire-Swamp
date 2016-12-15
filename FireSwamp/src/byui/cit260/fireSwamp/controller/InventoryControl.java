/***************************************************
 * InventoryControl Class                          *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.controller;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */

import byui.cit260.fireSwamp.enums.ItemType;
import byui.cit260.fireSwamp.exceptions.InventoryControlException;
import byui.cit260.fireSwamp.model.Item;
import byui.cit260.fireSwamp.model.Player;
import java.util.ArrayList;



public class InventoryControl {
    
     /**********************************************
     * checkInventory function (Nikkala)
     * checks if the desired item is present in the inventory
     * @param inventory
     * @param itemType
     * @return index of the item in the list
     * @throws byui.cit260.fireSwamp.exceptions.InventoryControlException
     **********************************************/
    public int checkInventory(ArrayList<Item> inventory, ItemType itemType) 
            throws InventoryControlException {

        int found = -1;
        //for each loop
        for (Item item : inventory) {
            //check for position of item in the list
            if (item.getItemType() == itemType) {
                found = inventory.indexOf(item);  //index of item in the list
            }
        }
        //if no such item found
        if (found != -1) {
            return found;
        }
        else {
            throw new InventoryControlException("Item not found in inventory.");
        }
        
    }   
    
    public static void addItemToInventory(Item item, Player player)
        throws InventoryControlException {
        
        //make new item identical to the one passed in
        Item newItem = new Item();
       
        newItem.setItemDescription(item.getItemDescription());
        newItem.setItemName(item.getItemName());
        newItem.setItemType(item.getItemType());

        //add item to inventory
        ArrayList<Item> playerInventory = player.getPlayerInventory();
        if (!playerInventory.add(newItem)) {
            throw new InventoryControlException("Unable to add item to inventory.");
        }
        else {
            player.setPlayerInventory(playerInventory);
        }
        
    }  
        
}
