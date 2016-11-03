/***************************************************
 * HelpMenuView Class                              *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.view;

import java.util.Scanner;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class HelpMenuView {
    
    private String prompt;   

    // Constructor
    public HelpMenuView() {
        
        this.prompt = "Please enter your choice: ";
        // display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
                    "\n******************************************************"
                 +  "\n* HELP MENU                                          *"
                 +  "\n* M - Movements                                      *"
                 +  "\n* I - Inventory management                           *"
                 +  "\n* C - Clues                                          *"
                 +  "\n* D - Dangers                                        *"
                 +  "\n* B - Back                                           *"
                 +  "\n******************************************************");
    }
    public void displayMenu() {
        
        boolean done = false;
        do {
            //prompt for and get player's menu choice
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("B")) {
                return;
            }

            done = this.doAction(menuOption);

        } while (!done);
        
    }
    
    private String getMenuOption() {
        
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.print("\n" + this.prompt);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) 
                System.out.println("\nInvalid value: value can not be blank");
            else
                valid = true;
        }
        
        return value;
    }

    private boolean doAction(String choice) {
        
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
        helpInventory.displayMenu();
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
