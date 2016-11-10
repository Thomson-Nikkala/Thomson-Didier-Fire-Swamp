/** *************************************************
 * StartProgramView Class                          *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.GameControl;
import byui.cit260.fireSwamp.model.Player;
import java.util.Scanner;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class StartProgramView extends View {

    // Constructor
    public StartProgramView() {

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
    public boolean doAction(String value) {

        if (value.length() < 2) {
            System.out.println("\nInvalid player name: "
                + "The name must be greater than one character in length");
            return false;
        }

        Player player = GameControl.createPlayer(value);

        if (player == null) {
            System.out.println("\nError creating the player.");
            return false;
        }

        this.displayNextView(player);

        return true;
    }

    private void displayNextView(Player player) {

        System.out.println(
            "\n==============================================="
            + "\n     Welcome to the game " + player.getPlayerName()
            + "\n       We hope you have a lot of fun!"
            + "\n==============================================="
        );

        MainMenuView mainMenuView = new MainMenuView();

        mainMenuView.display();
    }

}
