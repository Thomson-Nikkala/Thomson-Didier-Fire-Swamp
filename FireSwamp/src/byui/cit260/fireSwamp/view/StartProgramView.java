/** *************************************************
 * StartProgramView Class                          *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.GameControl;
import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.model.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class StartProgramView extends View {

    // Constructor
    public StartProgramView() throws GameControlException {

        super(
            "\n******************************************************"
            + "\n*                                                    *"
            + "\n* Can you survive the fire swamp?                    *"
            + "\n* Test your deduction and math skills as you         *"
            + "\n* navigate the hazards of the most dangerous place   *"
            + "\n* in Florin.                                         *"
            + "\n*                                                    *"
            + "\n******************************************************"
            + "\n\nPlease enter your name: ");
    }

    @Override
    public boolean doAction(String value) throws GameControlException {

        if (value.length() < 2) {
            throw new GameControlException("\nInvalid player name: "
                + "The name must be greater than one character in length");
        }

        Player player = GameControl.createPlayer(value);

        if (player == null) {
            throw new GameControlException("\nError creating the player.");
        }

        this.displayNextView(player);

        return true;
    }

    private void displayNextView(Player player) {

        this.console.println(
            "\n==============================================="
            + "\n     Welcome to the game " + player.getPlayerName()
            + "\n     We hope you have a lot of fun!"
            + "\n==============================================="
        );

        MainMenuView mainMenuView = new MainMenuView();

        try {
            mainMenuView.display();
        } catch (GameControlException ex) {
            Logger.getLogger(StartProgramView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
