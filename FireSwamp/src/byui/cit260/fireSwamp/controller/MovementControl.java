/***************************************************
 * MovementControl Class                           *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.controller;

import byui.cit260.fireSwamp.enums.Direction;
import byui.cit260.fireSwamp.exceptions.MovementControlException;
import byui.cit260.fireSwamp.model.*;
import fireswamp.FireSwamp;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class MovementControl {
    
    
    public static void movePlayerDirection(Player player, Direction direction) 
                        throws MovementControlException {
        
        Map map = FireSwamp.getCurrentGame().getGameMap();
        Location playerLocation = FireSwamp.getPlayer().getPlayerPosition();
        switch (direction) {
            case NORTH:
                if (playerLocation.getLocationRow()== 0) {
                    throw new MovementControlException("\n## Can not go "
                                                + direction.toString()
                                                + " because that location is outside "
                                                + "the bounds of the map.");
                }
                else {
                    playerLocation.setLocationRow(playerLocation.getLocationRow()- 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                /*    this.console.println("\n** " + FireSwamp.getPlayer().getPlayerName()
                                     + " moved " + direction.toString()); */
                }
                break;
            case SOUTH:
                if (playerLocation.getLocationRow()== Map.ROWS - 1) {
                    throw new MovementControlException("\n## Can not go "
                                                + direction.toString()
                                                + " because that location is outside "
                                                + "the bounds of the map.");
                }
                else {
                    playerLocation.setLocationRow(playerLocation.getLocationRow()+ 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                /*    this.console.println("\n** " + FireSwamp.getPlayer().getPlayerName()
                                     + " moved " + direction.toString()); */
                }
                break;
            case WEST:
                if (playerLocation.getLocationColumn() == 0) {
                    throw new MovementControlException("\n## Can not go "
                                                + direction.toString()
                                                + " because that location is outside "
                                                + "the bounds of the map.");
                }
                else {
                    playerLocation.setLocationColumn(playerLocation.getLocationColumn() - 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                 /*    this.console.println("\n** " + FireSwamp.getPlayer().getPlayerName()
                                     + " moved " + direction.toString());  */
                }
                break;
            case EAST:
                if (playerLocation.getLocationColumn() == Map.COLUMNS - 1) {
                    throw new MovementControlException("\n## Can not go "
                                                + direction.toString()
                                                + " because that location is outside "
                                                + "the bounds of the map.");
                }
                else {
                    playerLocation.setLocationColumn(playerLocation.getLocationColumn() + 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                /*    this.console.println("\n** " + FireSwamp.getPlayer().getPlayerName()
                                     + " moved " + direction.toString()); */
                }
                break;
        }
        
    }
}
