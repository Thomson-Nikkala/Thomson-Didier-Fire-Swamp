/** *************************************************
 * MovementControl Class                           *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.controller;

import byui.cit260.fireSwamp.enums.DangerType;
import byui.cit260.fireSwamp.enums.Direction;
import byui.cit260.fireSwamp.exceptions.DangerControlException;
import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.exceptions.MovementControlException;
import byui.cit260.fireSwamp.model.*;
import byui.cit260.fireSwamp.view.*;
import fireswamp.FireSwamp;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class MovementControl {

    public static void movePlayerDirection(Player player, Direction direction)
            throws MovementControlException, DangerControlException, GameControlException {

        Map map = FireSwamp.getCurrentGame().getGameMap();
        Location playerLocation = FireSwamp.getPlayer().getPlayerPosition();

        switch (direction) {
            case NORTH:
                if (playerLocation.getLocationRow() == 0) {
                    throw new MovementControlException("\n## Can not go "
                            + direction.toString()
                            + " because that location is outside "
                            + "the bounds of the map.");
                } else {
                    //check if player has reached the exit
                    if ((playerLocation.getLocationColumn() == map.getMapExitColumn())
                            && (playerLocation.getLocationRow() == map.getMapExitRow())) {
                        WinGameView winView = new WinGameView();
                        winView.display();
                    }
                    playerLocation.setLocationRow(playerLocation.getLocationRow() - 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                    //set current location to "visited"
                    FireSwamp.getCurrentGame().getGameMap().getLocationAt(playerLocation.getLocationRow(), playerLocation.getLocationColumn()).setLocationVisited(true);
                }
                break;
            case SOUTH:
                if (playerLocation.getLocationRow() == Map.ROWS - 1) {
                    throw new MovementControlException("\n## Can not go "
                            + direction.toString()
                            + " because that location is outside "
                            + "the bounds of the map.");
                } else {
                    //check if player has reached the exit
                    if ((playerLocation.getLocationColumn() == map.getMapExitColumn())
                            && (playerLocation.getLocationRow() == map.getMapExitRow())) {
                        WinGameView winView = new WinGameView();
                        winView.display();
                    }
                    playerLocation.setLocationRow(playerLocation.getLocationRow() + 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                    //set current location to "visited"
                    FireSwamp.getCurrentGame().getGameMap().getLocationAt(playerLocation.getLocationRow(), playerLocation.getLocationColumn()).setLocationVisited(true);
                }
                break;
            case WEST:
                if (playerLocation.getLocationColumn() == 0) {
                    throw new MovementControlException("\n## Can not go "
                            + direction.toString()
                            + " because that location is outside "
                            + "the bounds of the map.");
                } else {
                    //no need to check if player reached the exit if going west
                    playerLocation.setLocationColumn(playerLocation.getLocationColumn() - 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                    //set current location to "visited"
                    FireSwamp.getCurrentGame().getGameMap().getLocationAt(playerLocation.getLocationRow(), playerLocation.getLocationColumn()).setLocationVisited(true);
                }
                break;
            case EAST:
                if (playerLocation.getLocationColumn() == Map.COLUMNS - 1) {
                    throw new MovementControlException("\n## Can not go "
                            + direction.toString()
                            + " because that location is outside "
                            + "the bounds of the map.");
                } else {
                    //check if player has reached the exit
                    if ((playerLocation.getLocationColumn() == map.getMapExitColumn())
                            && (playerLocation.getLocationRow() == map.getMapExitRow())) {
                        WinGameView winView = new WinGameView();
                        winView.display();
                    }
                    playerLocation.setLocationColumn(playerLocation.getLocationColumn() + 1);
                    FireSwamp.getPlayer().setPlayerPosition(playerLocation);
                    //set current location to "visited"
                    FireSwamp.getCurrentGame().getGameMap().getLocationAt(playerLocation.getLocationRow(), playerLocation.getLocationColumn()).setLocationVisited(true);
                }
                break;
        }

        int row = playerLocation.getLocationRow();
        int col = playerLocation.getLocationColumn();
        DangerType whatDanger = map.getLocationAt(row, col).getDanger().getDangerType();

        if (whatDanger != DangerType.NONE) {

            switch (whatDanger) {

                case FLAMESPURT:
                    DangerControl fsDangerControl = new DangerControl();
                    double fsLength = fsDangerControl.generateDouble(3, 99);
                    double fsWidth = fsDangerControl.generateDouble(3, 99);
                    double fsHeight = fsDangerControl.generateDouble(3, 99);
                    FlameSpurtView fsvChallenge = new FlameSpurtView(fsLength, fsWidth, fsHeight);
                    fsvChallenge.display();
                    break;
                case ROUS:
                    DangerControl rousDangerControl = new DangerControl();
                    double rousLength = rousDangerControl.generateDouble(1, 15);
                    RousView rousChallenge = new RousView(rousLength);
                    rousChallenge.display();
                    break;
                case LIGHTNINGSAND:
                    DangerControl lsDangerControl = new DangerControl();
                    double diameter = lsDangerControl.generateDouble(1, 30);
                    LightningSandView lsvChallenge = new LightningSandView(diameter);
                    lsvChallenge.display();
                    break;
                default:
                    break;
            }
        } else {

        }

    }
}
