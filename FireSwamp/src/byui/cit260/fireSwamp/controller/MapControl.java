/** *************************************************
 * MapControl Class                                *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.controller;

import byui.cit260.fireSwamp.exceptions.MapControlException;
import byui.cit260.fireSwamp.model.Item;
import byui.cit260.fireSwamp.model.Location;
import byui.cit260.fireSwamp.model.Player;

/**
 *
 * @authors Didier Jourdain
 */
public class MapControl {

    public void movePlayerStartingLocation(Player player, Location startingLocation) {
        player.setPlayerPosition(startingLocation);

    }

    /**
     *
     * @param location
     * @throws MapControlException
     */
    public static boolean checkForItem(Location location) throws MapControlException {
        Item item = location.getItem();
        if (item == null) {
            throw new MapControlException("There is no item at this location.");
        } 
        return true;
    }
    
    
    public static void deleteItemFromLocation(Location location) {
        location.setItem(null);
    }
    
    public boolean checkLook(Location testLocation) {
        return true;
    }

}
