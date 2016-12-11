/** *************************************************
 * MapControl Class                                *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.controller;

import byui.cit260.fireSwamp.enums.DangerType;
import byui.cit260.fireSwamp.exceptions.MapControlException;
import byui.cit260.fireSwamp.model.Item;
import byui.cit260.fireSwamp.model.Location;
import byui.cit260.fireSwamp.model.Map;
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
    
    public static String checkLook(Location testLocation, Map map) throws MapControlException {
        String string = "";
        
        //check for nearby LightningSand
        int row = testLocation.getLocationRow();
        int col = testLocation.getLocationColumn();
        
        //check west
        if (row > 0) {
            if (map.getLocationAt(row-1, col).getLocationType() == DangerType.LIGHTNINGSAND) {
                string = string + "\nYou see a strange patch of sand to the west.";
            }
        }
        //check east
        if (row < (Map.ROWS-1)) {
            if (map.getLocationAt(row+1, col).getLocationType() == DangerType.LIGHTNINGSAND) {
                string = string + "\nYou see a strange patch of sand to the east.";
            }
        }
        //check north
        if (col > 0) {
            if (map.getLocationAt(row, col-1).getLocationType() == DangerType.LIGHTNINGSAND) {
                string = string + "\nYou see a strange patch of sand to the north.";
            }   
        }
        //check south
        if (col < (Map.COLUMNS-1)) {
            if (map.getLocationAt(row, col+1).getLocationType() == DangerType.LIGHTNINGSAND) {
                string = string + "\nYou see a strange patch of sand to the south.";
            }           
        }
        //check for item at location
        return string;
    }
    
    public static String checkSmell(Location testLocation, Map map) throws MapControlException{
        String string = "";
        //check for nearby ROUS
        int row = testLocation.getLocationRow();
        int col = testLocation.getLocationColumn();
        
        //check west
        if (row > 0) {
            if (map.getLocationAt(row-1, col).getLocationType() == DangerType.ROUS) {
                string = string + "\nYou smell an odor reminiscent of wet dog and rotting garbage wafting from the west.";
            }
        }
        //check east
        if (row < (Map.ROWS-1)) {
            if (map.getLocationAt(row+1, col).getLocationType() == DangerType.ROUS) {
                string = string + "\nYou smell an odor reminiscent of wet dog and rotting garbage wafting from the east.";
            }
        }
        //check north
        if (col > 0) {
            if (map.getLocationAt(row, col-1).getLocationType() == DangerType.ROUS) {
                string = string + "\nYou smell an odor reminiscent of wet dog and rotting garbage wafting from the north.";
            }   
        }
        //check south
        if (col < (Map.COLUMNS-1)) {
            if (map.getLocationAt(row, col+1).getLocationType() == DangerType.ROUS) {
                string = string + "\nYou smell an odor reminiscent of wet dog and rotting garbage wafting from the south.";
            }           
        }
        return string;
        
    }
    
    public static String checkListen(Location testLocation, Map map) throws MapControlException {
        String string = "";
        //check for nearby Fire Spurt
        //check for nearby LightningSand
        int row = testLocation.getLocationRow();
        int col = testLocation.getLocationColumn();
        
        //check west
        if (row > 0) {
            if (map.getLocationAt(row-1, col).getLocationType() == DangerType.FLAMESPURT) {
                string = string + "\nYou hear .";
            }
        }
        //check east
        if (row < (Map.ROWS-1)) {
            if (map.getLocationAt(row+1, col).getLocationType() == DangerType.FLAMESPURT) {
                string = string + "\nYou see a strange patch of sand to the east.";
            }
        }
        //check north
        if (col > 0) {
            if (map.getLocationAt(row, col-1).getLocationType() == DangerType.FLAMESPURT) {
                string = string + "\nYou see a strange patch of sand to the north.";
            }   
        }
        //check south
        if (col < (Map.COLUMNS-1)) {
            if (map.getLocationAt(row, col+1).getLocationType() == DangerType.FLAMESPURT) {
                string = string + "\nYou see a strange patch of sand to the south.";
            }           
        }
        return string;
        
    }

}
