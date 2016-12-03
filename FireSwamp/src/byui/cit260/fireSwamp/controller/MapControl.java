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
    
    public static void movePlayerDirection(Player player, Direction direction) 
                        throws MapControlException {
        
        Map map = FireSwamp.getCurrentGame().getGameMap();
        Location playerLocation = FireSwamp.getPlayer().getPlayerPosition();
        switch (direction) {
            case NORTH:
                if (playerLocation.getLocationRow()== 0) {
                    throw new MapControlException("\n## Can not go "
                                                + direction.toString()
                                                + " because that location is outside "
                                                + "the bounds of the map.");
                }
                else {
                    playerLocation.setLocationRow(playerLocation.getLocationRow()- 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                    this.console.println("\n** " + FireSwamp.getPlayer().getPlayerName()
                                     + " moved " + direction.toString());
                }
                break;
            case SOUTH:
                if (playerLocation.getLocationRow()== Map.ROWS - 1) {
                    throw new MapControlException("\n## Can not go "
                                                + direction.toString()
                                                + " because that location is outside "
                                                + "the bounds of the map.");
                }
                else {
                    playerLocation.setLocationRow(playerLocation.getLocationRow()+ 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                    this.console.println("\n** " + FireSwamp.getPlayer().getPlayerName()
                                     + " moved " + direction.toString());
                }
                break;
            case WEST:
                if (playerLocation.getLocationColumn() == 0) {
                    throw new MapControlException("\n## Can not go "
                                                + direction.toString()
                                                + " because that location is outside "
                                                + "the bounds of the map.");
                }
                else {
                    playerLocation.setLocationColumn(playerLocation.getLocationColumn() - 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                    this.console.println("\n** " + FireSwamp.getPlayer().getPlayerName()
                                     + " moved " + direction.toString());
                }
                break;
            case EAST:
                if (playerLocation.getLocationColumn() == Map.COLUMNS - 1) {
                    throw new MapControlException("\n## Can not go "
                                                + direction.toString()
                                                + " because that location is outside "
                                                + "the bounds of the map.");
                }
                else {
                    playerLocation.setLocationColumn(playerLocation.getLocationColumn() + 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                    this.console.println("\n** " + FireSwamp.getPlayer().getPlayerName()
                                     + " moved " + direction.toString());
                }
                break;
        }
        
    }
    
    public void movePlayerStartingLocation(Player player, Location startingLocation) {
       player.setPlayerPosition(startingLocation);
        
    }
        
    
    public boolean checkLook (Location testLocation) {
        return true;
    }
    
    
    
}
