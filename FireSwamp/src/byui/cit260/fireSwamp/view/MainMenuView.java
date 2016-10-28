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
public class MainMenuView {

    private String menu;
    private String prompt;
    
    public MainMenuView() {
        this.menu = "\n"
                  + "\n------------------------------------------------------"
                  + "\n| Main Menu                                          |"
                  + "\n------------------------------------------------------"
                  + "\nN - Start new game"
                  + "\nL - Load saved game"
                  + "\nX - eXit game"
                  + "\n------------------------------------------------------";
        
        this.prompt = this.menu + "\n\nPLease enter your choice: ";
        
    }

    public void displayMainMenuView() {
        
        boolean done = false;
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("X"))
                return;
            
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
        System.out.println("*** exitGame() function called");
    }

    private void startNewGame() {
        GameControl.createNewGame(FireSwamp.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }
    
}
