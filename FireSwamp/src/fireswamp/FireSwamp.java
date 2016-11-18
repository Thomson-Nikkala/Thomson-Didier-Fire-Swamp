/** *************************************************
 * FireSwamp Class                                  *
 *                                                  *
 ************************************************** */
package fireswamp;

import byui.cit260.fireSwamp.model.*;
import byui.cit260.fireSwamp.view.*;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class FireSwamp {

    private static Game currentGame = null;
    private static Player player = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        FireSwamp.currentGame = currentGame;
    }

    /**
     * @param player
     */
    public static void setPlayer(Player player) {
        FireSwamp.player = player;
    }

    public static Player getPlayer() {
        return FireSwamp.player;
    }

    public static void main(String[] args) {

        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
    }

}
