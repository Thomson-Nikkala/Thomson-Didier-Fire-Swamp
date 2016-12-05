/** *************************************************
 * MapControl Class                                *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.controller;

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

    public boolean checkLook(Location testLocation) {
        return true;
    }

}
