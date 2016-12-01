/***************************************************
 * MainMenuView Class                              *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.view;


import byui.cit260.fireSwamp.controller.GameControl;
import byui.cit260.fireSwamp.controller.MapControl;
import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.exceptions.MapControlException;
import byui.cit260.fireSwamp.model.Location;
import fireswamp.FireSwamp;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                try {
                    this.startNewGame();
                } catch (MapControlException me) {
                    System.out.println("me.getMessage()");
                }
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

    private void startNewGame() throws MapControlException {
        GameControl gc = new GameControl();
        gc.createNewGame(FireSwamp.getPlayer());
        Location initPos = new Location();
        initPos.setLocationColumn(0);
        initPos.setLocationRow(3);
        FireSwamp.getPlayer().setPlayerPosition(initPos);
        GameMenuView gameMenu = new GameMenuView();
        try {
            gameMenu.display();
        } catch (GameControlException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
