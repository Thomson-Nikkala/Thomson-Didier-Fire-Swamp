/***************************************************
 * MainMenuView Class                              *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.view;


import byui.cit260.fireSwamp.controller.GameControl;
import fireswamp.FireSwamp;
import java.util.Scanner;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class MainMenuView extends View {

    //Constructor
    public MainMenuView() {
        super("\n"
                  + "\n------------------------------------------------------"
                  + "\n| Main Menu                                          |"
                  + "\n------------------------------------------------------"
                  + "\nN - Start new game"
                  + "\nL - Load saved game"
                  + "\nX - eXit game"
                  + "\n------------------------------------------------------"
                  + "\n\nEnter command: ");
    }

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase();
        
        switch (value) {
            case "N":
                this.startNewGame();
                break;
            case "L":
                this.loadSavedGame();
                break;
            case "X":
                this.exitGame();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }



    private void loadSavedGame() {
        System.out.println("*** loadSavedGame() function called");
    }

    private void exitGame() {
        System.out.println("Do you wish to save the game before exiting?  Y/N");
        //More to come here
        System.exit(0);
    }

    private void startNewGame() {
        GameControl.createNewGame(FireSwamp.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
    
}
