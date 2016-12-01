/***************************************************
 * HelpMenuView Class                              *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class HelpMenuView extends View { 

    // Constructor
    public HelpMenuView() {
        
    super("\n******************************************************"
                 +  "\n* HELP MENU                                          *"
                 +  "\n* M - Movements                                      *"
                 +  "\n* I - Inventory management                           *"
                 +  "\n* C - Clues                                          *"
                 +  "\n* D - Dangers                                        *"
                 +  "\n* B - Back                                           *"
                 +  "\n******************************************************"
            + "\n\n Enter command: ");
    }
  
   @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "M":
                this.displayHelpMovement();
                break;
            case "I":
                this.displayHelpInventory();
                break;
            case "C":
                this.displayHelpClues();
                break;
            case "D":
                this.displayHelpDangers();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void displayHelpMovement() {
        System.out.println("\n*** displayHelpMovement() function called ***");
    }

    private void displayHelpInventory() {
        HelpInventoryView helpInventory = new HelpInventoryView();
        try {
            helpInventory.display();
        } catch (GameControlException ex) {
            Logger.getLogger(HelpMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayHelpClues() {
        System.out.println("\n*** displayHelpClues() function called ***");
    }

    private void displayHelpDangers() {
        System.out.println("\n*** displayHelpDangers() function called ***");
    }

    private void goBack() {
        System.out.println("\n*** goBack() function called ***");
    }
    
}
