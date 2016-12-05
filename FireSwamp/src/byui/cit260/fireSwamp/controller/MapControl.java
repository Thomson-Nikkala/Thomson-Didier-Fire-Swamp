/***************************************************
 * MapControl Class                                *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.controller;

import byui.cit260.fireSwamp.enums.Direction;
import byui.cit260.fireSwamp.exceptions.MapControlException;
import byui.cit260.fireSwamp.model.Location;
import byui.cit260.fireSwamp.model.Map;
import byui.cit260.fireSwamp.model.Player;
import fireswamp.FireSwamp;

/**
 *
 * @authors Didier Jourdain
 */
public class MapControl {
    
    
    
    public void movePlayerStartingLocation(Player player, Location startingLocation) {
       player.setPlayerPosition(startingLocation);
        
    }
        
    
    public boolean checkLook (Location testLocation) {
        return true;
    }
    
    
    
}
