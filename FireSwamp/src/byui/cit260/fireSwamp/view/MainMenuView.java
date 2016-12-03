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
                  + "\nS - Save game"
                  + "\nX - eXit game"
                  + "\n------------------------------------------------------"
                  + "\n\nEnter command: ");
    }

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase();
        
        switch (value) {
            case "N":  // Start new game
                try {
                    this.startNewGame();
                } catch (MapControlException me) {
                    ErrorView.display(this.getClass().getName(), me.getMessage());
                }
                break;
            case "L":  // Load saved game
                this.loadSavedGame();
                break;
            case "S":  // save Game
                this.saveGame();
                break;
            case "X":  // exit Game
                this.exitGame();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }



    private void loadSavedGame() {
        // prompt for and get the name of the file to be saved
        this.console.println("\n\nEnter the file path for the saved game (including the saved game name)");
        
        String filePath = this.getInput();
        
        try {
            //get the saved game
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    private void exitGame() {
        this.console.println("Do you wish to save the game before exiting?  Y/N");
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

    private void saveGame() {
        //prompt for and get the name of the file path for saving
        this.console.println("\n\nEnter the file path for the file where the game is to be saved");
        String filePath = this.getInput();
        
        try {
            //save the game to the specified file
            GameControl.saveGame(FireSwamp.getCurrentGame(), filePath);
            
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
    
}
