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

    public HelpMenuView() {
        
        
        // display the banner when view is created
        this.displayMenu();
    }

    private void displayMenu() {
        
        prompt = "Please enter your choice: ";
        
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
    
    private String getMenuOption() {
        
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.print("\n" + this.prompt);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break;
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
            case "B":
                this.goBack();
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
        System.out.println("\n*** displayHelpInventory() function called ***");
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
